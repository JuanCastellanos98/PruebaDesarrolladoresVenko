package com.venko.prueba.ConfigSecurity;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		AuthCredentials authCredentials = new AuthCredentials();
		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
		} catch (IOException e) {
			// TODO: handle exception
		}
		UsernamePasswordAuthenticationToken usernamePAT= new UsernamePasswordAuthenticationToken(
				authCredentials.getCc(), 
				authCredentials.getPassword(),
				Collections.emptyList());
		return getAuthenticationManager().authenticate(usernamePAT);
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		UserDetailsImpl userDetailsImpl =(UserDetailsImpl) authResult.getPrincipal();
		String token= TokenUtils.createToken(userDetailsImpl.getNombre(), userDetailsImpl.getUsername());
		response.addHeader("Authorization", "Bearer"+token);
		response.getWriter().flush();
				
		super.successfulAuthentication(request, response, chain, authResult);
	}

}
