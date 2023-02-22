package com.sky.getyourway;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.getyourway.domain.AccountCredentials;
import com.sky.getyourway.service.AuthenticationService;

// this filter handles POST requests to the /login endpoint
public class LoginFilter extends AbstractAuthenticationProcessingFilter{

	protected LoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}
	// AntPathRequestMatcher is a matcher which compares a pre-defined ant-style pattern against the URL
	// ( servletPath + pathInfo) of an HttpServletRequest. The query string of the URL is ignored 
	// and matching is case-insensitive or case-sensitive depending on the arguments passed into 
	// the constructor.
	
	// Authentication is performed by the attemptAuthentication method, 
	// which must be implemented by subclasses.
	@Override
	public Authentication attemptAuthentication( HttpServletRequest req, HttpServletResponse res)
	throws AuthenticationException, IOException, ServletException
	{
		// reads the input stream and creates our AccountCredentials object from the values
	AccountCredentials creds = new ObjectMapper()
			.readValue(req.getInputStream(), AccountCredentials.class);
	return getAuthenticationManager().authenticate( // calls authenticate with the credential's name and password
		new UsernamePasswordAuthenticationToken(
			creds.getUsername(),
			creds.getPassword(),
			Collections.emptyList()
		)
	);
	}

	//Subclasses can override this method to continue the FilterChain after successful authentication.
	// we override to call our addToken method so the token is returned in the response
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
	Authentication auth) throws IOException, ServletException {
		AuthenticationService.addToken(res, auth.getName()); // our addToken code from our Auth service
	}


}
