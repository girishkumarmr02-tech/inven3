package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {
        if (driver != null) {
            return driver;
        }

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException("Browser name cannot be empty.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(utils.ConfigReader.getProperty("url"));

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new RuntimeException(
                    "Driver has not been initialized. Call initializeDriver() first."
            );
        }
        return driver;
    }

    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
    }
}