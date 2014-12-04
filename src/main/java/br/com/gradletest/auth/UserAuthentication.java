package br.com.gradletest.auth;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAuthentication implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		System.out.println(".....trying auth......");
		List<Perfil> perfis = new ArrayList<Perfil>();
		perfis.add(new Perfil());
		System.out.println(auth.getCredentials());
		if(auth.getCredentials() != null && auth.getCredentials() != null) {
			boolean isAuth = isAuthenticatedInRedmine(auth.getPrincipal().toString(), auth.getCredentials().toString());
		}
		if (!isAuth) {
			throw new AuthenticationCredentialsNotFoundException("usuario não encontrado");
		}
		User user = new User("adriano", "adriano", perfis);
		return new UsernamePasswordAuthenticationToken(user, "adriano");
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication));
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean isAuthenticatedInRedmine(String username, String password) {
		String urlRedmine = "http://172.20.1.44:3000/";
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		 
		HttpResponse response;
		try {
			response = client.execute(new HttpGet(urlRedmine));
			int statusCode = response.getStatusLine().getStatusCode();
			return HttpStatus.OK.value() == statusCode;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
}