package org.kinaxis.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.kinaxis.pages.KinaxisLoginPage;
import org.kinaxis.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginSteps {

    private WebDriver driver;
    private KinaxisLoginPage kinaxisLoginPage;

    @Given("the user navigates to the login page")
    public void step_given_user_navigates_to_login_page() {
        String url = Utils.readProperty("login.url");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        kinaxisLoginPage = new KinaxisLoginPage(driver);
        kinaxisLoginPage.navigateToLoginPage(url);
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }


    @When("the user enters the credentials from the config file")
    public void step_when_user_enters_credentials_from_config_file() {

        String username = Utils.readProperty("user.username");
        String password = Utils.readProperty("user.password");
        String companyId = Utils.readProperty("user.company");
        kinaxisLoginPage.enterCredentials(username, password, companyId);
    }

    @When("clicks the login button")
    public void step_when_user_clicks_login_button() throws InterruptedException {
        kinaxisLoginPage.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void step_then_user_logged_in_successfully() {
        kinaxisLoginPage.waitForDashboard();
        assert "Dashboard".equals(driver.getTitle());
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        boolean isLoginSuccessful = kinaxisLoginPage.isLoginSuccessful();

        Assert.assertTrue("Login should be successful", isLoginSuccessful);
    }
}
