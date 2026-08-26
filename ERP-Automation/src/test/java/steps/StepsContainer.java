package steps;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class StepsContainer {

    private LoginPage loginPage;
    private static WebDriver driver;
    private static String currentUser;
    static String url;

    @Given("open browser")
    public void openBrowser() {
        driver = DriverFactory.initializeDriver(ConfigReader.getProperty("browser"));
        url = ConfigReader.getProperty("url");
        driver.navigate().to(url);
        loginPage = new LoginPage(driver);
        System.out.println("Browser launched");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
    }

    @When("enter the user name as {string}")
    public void enter_the_user_name_as(String arg0) {
        String username = ConfigReader.getProperty(arg0);
        loginPage.enterUsername(username);
    }

    @When("enter the user password as {string}")
    public void enterTheUserPasswordAs(String arg0) {
        String password =  ConfigReader.getProperty(arg0);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Page Title: " + driver.getTitle());
    }
}