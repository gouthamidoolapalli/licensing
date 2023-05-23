package com.benchmark.licensing.utils;

public final class Constants {
	

    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String PARAM_MISSING = "A parameter is missing in the request.";
    public static final String PARAMS_NOT_AS_EXPECTED = "Parameters are not as expected by server";
    
    
    public static final int API_SUCCESS_HTTP_RESPONSE_CODE 			= 200;
	public static final int VALIDATION_FAILURE_HTTP_RESPONSE_CODE 	= 400;
    public static final int BAD_CREDEENTIALS_HTTP_REDPONSE_CODE 	= 401;
    public static final int PERMISSION_DENIED_HTTP_REDPONSE_CODE 	= 403;
    public static final int RESOURCE_NOT_FOUND_HTTP_REDPONSE_CODE 	= 404;
    public static final int SERVER_FAILURE_HTTP_RESPONSE_CODE 		= 500;
    public static final int SERVICE_UNAVAILABLE                     = 503;
    public static final int GATEWAY_TIMEOUT                         = 504;
    
    public enum REST_RESPONSE_STATUS {
		SUCCESS,FAILED;
	}
	

}
