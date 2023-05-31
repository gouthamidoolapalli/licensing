package com.benchmark.licensing.controller;

import com.benchmark.licensing.entity.UserForm;
import com.benchmark.licensing.iservice.ILicensingService;
import com.benchmark.licensing.model.RestResponseVO;
import com.benchmark.licensing.model.UserRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LicensingControllerTest {
	
    @Mock
    private ILicensingService licensingService;

    @InjectMocks
    private LicensingController licensingController;

    @Test
    void testGetLicensedUsers() throws Exception {
    	
        // Arrange
        List<UserForm> users = new ArrayList<>();
        users.add(new UserForm());
        when(licensingService.getAllUsersInfo()).thenReturn(users);

        // Act
        ResponseEntity<Object> response = licensingController.getLicensingTerms();

        
        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        RestResponseVO restResponseVO = (RestResponseVO) response.getBody();
        Assertions.assertNotNull(restResponseVO);
        Assertions.assertEquals(users, restResponseVO.getValue());
        verify(licensingService, times(1)).getAllUsersInfo();
        
    }

    @Test
    void testInsertOrUpdateUser_ValidRequest() throws Exception {
    	
        // Arrange
        UserRequest userRequest = new UserRequest();
        when(licensingService.updateUserInfo(userRequest)).thenReturn("userId");
        

        // Act
        ResponseEntity<Object> response = licensingController.insertOrUpdateUser(userRequest);
        

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        RestResponseVO restResponseVO = (RestResponseVO) response.getBody();
        Assertions.assertNotNull(restResponseVO);
        Assertions.assertEquals("userId", restResponseVO.getValue());
        verify(licensingService, times(1)).updateUserInfo(userRequest);

    }
    
    @Test
    public void testGetLicensedUserById_Success() throws Exception {
    	
        // Arrange
        String id = "123";
        UserForm userForm=new UserForm();
        when(licensingService.getLicensedUserInfoById(id)).thenReturn(userForm);
        

        // Act
        ResponseEntity<Object> response = licensingController.getLicensedUserById(id);
        

        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		RestResponseVO restResponseVO = (RestResponseVO) response.getBody();
        Assertions.assertNotNull(restResponseVO);
        Assertions.assertEquals(userForm,restResponseVO.getValue());
        Assertions.assertNotNull(restResponseVO.getStatusCode());
        assert restResponseVO.getStatus() != null;
        verify(licensingService).getLicensedUserInfoById(id);
        
    }
}
