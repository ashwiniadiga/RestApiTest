package com.rest.weather.util;

import com.typesafe.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ashwad01 on 11/4/2016.
 */
public class BaseInformation {
    private static final Logger LOG = LoggerFactory.getLogger(BaseInformation.class);
    private static final Config CONFIG = TestConfigFactory.getConfig(BaseInformation.class);

    public static String getUrl() {
        String key = "base.baseurl";
        String url = CONFIG.getString(key);
        LOG.info(key + ": " + url);
        return url;
    }

    public static String getAppID() {
        String key = "base.appId";
        String url = CONFIG.getString(key);
        LOG.info(key + ": " + url);
        return url;
    }
//    public static List<String> getServers() {
//        return CONFIG.getStringList(String.format("environment.%s.servers", environment));
//    }
}
