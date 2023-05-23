package com.benchmark.licensing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.benchmark.licensing.entity.UserForm;
import com.benchmark.licensing.exception.InternalServerException;
import com.benchmark.licensing.exception.MissingParamException;
import com.benchmark.licensing.iservice.ILicensingService;
import com.benchmark.licensing.repository.LicensingRepository;

@Service
public class LicensingService implements ILicensingService{

	@Autowired
	LicensingRepository licenseRepo;

	@Override
	public List<UserForm> getAllUsersInfo() {
		List<UserForm> totalUsers = new ArrayList<>() ;
		try {
			totalUsers.addAll(licenseRepo.findAll());
		}catch(Exception e) {
			throw new InternalServerException( e.getMessage());
		}
		return totalUsers;
	}

	@Override
	public String updateUserInfo(UserForm userInfo) {
		UserForm savedUser = null;
		if(ObjectUtils.isEmpty(userInfo.getUserId()) || Integer.parseInt(userInfo.getUserId()) == 0) {
			throw new MissingParamException("User Id");
		}
		if(ObjectUtils.isEmpty(userInfo.getFirstName())) {
			throw new MissingParamException("First name");
		}
		if(ObjectUtils.isEmpty(userInfo.getLastName())) {
			throw new MissingParamException("Last name");
		}

		try {

			savedUser = licenseRepo.save(userInfo);
		}catch(Exception e) {
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
			throw new InternalServerException(e.getMessage());
		}
		return user;
	}

}
