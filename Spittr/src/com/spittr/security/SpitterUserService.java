//package com.spittr.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.spittr.Spitter;
//import com.spittr.data.SpitterRepository;
//
//public class SpitterUserService implements UserDetailsService {
//
//	@Autowired
//	private SpitterRepository spitterRepository;
//
//	public SpitterUserService(SpitterRepository spitterRepository) {
//		this.spitterRepository = spitterRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		try {
//			Spitter spitter = spitterRepository.get(username);
//			if (spitter != null) {
//				List<GrantedAuthority> authorities = new ArrayList<>();
//				authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
//				return new User(spitter.getUserName(), spitter.getPassword(), authorities);
//			}
//		} catch (Exception e) {
//			throw new UsernameNotFoundException("Username " + username + " not found");
//		}
//		return null;
//
//	}
//
//}
