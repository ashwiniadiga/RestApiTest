package com.rest.city;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.rest.helper.Base;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;


public class PositiveTestZipCode extends Base {

    //private static final Logger LOG = LoggerFactory.getLogger(PositiveTestZipCode.class);



    @Test
    public void validZipCode(){
        System.out.print("Base url" + baseUrl);
        System.out.print("Base token " + appId);


        RestAssured.responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

        Response response;
        response = given()
                .queryParam("q", "Redmond").queryParam("APPID", appId)
                /*.param("q", "Redmond")
                .param("APPID", appId )*/
                .log().parameters()
                .then()
                .log().status()
                .when()
                .get(baseUrl);

        ResponseBody name=response.getBody();
        name.print();


    }







}
