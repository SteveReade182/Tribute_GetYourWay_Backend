package com.sky.getyourway;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.sky.getyourway.service.AuthenticationService;

// GenericFilterBean is a generic superclass for any type of filter
// This will handle authentication for all endpoints except /login
// Our LoginFilter bean manages that endpoint
public class AuthenticationFilter extends GenericFilterBean{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) 
			throws IOException, ServletException 
	{
		// get the JWT token from the Authorization header by calling getAuthentication on our service bean
	Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest)request);
	SecurityContextHolder.getContext().
	setAuthentication(authentication);
	filterChain.doFilter(request, response);
	}
}
