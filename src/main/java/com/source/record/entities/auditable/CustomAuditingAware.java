package com.source.record.entities.auditable;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/* AuditorAware<String> -> must be same type of createdBy and lastModifiedBy */
public class CustomAuditingAware implements AuditorAware<String> {

	public Optional<String> getCurrentAuditor() {
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Optional.ofNullable(principal.getUsername());
	}
}
