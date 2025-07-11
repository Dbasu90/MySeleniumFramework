package com.deb.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {
    long timeout();

    String url();

    String browser();

    boolean screenshotForPassedSteps();

    String runMode();

    String remoteUrl();
}
