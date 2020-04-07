package com.spittr.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spittr.data.SpitterRepository;

@Configuration
@EnableWebSecurity
public class SpittrSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SpitterRepository spitterRepository;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, roles from user_roles where username=?")
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.ldapAuthentication()
//			.userSearchBase("ou=people")
//			.userSearchFilter("(uid={0})")
//			.groupSearchBase("ou=groups")
//			.groupSearchFilter("member={0}")
//			.contextSource()
//			.root("dc=habuma,dc=com")
//			.ldif("classpath:users.ldif");
//			
//			
//	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(new SpitterUserService(spitterRepository))
//		.passwordEncoder(new BCryptPasswordEncoder());
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/login")
				.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.deleteCookies("JSESSIONID")
//				.and()
//			.rememberMe()
//			.tokenValiditySeconds(23231323)
//			.key("spittrKey")
				.and()
			.authorizeRequests()
			.antMatchers("/spitter/register")
			.hasAuthority("ROLE_ADMIN")
			.antMatchers("/spitters/me").hasAuthority("ROLE_USER")
			.antMatchers(HttpMethod.POST, "/spittles").hasRole("USER")
			.anyRequest().permitAll()
//				.and()
//			.requiresChannel()
//			.antMatchers("/").requiresInsecure()
//			.antMatchers("/spitter/register")
//			.requiresSecure()
				.and()
			.csrf()
			.disable();
	}

}
