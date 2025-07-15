package com.deb.utils;

import com.deb.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyReaderUtil {

    //to read properties using the traditional way. Usually the properties are stored in form of a hashtable(which is bit slow but thread safe)
    //if there are 100 properties, and we are calling them multiple times in our code, it is better to read the properties as a hashmap

    private static final Properties property = new Properties();

    private static final Map<String, String> PROPERTY_MAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getPropertiesPath());
            property.load(file);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                PROPERTY_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private PropertyReaderUtil() {
    }

    public static String getValue(String key) {
        if (Objects.isNull(key) || Objects.isNull(PROPERTY_MAP.get(key))) {
            throw new RuntimeException("Property name " + key + " is not found. Please check config.properties");
        }
        return PROPERTY_MAP.get(key);
    }


}
