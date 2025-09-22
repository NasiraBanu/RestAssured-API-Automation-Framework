package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.services.AuthServiceClasses;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*; // if I write with static then I no need to use RestAssured class
import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest {
	
	@Test(description="Verify if login Api is working ...")
	public void loginTest() {
		 LoginRequest loginRequest = new LoginRequest("Nasirabanu","Nasirabanu"); 
		 AuthServiceClasses authservice = new AuthServiceClasses();
		 Response response= authservice.login(loginRequest);
		 LoginResponse loginResponse=response.as(LoginResponse.class);
				System.out.println(response.asPrettyString());
				System.out.println(loginResponse.getToken());
				System.out.println(loginResponse.getEmail());
				System.out.println(loginResponse.getId());
				
				Assert.assertTrue(loginResponse.getToken()!=null);
				Assert.assertEquals(loginResponse.getEmail(), "nasirabanu.j@gmail.com");
				Assert.assertEquals(loginResponse.getId(), 2750);
		
	}

}
