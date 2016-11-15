package com.rest.city;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.rest.helper.Base;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;


@Slf4j
public class PositiveTest extends Base {
    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);


   // @Listeners(CustomListener.class)
    @Test
    public void positiveTestByCity() {
        LOG.info("baseUrl"+ baseUrl);
        LOG.info("appId"+ appId);
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        //logging only the response code and the header parameters
        Response response = given()
                .param("id", "524901")
                .param("APPID", appId )
                .log().parameters()
                .then()
                .log().status()
                //.statusCode(200)
                .when()
                .get(baseUrl);

        JsonPath jsonPath = response.body().jsonPath();
        String name = jsonPath.getString("city.name");
        LOG.info("Name:"+ name);


    }
}
