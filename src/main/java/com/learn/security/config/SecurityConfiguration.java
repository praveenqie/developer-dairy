package com.learn.security.config;

import static com.learn.security.enumtype.Permission.ADMIN_CREATE;
import static com.learn.security.enumtype.Permission.ADMIN_DELETE;
import static com.learn.security.enumtype.Permission.ADMIN_READ;
import static com.learn.security.enumtype.Permission.ADMIN_UPDATE;
import static com.learn.security.enumtype.Permission.MANAGER_CREATE;
import static com.learn.security.enumtype.Permission.MANAGER_DELETE;
import static com.learn.security.enumtype.Permission.MANAGER_READ;
import static com.learn.security.enumtype.Permission.MANAGER_UPDATE;
import static com.learn.security.enumtype.Role.ADMIN;
import static com.learn.security.enumtype.Role.MANAGER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

	@Autowired
	private JwtAuthenticationFilter jwtAuthFilter;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private LogoutHandler logoutHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
				.requestMatchers("auth/**", "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**",
						"/swagger-resources", "/swagger-resources/**", "/configuration/ui", "/configuration/security",
						"/swagger-ui/**", "/webjars/**", "/swagger-ui.html")
				.permitAll()
				.requestMatchers(GET,  "/api/v1").authenticated()
				.requestMatchers(PUT,  "/api/v1/**").authenticated()
				.requestMatchers(DELETE,  "/api/v1/**").authenticated()
				.requestMatchers(POST,  "/api/v1/**").authenticated()
				.requestMatchers(GET,  "/api/v1").permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).logout()
				.logoutUrl("/api/v1/auth/logout").addLogoutHandler(logoutHandler)
				.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());

		return http.build();
	}

//	@Bean
//	public AuthenticationFailureHandler authenticationFailureHandler() {
//		return new CustomAuthenticationFailureHandler();
//	}
//
//	@Bean
//	public AuthenticationSuccessHandler authenticationSuccessHandler() {
//		return new CustomAuthenticationSuccessHandler();
//	}
//
//	@Bean
//	public AccessDeniedHandler accessDeniedHandler() {
//		return new CustomAccessDeniedHandler();
//	}
}
