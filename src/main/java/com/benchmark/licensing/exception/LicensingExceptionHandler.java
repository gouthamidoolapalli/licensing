package com.benchmark.licensing.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.benchmark.licensing.model.RestResponseVO;
import com.benchmark.licensing.utils.Constants;

@RestControllerAdvice
public class LicensingExceptionHandler extends ResponseEntityExceptionHandler {


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + " - " + error.getDefaultMessage()+"\n");
		}

		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + " - " + error.getDefaultMessage()+"\n");
		}
		RestResponseVO restResponseVO = new RestResponseVO();
		restResponseVO.setStatusDescription(Constants.PARAMS_NOT_AS_EXPECTED);
		restResponseVO.setValue(Constants.PARAMS_NOT_AS_EXPECTED+" : "+errors.toString());
		restResponseVO.setStatusCode(Constants.BAD_CREDEENTIALS_HTTP_REDPONSE_CODE);
		restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.FAILED.name());
		return new ResponseEntity<>(restResponseVO, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(MissingParamException.class)
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
