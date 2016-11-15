package com.rest.helper;

import com.jayway.restassured.RestAssured;
import com.rest.city.PositiveTest;
import com.rest.weather.util.BaseInformation;
import config.TestConfig;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class Base{

    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);


    protected String baseUrl = BaseInformation.getUrl();
    protected String appId = BaseInformation.getAppID();
    protected static Properties readProperty;

    @BeforeClass
    public static void setTestConfig() throws IOException {
        TestConfig testConfig = new TestConfig();
        Properties properties = testConfig.readFromPropertyFile();
        RestAssured.baseURI = properties.getProperty("enviornment.baseURI");
        RestAssured.oauth2(properties.getProperty("enviornment.APPID")) ;
               // = Integer.parseInt(properties.getProperty("enviornment.APPID"));
        TestConfig testHelper = new TestConfig();
        readProperty =  testHelper.readFromPropertyFile();
    }

}