package com.omshinde;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CheckStatusCode {
    public static void main(String[] args) {
        //given - all ips
        //when - api (resoource&http)
        //then -
        RestAssured.baseURI="https://rahulshettyacademy.com";
        given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": 19.1043529,\n" +
                        "    \"lng\": 73.009023\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"62 63 Balaji Shradha\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"sector 5, kopar khairane\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"marathi\"\n" +
                        "}\n")
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200);
    }
}
