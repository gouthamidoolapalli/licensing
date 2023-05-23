package com.benchmark.licensing.iservice;

import java.util.List;

import com.benchmark.licensing.entity.UserForm;
import com.benchmark.licensing.model.UserRequest;

public interface ILicensingService {
	
	List<UserForm> getAllUsersInfo();

	String updateUserInfo(UserRequest userInfo);

	UserForm getLicensedUserInfoById(String id);

}
