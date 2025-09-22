package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.services.AuthServiceClasses;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	@Test(description="Verify signup API working as expected")
	public void createAccountTest() {
		//if I call constructor with 10 to 15 parameters not good, since calling builder here
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				 .username("Farzana3")
				    .password("Farzana1233")
				    .email("Farzana3@gmail.com")
				    .firstName("FarzanaFathima3")
				    .lastName("Nargees3")
				    .mobileNumber("9000000023")
				    .build();
		System.out.println(signUpRequest);
		
		AuthServiceClasses authServiceClasses = new AuthServiceClasses();
		Response response=authServiceClasses.signUp(signUpRequest);
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
		
	}

}
