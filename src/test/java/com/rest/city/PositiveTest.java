package com.rest.city;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.rest.util.CustomListener;
import com.rest.weather.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.testng.Assert.*;



import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;



public class PositiveTest {
    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);
    protected String baseUrl = BaseInformation.getUrl();
    protected String appId = BaseInformation.getAppID();

   // @Listeners(CustomListener.class)
    @Test
    public void positiveTestByCity() {
        LOG.info("baseUrl"+ baseUrl);
        LOG.info("appId"+ appId);
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        Response response = given()
                //.log().everything()
                .param("id", "524901").param("APPID", appId ).expect().statusCode(200).
                        when()
                //.log().all
         .get(baseUrl);
        JsonPath jsonPath = response.body().jsonPath();
        String name = jsonPath.getString("city.name");
        assertEquals("Moscow", name, "Name does not match");
    }
}
