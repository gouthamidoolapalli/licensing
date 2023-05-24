package com.benchmark.licensing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benchmark.licensing.controller.LicensingController;
import com.benchmark.licensing.entity.UserForm;
import com.benchmark.licensing.exception.InternalServerException;
import com.benchmark.licensing.iservice.ILicensingService;
import com.benchmark.licensing.model.UserRequest;
import com.benchmark.licensing.repository.LicensingRepository;

@Service
public class LicensingService implements ILicensingService{
	
	Logger logger=LoggerFactory.getLogger(ILicensingService.class);

	@Autowired
	LicensingRepository licenseRepo;

	@Override
	public List<UserForm> getAllUsersInfo() {
		List<UserForm> totalUsers = new ArrayList<>() ;
		try {
			totalUsers.addAll(licenseRepo.findAll());
		}catch(Exception e) {
			logger.error("InternalServerException occurred: {}", e.getMessage(), e);
			throw new InternalServerException( e.getMessage());
		}
		return totalUsers;
	}

	@Override
	public String updateUserInfo(UserRequest userInfo) {
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<UserRequest>> violations = validator.validate(userInfo);
//		for (ConstraintViolation<UserRequest> violation : violations) {
//		    throw new MissingParamException(violation.getMessage());
//		}

		UserForm savedUser = new UserForm();
		try {

			savedUser.setFirstName(userInfo.getFirstName());
			savedUser.setLastName(userInfo.getLastName());
			savedUser.setUserId(userInfo.getUserId());
			savedUser.setEmail(userInfo.getEmail());
			savedUser.setDistrictName(userInfo.getDistrictName());
			savedUser.setRole(userInfo.getRole());
			savedUser.setSchoolName(userInfo.getSchoolName());
			savedUser.setSchoolContactNo(userInfo.getSchoolContactNo());
			savedUser.setZipCode(userInfo.getZipCode());
			savedUser.setCity(userInfo.getCity());
			savedUser.setState(userInfo.getState());
			savedUser.setAddress(userInfo.getAddress());
			savedUser.setMarketingInfo(userInfo.getMarketingInfo());
			savedUser.setFreeTrailStartDate(userInfo.getFreeTrailStartDate());
			savedUser.setOrganisationType(userInfo.getOrganisationType());
			savedUser.setEducatorCount(userInfo.getEducatorCount());
			savedUser.setMarketingCommunication(userInfo.isMarketingCommunication());
			
			savedUser = licenseRepo.save(savedUser);
		}catch(Exception e) {
			logger.error("InternalServerException occurred: {}", e.getMessage(), e);
			throw new InternalServerException(e.getMessage());
		}
		return savedUser.getUserId();
	}

	@Override
	public UserForm getLicensedUserInfoById(String id) {
		UserForm user = null;

		try {
			int mId = Integer.parseInt(id);
			user = licenseRepo.findById(mId).get();
		}catch(Exception e) {
			logger.error("InternalServerException occurred: {}", e.getMessage(), e);
			throw new InternalServerException(e.getMessage());
		}
		return user;
	}

}
