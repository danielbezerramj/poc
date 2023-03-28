package br.gov.bnb.wrapper;

import io.restassured.RestAssured;
import org.junit.*;

public class BaseApi {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @After
    public void tearDown(){
    }



}
