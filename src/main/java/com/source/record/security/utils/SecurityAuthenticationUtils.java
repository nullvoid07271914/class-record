package com.source.record.security.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class SecurityAuthenticationUtils {

	public static boolean isCurrentUserAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			boolean isAnonymous = authentication instanceof AnonymousAuthenticationToken;
			if (authentication.isAuthenticated() && !isAnonymous)
				return true;
		}
		return false;
	}
}
