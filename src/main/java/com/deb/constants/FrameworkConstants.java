package com.deb.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/target/reports/report.html";

    private static final String TESTDATA_PATH = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";

    private static final String DATASHEET_NAME = "runData";

    public static String getReportPath() {
        return REPORT_PATH;
    }

    public static String getTestDataPath() {
        return TESTDATA_PATH;
    }

    public static String getDatasheetName() {
        return DATASHEET_NAME;
    }
}
