package com.rest.city;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.rest.weather.util.BaseInformation;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PositiveTest {
    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);
    protected String baseUrl = BaseInformation.getUrl();
    protected String appId = BaseInformation.getAppID();

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
        LOG.debug("Name:" + jsonPath.getString("city.name"));
       /* String statusCode=jsonPath.getString("cod");

        assertThat(statusCode).isEqualTo("200");*/
        assertThat(name).isNotEmpty();



    }
}
