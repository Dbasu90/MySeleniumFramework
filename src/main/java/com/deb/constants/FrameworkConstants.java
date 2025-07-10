package com.deb.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/target/reports/report.html";

    public static String getReportPath() {
        return REPORT_PATH;
    }

}
