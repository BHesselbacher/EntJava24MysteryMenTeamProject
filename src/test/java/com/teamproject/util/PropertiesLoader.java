package com.teamproject.util;

import java.io.IOException;
import java.util.Properties;


public interface PropertiesLoader {


    default Properties loadProperties(String propertiesFilePath){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}

