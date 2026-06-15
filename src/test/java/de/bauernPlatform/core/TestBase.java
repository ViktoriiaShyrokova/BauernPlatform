package de.bauernPlatform.core;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;

// Подключаем наш логгер результатов
@Listeners(TestResultLogger.class)
public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser") // Параметр берется из testng.xml, если его нет - берет "chrome"
    public void setUp(@Optional("chrome") String browser) {
        DriverManager.initDriver(browser);
        driver = DriverManager.getDriver();

        // Базовый URL проекта
        driver.get("https://bauernplatform.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}