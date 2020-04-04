package com.orders.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.orders.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>, OrderOperations{
	
	List<Order> findOrderByCustomer(String customer);
	List<Order> findOrderByCustomerAndType(String customer, String type);
	
	@Query("{'customer' : ?0}")
	List<Order> findOrdersByCustomerName(String customer);
}
