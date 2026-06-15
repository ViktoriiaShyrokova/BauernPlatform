package de.bauernPlatform.utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtils.class);
    private static final String SCREENSHOTS_DIR = "target/screenshots/";

    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            logger.warn("WebDriver is null. Cannot take a screenshot for test: {}", testName);
            return;
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = testName + "_" + timestamp + ".png";
        File destinationFile = new File(SCREENSHOTS_DIR + fileName);

        try {
            destinationFile.getParentFile().mkdirs();
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(sourceFile, destinationFile);

            logger.info("Screenshot successfully saved: {}", destinationFile.getAbsolutePath());

        } catch (IOException e) {
            logger.error("Failed to save screenshot for test: {}", testName, e);
        }
    }
}
