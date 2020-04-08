package com.spittr.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.spittr.Spittle;

public class SpittlePermissionEvaluator implements PermissionEvaluator {

	private static GrantedAuthority ROLE_ADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		System.out.println("hasPermission invoked");
		System.out.println("Permission check::" + "read".equals(permission.toString()));
		if (targetDomainObject instanceof Spittle) {
			Spittle spittle = (Spittle) targetDomainObject;
			String username = spittle.getSpitter().getUserName();
			if ("read".equals(permission.toString())) {
				System.out.println("Authenticated user::" + authentication.getName());
				System.out.println("Authenticated user::" + username);
				return isAdmin(authentication) || username.equals(authentication.getName());

			}
		}
		return false;
	}

	private boolean isAdmin(Authentication authentication) {
		return authentication.getAuthorities().contains(ROLE_ADMIN);
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

}
