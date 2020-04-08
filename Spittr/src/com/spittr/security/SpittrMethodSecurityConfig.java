package com.spittr.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class SpittrMethodSecurityConfig extends GlobalMethodSecurityConfiguration{
	
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		// TODO Auto-generated method stub
		DefaultMethodSecurityExpressionHandler ph = new DefaultMethodSecurityExpressionHandler();
		ph.setPermissionEvaluator(new SpittlePermissionEvaluator());
		return ph;
	}

}
