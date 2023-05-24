package com.benchmark.licensing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RestResponseVO {
	private String status;
	private int statusCode;
	private String statusDescription;
	private String userId;
	private String role;
	private Object value;
	
}
