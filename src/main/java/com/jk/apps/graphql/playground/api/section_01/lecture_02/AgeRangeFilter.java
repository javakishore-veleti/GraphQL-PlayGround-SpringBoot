package com.jk.apps.graphql.playground.api.section_01.lecture_02;

import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName="create")
public class AgeRangeFilter {
	
	private Integer minAge;
	private Integer maxAge;

}
