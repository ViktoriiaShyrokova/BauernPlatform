package de.bauernPlatform.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver(String browser) {
        if (driver.get() == null) {
            switch (browser.toLowerCase()) {
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "chrome":
                default:
                    ChromeOptions options = new ChromeOptions();
                    // options.addArguments("--headless"); // Раскомментировать для запуска без UI (Jenkins)
                    driver.set(new ChromeDriver(options));
                    break;
            }

            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
