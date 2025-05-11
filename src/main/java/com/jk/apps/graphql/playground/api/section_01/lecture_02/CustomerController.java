package com.jk.apps.graphql.playground.api.section_01.lecture_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jk.apps.graphql.playground.api.section_01.lecture_02.service.CustomerServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl service;
	
	@QueryMapping
	public Flux<Customer> customersAll() {
		return service.allCustomers();
	}
	
	@QueryMapping
	public Mono<Customer> customerById(@Argument("id") Integer id) {
		return service.customerByid(id);
	}
	
	@QueryMapping
	public Flux<Customer> customersByName(@Argument("name") String name) {
		return service.customerByName(name);
	}
	
	
	@QueryMapping
	public Flux<Customer> customersByAgeRange(@Argument("ageRangeFilter") AgeRangeFilter ageRangeFilter) {
		return service.customersWithAgeRangeFilter(ageRangeFilter);
	}

}
