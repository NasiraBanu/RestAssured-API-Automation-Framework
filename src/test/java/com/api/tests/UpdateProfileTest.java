package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.services.AuthServiceClasses;
import com.api.base.services.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfile() {
		AuthServiceClasses authServiceClasses = new AuthServiceClasses();
		Response response =authServiceClasses.login(new LoginRequest("Nasirabanu","Nasirabanu"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("-------------------------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "Nasirabanu");
		
		System.out.println("-------------------------------------------------------------------");
		ProfileRequest profileRequest = new ProfileRequest.Builder()
		 .firstName("Nasirabanu")
		 .lastName("Jamaldeen")
		 .email("nasirabanu.j@gmail.com")
		 .mobileNumber("8888888899")
		 .build();
		 
		 response=userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		 System.out.println(response.asPrettyString());
		
		
		
	}

}
