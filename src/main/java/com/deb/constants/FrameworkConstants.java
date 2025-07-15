package com.deb.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/target/reports/report.html";

    private static final String TESTDATA_PATH = RESOURCE_PATH + "/testdata.xlsx";

    private static final String DATASHEET_NAME = "runData";

    private static final String PROPERTIES_PATH = RESOURCE_PATH + "/config/config.properties";

    public static String getReportPath() {
        return REPORT_PATH;
    }

    public static String getTestDataPath() {
        return TESTDATA_PATH;
    }

    public static String getDatasheetName() {
        return DATASHEET_NAME;
    }

    public static String getPropertiesPath() {
        return PROPERTIES_PATH;
    }
}
