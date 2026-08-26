package steps;

import base.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;

public class StepsContainer {

    private LoginPage loginPage;
    private WebDriver driver;

    @Given("open browser")
    public void openBrowser() {
        driver = DriverFactory.initializeDriver(ConfigReader.getProperty("browser"));
        String url = ConfigReader.getProperty("url");
        System.out.println("================================");
        System.out.println("Launching application");
        System.out.println("Browser: " + ConfigReader.getProperty("browser"));
        System.out.println("URL: " + url);
        System.out.println("================================");
        driver.get(url);
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());
        loginPage = new LoginPage(driver);
    }

    @When("enter the user name as {string}")
    public void enterTheUserNameAs(String arg0) {
        String username = ConfigReader.getProperty(arg0);
        loginPage.enterUsername(username);
    }

    @When("enter the user password as {string}")
    public void enterTheUserPasswordAs(String arg0) {
        String password = ConfigReader.getProperty(arg0);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("After Login URL: " + driver.getCurrentUrl());
        System.out.println("After Login Title: " +driver.getTitle());

    }

    @Then("the user should be navigated to the dashboard")
    public void theUserShouldBeNavigatedToTheDashboard() {
            boolean isDashboardVisible = loginPage.isDashboardDisplayed();
            Assert.assertTrue(isDashboardVisible, "Login did not land on the dashboard as expected");
    }
}