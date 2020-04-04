package com.orders.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.orders")
//@PropertySource("classpath:environment.properties")
public class MongoConfig extends AbstractMongoConfiguration{
	


	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}

	@Override
	protected String getDatabaseName() {
		return "OrdersDB";
	}



}
