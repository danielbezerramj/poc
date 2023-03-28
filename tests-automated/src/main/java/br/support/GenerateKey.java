package br.support;

import io.restassured.RestAssured;

public class GenerateKey {

    private String jsonLogin = "{\n" +
            "  \"email\": \"danielbezerra.mj@gmail.com\",\n" +
            "  \"password\": \"32142632\"\n" +
            "}";

    public String getKeyUser(){
        return RestAssured.given().body(jsonLogin).when().post("/login").then()
                .extract().path("authorization").toString();
    }


}
