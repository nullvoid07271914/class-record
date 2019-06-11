package com.source.record.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.source.record.entities.Student;
import com.source.record.repositories.StudentRepository;
import com.source.record.security.authentication.CustomAuthenticationToken;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private StudentRepository repo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		CustomAuthenticationToken token = (CustomAuthenticationToken) authentication;
		String requestEmail = (String) token.getName();
		Optional<Student> requestUser = repo.findStudentByEmail(requestEmail);

		if (requestUser.isPresent()) {
			Student user = requestUser.get();

			boolean validate = isUserAuthenticated(token, user);
			if (validate) {
				return new CustomAuthenticationToken(user, user.getPassword(), user.getAuthorities(),
						token.getSecurityCode());
			}
		}

		throw new BadCredentialsException("Invalid credential.");
	}

	private boolean isUserAuthenticated(CustomAuthenticationToken token, Student user) {
		//String requestUserPassword = passwordEncoder.encode(token.getCredentials().toString());
		String requestUserPassword = token.getCredentials().toString();
		String requestUserSecurityCode = token.getSecurityCode();

		String userPassword = user.getPassword();
		String userSecurityCode = user.getSecurityCode();

//		return passwordEncoder.matches(userPassword, requestUserPassword)
//				&& userSecurityCode.equals(requestUserSecurityCode);
		
		return userPassword.equals(requestUserPassword)
				&& userSecurityCode.equals(requestUserSecurityCode);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// like open-id
		return CustomAuthenticationToken.class.equals(authentication);
	}
}
