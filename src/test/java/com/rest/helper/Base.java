package com.rest.helper;

import com.rest.city.PositiveTest;
import com.rest.weather.util.BaseInformation;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Slf4j
public class Base{

    protected static final Logger LOG = LoggerFactory.getLogger(PositiveTest.class);


    protected String baseUrl = BaseInformation.getUrl();
    protected String appId = BaseInformation.getAppID();
    protected static Properties readProperty;

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