package com.jk.apps.graphql.playground.api.section_01.lecture_03;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class Customer {
	
	private Integer id;
	private String name;
	private Integer age;
	private String city;
	private List<CustomerOrder> orders;

}