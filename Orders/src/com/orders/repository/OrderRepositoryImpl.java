package com.orders.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.orders.Order;

public class OrderRepositoryImpl implements OrderOperations{
	
	@Autowired
	MongoOperations mongo;

	@Override
	public List<Order> getOrderByType(String type) {
		String t = "NET".equals(type) ? "WEB" : type;
		Criteria criteria = Criteria.where("type").is(t);
		Query where = Query.query(criteria);
		return mongo.find(where, Order.class);
	}

}
