package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverCommonLibrary {

    private final WebDriver driver;

    public WebDriverCommonLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement explicitWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}