package config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    public Properties readFromPropertyFile() throws IOException{
       // String propertyFileName="testApplication.properties";
        String propertyFileName="baseinformation.conf";
        Properties properties=new Properties();
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream(propertyFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file'" + propertyFileName + "'not found in the classpath");
        }

        return properties;

    }


}
