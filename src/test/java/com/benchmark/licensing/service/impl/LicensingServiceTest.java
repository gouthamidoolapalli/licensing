package com.benchmark.licensing.service.impl;

import com.benchmark.licensing.entity.UserForm;
import com.benchmark.licensing.model.UserRequest;
import com.benchmark.licensing.repository.LicensingRepository;
import com.benchmark.licensing.service.impl.LicensingService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LicensingServiceTest {

    @Mock
    private LicensingRepository licenseRepo;

    @InjectMocks
    private LicensingService licensingService;

    @Test
    void testGetAllUsersInfo() {
        // Arrange
        List<UserForm> users = new ArrayList<>();
        users.add(new UserForm());
        when(licenseRepo.findAll()).thenReturn(users);

        // Act
        List<UserForm> result = licensingService.getAllUsersInfo();

        // Assert
        Assertions.assertEquals(users, result);
        verify(licenseRepo, times(1)).findAll();
    }

    @Test
    void testUpdateUserInfo() {
        // Arrange
        UserRequest userInfo = new UserRequest();
        userInfo.setUserId("123");
        UserForm savedUser = new UserForm();
        when(licenseRepo.save(any(UserForm.class))).thenReturn(savedUser);

        // Act
        String result = licensingService.updateUserInfo(userInfo);

        // Assert
        Assertions.assertEquals(savedUser.getUserId(), result);
        verify(licenseRepo, times(1)).save(any(UserForm.class));
    }

    @Test
    void testGetLicensedUserInfoById() {
        // Arrange
        String id = "123";
        UserForm userForm = new UserForm();
        when(licenseRepo.findById(anyInt())).thenReturn(Optional.of(userForm));

        // Act
        UserForm result = licensingService.getLicensedUserInfoById(id);

        // Assert
        Assertions.assertEquals(userForm, result);
        verify(licenseRepo, times(1)).findById(anyInt());
    }
}