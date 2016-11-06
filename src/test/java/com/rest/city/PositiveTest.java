package com.rest.weather;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.rest.weather.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by ashwad01 on 11/4/2016.
 */
public class PositiveTest {
    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);
    protected String baseUrl = BaseInformation.getUrl();
    protected String appId = BaseInformation.getAppID();

    @Test
    public void positiveTestByCity() {
        LOG.info("baseUrl"+ baseUrl);
        LOG.info("appId"+ appId);
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        Response response = given().log().everything()
                .param("id", "524901").param("APPID", appId ).expect().statusCode(200).
                        when().log().all().get(baseUrl);
        JsonPath jsonPath = response.body().jsonPath();
        String name = jsonPath.getString("city.name");
        LOG.info("Name:"+ name);
    }
}
