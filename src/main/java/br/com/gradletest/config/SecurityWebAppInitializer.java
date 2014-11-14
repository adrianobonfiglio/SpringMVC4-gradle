package br.com.gradletest.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author Adriano S. Bonfiglio
 *
 */
public class SecurityWebAppInitializer extends
		AbstractSecurityWebApplicationInitializer {

	/**
     * 
     */
	public SecurityWebAppInitializer() {
		super(SecurityConfig.class);
	}

}
