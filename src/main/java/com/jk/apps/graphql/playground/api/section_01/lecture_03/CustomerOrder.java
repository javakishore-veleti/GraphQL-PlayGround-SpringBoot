package com.jk.apps.graphql.playground.api.section_01.lecture_03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class CustomerOrder {

	private Integer id;
	private Integer customerId;
	

    }
}
