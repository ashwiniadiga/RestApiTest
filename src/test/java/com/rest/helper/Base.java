package com.rest.helper;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.rest.city.PositiveTest;
import com.rest.weather.util.BaseInformation;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

@Slf4j
public class Base{

    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);


    protected static String baseUrl = BaseInformation.getUrl();
    protected static String appId = BaseInformation.getAppID();
    protected static Properties readProperty;
    protected Response response;

@BeforeClass
    public static void setupDefaultRestAssured(){
        RestAssured.reset();

        RestAssured.responseSpecification= new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();


        RestAssured.requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri(Base.baseUrl)
                .addQueryParam(Base.appId)
                .build();
    }

   /* @BeforeClass
    public static void setTestConfig() throws IOException {
        TestConfig testConfig = new TestConfig();
        Properties properties = testConfig.readFromPropertyFile();
        *//*RestAssured.baseURI = properties.getProperty("enviornment.baseURI");
        RestAssured.oauth2(properties.getProperty("enviornment.APPID")) ;*//*
        RestAssured.baseURI=properties.getProperty("baseurl");
        RestAssured.oauth2(properties.getProperty("appId"));

               // = Integer.parseInt(properties.getProperty("enviornment.APPID"));
        TestConfig testHelper = new TestConfig();
        readProperty =  testHelper.readFromPropertyFile();
    }*/


}