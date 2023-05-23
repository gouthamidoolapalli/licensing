package com.benchmark.licensing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.benchmark.licensing.entity.UserForm;
import com.benchmark.licensing.exception.InternalServerException;
import com.benchmark.licensing.exception.LicensingExceptionHandler;
import com.benchmark.licensing.exception.MissingParamException;
import com.benchmark.licensing.iservice.ILicensingService;
import com.benchmark.licensing.model.RestResponseVO;
import com.benchmark.licensing.utils.Constants;

@RestController
@RequestMapping("/api/v1")
public class LicensingController {
	@Autowired
	private ILicensingService licensingService;
	
	@RequestMapping(value = "/getLicensedUsers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getLicensingTerms() throws Exception{
		RestResponseVO restResponseVO = new RestResponseVO();
		ResponseEntity<Object> response = null;
		try {
			restResponseVO.setValue(licensingService.getAllUsersInfo());
			response = new ResponseEntity<>(restResponseVO, HttpStatus.OK);
		}catch (MissingParamException e) {
			response = LicensingExceptionHandler.handleMissingParamException(e);
		}catch(InternalServerException e) {
			response = LicensingExceptionHandler.handleInternalServerException(e);
		}
		return response;
		
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> insertOrUpdateUser(@RequestBody UserForm userInfo) throws Exception{
		RestResponseVO restResponseVO = new RestResponseVO();
		ResponseEntity<Object> response = null;
		try {
			restResponseVO.setValue(licensingService.updateUserInfo(userInfo));
			response = new ResponseEntity<>(restResponseVO, HttpStatus.OK);
		}catch (MissingParamException e) {
			response = LicensingExceptionHandler.handleMissingParamException(e);
		}catch(InternalServerException e) {
			response = LicensingExceptionHandler.handleInternalServerException(e);
		}

		return response;
		
	}
	
	@RequestMapping(value = "/getLicensedUser/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getLicensedUserById(@PathVariable("id") String id) throws Exception{
		RestResponseVO restResponseVO = new RestResponseVO();
		ResponseEntity<Object> response = null;
		try {
			restResponseVO.setValue(licensingService.getLicensedUserInfoById(id));
			restResponseVO.setStatusCode(Constants.API_SUCCESS_HTTP_RESPONSE_CODE);
			restResponseVO.setStatus(Constants.REST_RESPONSE_STATUS.SUCCESS.name());
			response = new ResponseEntity<>(restResponseVO, HttpStatus.OK);
			
		}catch (MissingParamException e) {
			response = LicensingExceptionHandler.handleMissingParamException(e);
		}catch(InternalServerException e) {
			response = LicensingExceptionHandler.handleInternalServerException(e);
		}

		return response;
		
	}
	

}
