package br.com.gradletest.auth;

import org.springframework.security.core.GrantedAuthority;

public class Perfil implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return "ROLE_ADMIN";
	}

}
