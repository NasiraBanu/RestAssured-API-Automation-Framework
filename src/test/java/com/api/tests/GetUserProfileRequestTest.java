package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.services.AuthServiceClasses;
import com.api.base.services.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetUserProfileRequestTest {
	
	@Test(description="Verify Get UserProfile API working ...")
	public void getUserProfileInfoTest() {
		AuthServiceClasses  authServiceClasses = new AuthServiceClasses();
		Response response = authServiceClasses.login(new LoginRequest("Nasirabanu","Nasirabanu"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		System.out.println(response.asPrettyString());
		
	}

}
