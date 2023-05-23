package com.benchmark.licensing.exception;

public class MissingParamException extends RuntimeException{
	
	private static final long serialVersionUID = -4818601897176319516L;
	private String statusDescription;

	public MissingParamException( String statusDescription) {
		super();
		this.statusDescription = statusDescription;
	}
	
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
}
