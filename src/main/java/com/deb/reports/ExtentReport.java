package com.deb.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.deb.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports report;

    private ExtentReport() {
    }

    public static void initReport() {
        if (Objects.isNull(report)) {
            report = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            report.attachReporter(sparkReporter);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Automation Report");
            sparkReporter.config().setReportName("OrangeHRM Regression Test");
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(report)) {
            report.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testcaseName) {
        ExtentTest test = report.createTest(testcaseName);
        ExtentManager.setExTest(test);
    }

    public static void assignAuthor(String[] authors) {
        for (String author : authors) {
            ExtentManager.getExTest().assignAuthor(author);
        }
    }

    public static void assignCategory(String[] categories) {
        for (String category : categories) {
            ExtentManager.getExTest().assignCategory(category);
        }
    }

}
