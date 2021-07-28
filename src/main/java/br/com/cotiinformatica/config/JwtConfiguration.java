package br.com.cotiinformatica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.cotiinformatica.filters.JWTAuthorizationFilter;

@Configuration 
@EnableWebSecurity 
public class JwtConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().addFilterAfter(
				new JWTAuthorizationFilter(), 
				UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/clientes").permitAll() 
				.antMatchers("/api/produtos/**").permitAll()
				.antMatchers("/api/auth").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**")
				.permitAll() 
				.anyRequest()
				.authenticated();		
	}	
	
	private static final String[] SWAGGER = {
	            // -- Swagger UI v2
	            "/v2/api-docs",
	            "/swagger-resources",
	            "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui.html",
	            "/webjars/**",
	            // -- Swagger UI v3 (OpenAPI)
	            "/v3/api-docs/**",
	            "/swagger-ui/**"
	            // other public endpoints 
	            //of your API may be appended to this array
	 };
		
	@Override
	public void configure(WebSecurity web) throws Exception {
	     web.ignoring().antMatchers(SWAGGER);
	}
}

