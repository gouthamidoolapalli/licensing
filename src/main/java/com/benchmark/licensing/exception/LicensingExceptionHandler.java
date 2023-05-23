package com.benchmark.licensing.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.benchmark.licensing.model.RestResponseVO;
import com.benchmark.licensing.utils.Constants;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class LicensingExceptionHandler {

	@ExceptionHandler(MissingParamException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public static final ResponseEntity<Object> handleMissingParamException(MissingParamException ex){

		RestResponseVO restResponseVO = new RestResponseVO();
		restResponseVO.setStatusDescription(Constants.PARAM_MISSING);
		restResponseVO.setValue(Constants.PARAM_MISSING+" : "+ex.getStatusDescription());
		restResponseVO.setStatusCode(Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE);
		restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
		return new ResponseEntity<>(restResponseVO, HttpStatus.UNAUTHORIZED);

	}
	
	@ExceptionHandler(InternalServerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public static final ResponseEntity<Object> handleInternalServerException(InternalServerException ex){

		RestResponseVO restResponseVO = new RestResponseVO();
		restResponseVO.setStatusDescription(Constants.INTERNAL_SERVER_ERROR);
		restResponseVO.setStatusCode(Constants.SERVER_FAILURE_HTTP_RESPONSE_CODE);
		restResponseVO.setValue(ex.getErrorMessage());
		restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
		return new ResponseEntity<>(restResponseVO, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
