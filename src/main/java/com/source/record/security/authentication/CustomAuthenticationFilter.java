package com.source.record.security.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationFilter.class);

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String username = super.obtainUsername(request);
		String password = super.obtainPassword(request);
		String securityCode = request.getParameter("security_code");

		logger.info("CustomAuthenticationFilter: username -> " + username);
		logger.info("CustomAuthenticationFilter: password -> " + password);
		logger.info("CustomAuthenticationFilter: securityCode -> " + securityCode);

		CustomAuthenticationToken token = new CustomAuthenticationToken(username, password, securityCode);
		super.setDetails(request, token);

		return this.getAuthenticationManager().authenticate(token);
	}
}
