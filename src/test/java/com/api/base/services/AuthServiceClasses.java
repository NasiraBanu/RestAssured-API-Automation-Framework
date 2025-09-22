package com.api.base.services;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthServiceClasses extends BaseServiceClasses{
	private static final String BASE_PATH="/api/auth/";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload,BASE_PATH+"login");	
	}
	
	public Response signUp(SignUpRequest payload) {
		return signupPostRequest(payload,BASE_PATH+"signup");
	}
    public Response forgotPassword(String emailAddress) {
    	HashMap<String,String> payload = new HashMap<>();
    	payload.put("email", emailAddress);
    	return forgorPasswordPostRequest(payload,BASE_PATH+"forgot-password");
    	
    }

	
}
