package com.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class CourseReviewVO {

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "text")
	private String text;

}
