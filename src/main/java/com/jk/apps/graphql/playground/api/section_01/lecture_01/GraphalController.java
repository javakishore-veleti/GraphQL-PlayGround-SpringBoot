package com.jk.apps.graphql.playground.api.section_01.lecture_01;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;
import java.util.concurrent.ThreadLocalRandom;
@Controller
public class GraphalController {
	
	@QueryMapping("sayHello")
	public Mono<String> sayHelloDiferentMethodName() {
		
		return Mono.just("Hello");
		
	}

	@QueryMapping
	public Mono<String> sayHelloTo(@Argument("age") int usageAge) {
		return Mono.just("Hello " + usageAge);
	}
	
	@QueryMapping
	public Mono<Integer> random() {
		return Mono.just(ThreadLocalRandom.current().nextInt());
	}
}
