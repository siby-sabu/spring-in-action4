package com.orders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.orders.Order;

@Configuration
public class RedisConfiguration {
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory cf  = new JedisConnectionFactory();
		cf.setHostName("localhost");
		cf.setPort(6379);
		//cf.setPassword("password");
		
		return cf;
		
	}
	
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String,Order> redis = new RedisTemplate<>();
		redis.setConnectionFactory(cf);
		redis.setKeySerializer(new StringRedisSerializer());
		redis.setValueSerializer(new Jackson2JsonRedisSerializer<>(Order.class));
		return redis;
	}

}
