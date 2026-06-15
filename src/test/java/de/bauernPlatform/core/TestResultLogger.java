package de.bauernPlatform.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultLogger implements ITestListener {


    private static final Logger logger = LoggerFactory.getLogger(TestResultLogger.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("TEST STARTED: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("TEST PASSED: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("TEST FAILED: {}", result.getMethod().getMethodName());

        if (result.getThrowable() != null) {
            logger.error("REASON: ", result.getThrowable());
        }

        // Место для вызова метода создания скриншота
        // ScreenshotUtils.takeScreenshot(DriverManager.getDriver(), result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("TEST SKIPPED: {}", result.getMethod().getMethodName());
    }
}