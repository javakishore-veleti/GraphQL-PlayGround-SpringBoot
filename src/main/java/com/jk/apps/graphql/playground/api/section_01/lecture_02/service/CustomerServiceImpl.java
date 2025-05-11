package com.jk.apps.graphql.playground.api.section_01.lecture_02.service;

import org.springframework.stereotype.Service;

import com.jk.apps.graphql.playground.api.section_01.lecture_02.AgeRangeFilter;
import com.jk.apps.graphql.playground.api.section_01.lecture_02.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl {
	
	private final Flux<Customer> flux = Flux.just(
			Customer.create(100, "Name 100", 100, "City 100"),
			Customer.create(100, "Name 101", 101, "City 101"));
	
	public Flux<Customer> allCustomers() {
		return flux;
	}
	
	public Mono<Customer> customerByid(Integer id) {
		return flux.filter(c -> c.getId() == id).next();
	}
	
	public Flux<Customer> customerByName(String name) {
		return flux.filter(c -> c.getName().equalsIgnoreCase(name));
	}
	
	public Flux<Customer> customersWithAgeRangeFilter(AgeRangeFilter ageRangeFilter) {
		return flux.filter(c -> c.getAge() >= ageRangeFilter.getMinAge() && c.getAge() <= ageRangeFilter.getMaxAge());
	}

}
