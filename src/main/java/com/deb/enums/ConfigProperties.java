package com.deb.enums;

public enum ConfigProperties {
    URL("url"),
    BROWSER("browser"),
    RUNMODE("runMode"),
    REMOTEURL("remoteUrl"),
    PASSEDSTEPSSCREENSHOTS("passedStepsScreenshots"),
    FAILEDSTEPSSCREENSHOTS("failedStepsScreenshots"),
    OVERRIDEREPORTS("overrideReports"),
    RETRYFAILEDTESTS("retryFailedTests");

    private final String label;

    ConfigProperties(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
