package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverCommonLibrary;

public class LoginPage {

    private final WebDriverCommonLibrary webDriverCommonLibrary;
    private final WebDriver driver;

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");
    private final By dashboardHeader = By.xpath("(//span[text()='Dashboard'])[2]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverCommonLibrary =
                new WebDriverCommonLibrary(driver);
    }

    public void enterUsername(String username) {
        WebElement usernameElement = webDriverCommonLibrary.explicitWait(usernameField);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        webDriverCommonLibrary.explicitWait(passwordField);
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        webDriverCommonLibrary.explicitWait(loginButton);
        driver.findElement(loginButton).click();
    }

    public boolean isDashboardDisplayed() {
        try {
            return webDriverCommonLibrary.explicitWait(dashboardHeader).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}