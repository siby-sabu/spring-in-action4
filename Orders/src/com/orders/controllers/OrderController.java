package com.orders.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orders.Order;

@RestController
@RequestMapping("/rest/v1")
public class OrderController {

	
//	@Autowired
//	OrderRepository repository;
	
	@Autowired
	RedisTemplate<String,Order> redisTemplate;
	
	@PostMapping("/order")
	public Order saveOrder(@RequestBody Order order) {
		//return repository.save(order);
		redisTemplate.opsForValue().set(order.getId(), order);
		
		Order order2 = redisTemplate.opsForValue().get(order.getId());
		return order2;
		
	}
	
	@GetMapping("/order/{id}")
	public @ResponseBody Order getOrder(@PathVariable String id) {
		//return repository.findById(id).orElse(new Order());
		return null;
	}
	
//	@GetMapping("/order")
//	public @ResponseBody List<Order> getOrderByCustomer(@Param("customer") String customer) {
//		System.out.println("Customer received in request" + customer);
//		//return repository.findOrderByCustomer(customer);
//		return repository.findOrdersByCustomerName(customer);
//	}
//	
	@GetMapping("/order")
	public @ResponseBody List<Order> getOrderByType(@Param("type") String type) {
//		System.out.println("type received in request" + type);
//		return repository.getOrderByType(type);
		return null;
	}
	
	@GetMapping("/order/count")
	public long orderCount() {
//		return repository.count();
		return 0;
	}
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable("id") String id) {
//		System.out.println("Deleting order wit id"+ id);
//		repository.deleteById(id);
	}
	

}
