package com.api.base.services;

import static io.restassured.RestAssured.*;

import com.api.filters.LoginFilter;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseServiceClasses {
	
	private static final String BASE_URI ="http://64.227.160.186:8080";
	private RequestSpecification requestspecification;
	
	static {
		RestAssured.filters(new LoginFilter());
	}
	public BaseServiceClasses() {
		requestspecification=given().baseUri(BASE_URI);
	}
	protected void setAuthToken(String token) {
		requestspecification.header("Authorization","Bearer "+token);
	}
	protected Response postRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
		
	}
	
	protected Response signupPostRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response forgorPasswordPostRequest(Object payload, String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
    protected Response getProfileCreationRequest(String endpoint) {
    	return requestspecification.get(endpoint);
    }
    
    protected Response putRequest(Object payload, String endpoint) {
    	return requestspecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    	
    }
}
