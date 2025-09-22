package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.services.AuthServiceClasses;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {

	@Test(description ="Verify if forgot password API working")
	public void forgotPasswordTest() {
		AuthServiceClasses authServiceClasses = new AuthServiceClasses();
		Response response = authServiceClasses.forgotPassword("nasirabanu.j@gmail.com");
		System.out.println(response.asPrettyString());
		
		
	}
}
