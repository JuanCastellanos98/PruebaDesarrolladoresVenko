package com.venko.prueba.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatchers;

@Configuration
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic().and().authorizeHttpRequests().requestMatchers(HttpMethod.POST).hasRole("ADMIN").requestMatchers(HttpMethod.GET).authenticated().and().csrf().disable().build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// var user=
		// User.withUsername("uncledave").password("password123").authorities("write").build();
		return new InMemoryUserDetailsManager(User.withUsername("juan")
				.password(passwordEncoder().encode("password123")).authorities("read", "write", "ROLE_ADMIN").build());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

}
