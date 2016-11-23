package com.rest.city;


import org.apache.commons.lang3.StringUtils;

public class stringBuilder {


    public static String testStringbuilder(){

         String abc;
         String company="hello";

        StringBuilder str=new StringBuilder();

        if(StringUtils.isNotEmpty(company)){
            str.append("company").append("again");
        }

        System.out.println("The new appended string is " + str.toString());
        return str.toString();


    }
}
