package br.gov.bnb.wrapper;

import org.junit.After;
import org.junit.Before;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

   /* @Before
    public void setUp(){
    	RequestSpecification requestSpec = new RequestSpecBuilder()
    			.setBaseUri("https://serverest.dev")
    			.addHeader("Accept", "application/json")
    			.addFilter(new RequestLoggingFilter())
    			.setRelaxedHTTPSValidation()
        .build();
    	
    	RestAssured.requestSpecification = requestSpec;
    }*/
    
    @Before
    public void setUp(){
    	RequestSpecification requestSpec = new RequestSpecBuilder()
    			.setBaseUri("https://petstore.swagger.io")
    			.addHeader("Accept", "application/json")
    			.addHeader("api_key", "special-key")
    			.addFilter(new RequestLoggingFilter())
    			.setRelaxedHTTPSValidation()
        .build();
    	
    	RestAssured.requestSpecification = requestSpec;
    }

    @After
    public void tearDown(){
    	// TODO;
    }



}
