package com.orders.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cm) {
		return  new  EhCacheCacheManager(cm);
	}
	
	@Bean
	public EhCacheManagerFactoryBean cacheFactoryBean() {
		EhCacheManagerFactoryBean cfb = new EhCacheManagerFactoryBean();
		cfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		return cfb;
	}
	

	
	

}
