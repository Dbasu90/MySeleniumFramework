package com.deb.utils;

import com.deb.constants.FrameworkConstants;
import com.deb.enums.ConfigProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonReaderUtil {

    private static Map<String, String> configMap;

    private JsonReaderUtil() {
    }

    static {
        try {
            configMap = new ObjectMapper().readValue(new File(FrameworkConstants.getConfigJsonPath()),
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(configMap.get(key.name().toLowerCase()))) {
            throw new RuntimeException("Property name " + key + " is not found. Please check config.json");
        }
        return configMap.get(key.name().toLowerCase());
    }
}
