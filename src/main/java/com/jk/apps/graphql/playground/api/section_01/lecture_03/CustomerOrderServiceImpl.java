package com.jk.apps.graphql.playground.api.section_01.lecture_03;

import java.util.Collections;
import org.springframework.stereotype.Service;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerOrderServiceImpl {
	
	private final Flux<Customer> flux = Flux.just(
			Customer.create(100,"Name 100", 10, "City 100", Collections.emptyList()),
			Customer.create(101,"Name 101", 11, "City 101", Collections.emptyList()));
	
	public Flux<Customer> customersWithOrders(Integer customerId) {
		return flux.filter(c -> c.getId() == customerId);
	}
	
	public Mono<CustomerOrder> customerOrderById(Integer customerId, Integer orderId) {
        return flux.filter(c -> c.getId() == customerId)
                .flatMap(customer -> Flux.fromIterable(customer.getOrders())) // Convert orders list into flux
                .filter(order -> order.getId() == orderId)  // Filter orders by orderId
                .next() // take first matching order as Mono
                .map(order -> CustomerOrder.create(customerId,order.getId())) // Create customer order with customerId and order
                ;

    }

}
