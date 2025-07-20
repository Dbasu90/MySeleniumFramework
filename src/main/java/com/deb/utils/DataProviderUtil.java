package com.deb.utils;

import com.deb.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class DataProviderUtil {

    private DataProviderUtil() {
    }

    private static List<Map<String, String>> testData = new ArrayList<>();

    @DataProvider(parallel = true)
    public static Object[] getData(Method m) {
        String testName = m.getName();

        if (testData.isEmpty()) {
            testData = ExcelReaderUtil.getTestData(FrameworkConstants.getDatasheetName());
        }

        List<Map<String, String>> executionData = new ArrayList<>(testData);
        Predicate<Map<String, String>> isTestNameNotMatching = map -> !map.get("testcasename").equalsIgnoreCase(testName);
        Predicate<Map<String, String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");

        executionData.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
        return executionData.toArray();
    }


}
