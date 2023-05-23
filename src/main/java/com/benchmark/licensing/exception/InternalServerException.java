package com.benchmark.licensing.exception;

public class InternalServerException  extends RuntimeException{

	private static final long serialVersionUID = -1888132267601780513L;
	private String errorMessage;

	public InternalServerException( String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
