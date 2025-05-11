package com.jk.apps.graphql.playground.api.section_01.lecture_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerOrderController {
	
	@Autowired
	private CustomerOrderServiceImpl service;
	
	@QueryMapping
	public Flux<Customer> customerOrders(@Argument("customerId") Integer customerId) {
		return service.customersWithOrders(customerId);
	}
	
	@QueryMapping
	public Mono<CustomerOrder> customerOrderById(@Argument("customerId") Integer customerId, @Argument("orderId") Integer orderId) {
		return service.customerOrderById(customerId, orderId);
	}

}
