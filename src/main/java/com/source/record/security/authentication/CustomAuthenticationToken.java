package com.source.record.security.authentication;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.source.record.entities.Student;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	private String securityCode;

	public CustomAuthenticationToken(String principal, String credentials, String securityCode) {
		super(principal, credentials);
		this.securityCode = securityCode;
	}

	public CustomAuthenticationToken(Student principal, String credentials,
			Collection<? extends GrantedAuthority> authorities, String securityCode) {
		super(principal, credentials, authorities);
		this.securityCode = securityCode;
	}

	public String getSecurityCode() {
		return securityCode;
	}
}
