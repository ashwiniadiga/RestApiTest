package com.rest.weather.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ashwad01 on 11/5/2016.
 */
public class TestConfigFactory {
    private static final Logger LOG = LoggerFactory.getLogger(TestConfigFactory.class);
    private static final String CONF_EXTENSION = ".conf";
    private static final Map<Class, Config> CLASS_CONFIG = new ConcurrentHashMap<Class, Config>();

    private TestConfigFactory() throws IllegalAccessException {
        throw new IllegalAccessException("TestConfigFactory is a static utility class that cannot be constructed");
    }


    public static Config getConfig(Class testClass) {
        if (!CLASS_CONFIG.containsKey(testClass)) {
            buildConfigForClass(testClass);
        }
        return CLASS_CONFIG.get(testClass);
    }

    private static void buildConfigForClass(Class testClass) {
        File classConfigFile = getClassConfigFile(testClass);
        Config classConfig;
        if (classConfigFile != null) {
            classConfig = ConfigFactory.defaultOverrides()
                    .withFallback(ConfigFactory.parseFile(getClassConfigFile(testClass)))
                    .withFallback(ConfigFactory.load());
            CLASS_CONFIG.put(testClass, classConfig);
        }

    }

    private static File getClassConfigFile(Class testClass) {
        String simpleName = testClass.getSimpleName() + CONF_EXTENSION ;
        ClassLoader classLoader = testClass.getClassLoader();
     //   URL classFileUrl = testClass.getResource(testClass.getSimpleName() + CONF_EXTENSION);
        URL classFileUrl = classLoader.getResource(testClass.getSimpleName() + CONF_EXTENSION);
        File classFile = null;
        if (classFileUrl != null) {
            try {
                classFile = new File(classFileUrl.getFile());
            }
            catch(Exception ex){
                LOG.warn("Failed to open config file for " + testClass.getSimpleName() + ": {}", ex.getMessage());
            }
        }
        return classFile;
    }



}
