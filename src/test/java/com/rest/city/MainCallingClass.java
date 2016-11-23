package com.rest.city;


import com.rest.helper.TestConstants;

public class MainCallingClass {

    public static void main(String[] args){
        //stringBuilder.testStringbuilder();

       String result= TestConstants.getProjectPath();

        System.out.println("Result is " + result);


    }
}
