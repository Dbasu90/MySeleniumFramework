package com.deb.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {

    String url();

    String browser();

    String passedStepsScreenshots();

    String runMode();

    String remoteUrl();

    String failedStepsScreenshots();

    String overrideReports();
}
