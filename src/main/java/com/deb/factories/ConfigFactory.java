package com.deb.factories;

import com.deb.config.FrameworkConfig;

public final class ConfigFactory {

    private ConfigFactory() {
    }

    public static FrameworkConfig getConfig() {
        return org.aeonbits.owner.ConfigFactory.create(FrameworkConfig.class);
    }
}
