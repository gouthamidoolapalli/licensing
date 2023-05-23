package com.benchmark.licensing.iservice;

import java.util.List;

import com.benchmark.licensing.entity.UserForm;

public interface ILicensingService {
	
	List<UserForm> getAllUsersInfo();

	String updateUserInfo(UserForm userInfo);

	UserForm getLicensedUserInfoById(String id);

}
