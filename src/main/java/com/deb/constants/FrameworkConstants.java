package com.deb.constants;

import com.deb.enums.ConfigProperties;
import com.deb.utils.PropertyReaderUtil;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final long TIMEOUT = 10;

    private static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/test/resources";

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/target/reports/";

    private static final String TESTDATA_PATH = RESOURCE_PATH + "/testdata.xlsx";

    private static final String DATASHEET_NAME = "TESTDATA";

    private static final String PROPERTIES_PATH = RESOURCE_PATH + "/config/config.properties";

    private static final String CONFIG_JSON_PATH = RESOURCE_PATH + "/config/config.json";

    private static String extentReportFilePath = "";

    private static final String REPORT_NAME = "report.html";

    private static final String EXECUTION_SHEET = "RUNMANAGER";

    public static long getTimeout() {
        return TIMEOUT;
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportFilePath();
        }
        return extentReportFilePath;
    }

    private static String createReportFilePath() {
        if (PropertyReaderUtil.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return REPORT_PATH + System.currentTimeMillis() + "/" + REPORT_NAME;
        } else {
            return REPORT_PATH + REPORT_NAME;
        }

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

    public static String getConfigJsonPath() {
        return CONFIG_JSON_PATH;
    }

    public static String getExecutionSheet() {
        return EXECUTION_SHEET;
    }

}
