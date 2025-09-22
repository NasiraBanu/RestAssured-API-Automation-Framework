package com.api.base.services;

import com.api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseServiceClasses{
	
	private static final String BASE_PATH="/api/users/";
	
public Response getProfile(String token) {
	setAuthToken(token);
	System.out.println(BASE_PATH+"profile");
	return getProfileCreationRequest(BASE_PATH+"profile");
}

public Response updateProfile(String token,ProfileRequest payload) {
	setAuthToken(token);
	return putRequest(payload, BASE_PATH+"profile");
}

}
