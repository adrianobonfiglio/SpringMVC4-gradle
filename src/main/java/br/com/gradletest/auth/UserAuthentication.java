package br.com.gradletest.auth;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

@Component
public class UserAuthentication implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		System.out.println(".....trying auth......");
		List<Perfil> perfis = new ArrayList<Perfil>();
		perfis.add(new Perfil());
		try {
			isAuthenticatedInRedmine("adriano", "adri77");
		} catch (IOException e) {
			e.printStackTrace();
		}
		User user = new User("adriano", "adriano", perfis);
		return new UsernamePasswordAuthenticationToken(user,"adriano");
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	
	public boolean isAuthenticatedInRedmine(String username, String password) throws IOException {
		String webPage = "http://172.20.1.44:3000";

		String authString = username + ":" + password;
		System.out.println("auth string: " + authString);
		byte[] authEncBytes = Base64.encode(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		System.out.println("Base64 encoded auth string: " + authStringEnc);

		URL url = new URL(webPage);
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		url.get
		InputStream is = urlConnection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);

		int numCharsRead;
		char[] charArray = new char[1024];
		StringBuffer sb = new StringBuffer();
		while ((numCharsRead = isr.read(charArray)) > 0) {
			sb.append(charArray, 0, numCharsRead);
		}
		String result = sb.toString();
		return false;
	}

}