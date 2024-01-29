package org.kinaxis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KinaxisLoginPage {

    private final WebDriver driver;
    private final By usernameLocator = By.xpath("//input[@id='sign-in-react__sign-in--user-id-field']");
    private final By passwordLocator = By.xpath("//input[@id='sign-in-react__sign-in--password-field']");
    private final By companyLocator = By.xpath("//input[@id='sign-in-react__sign-in--company-id-field']");
    private final By loginButtonLocator = By.xpath("//button[@type='submit']");

    private final By hompage_text_locator = By.xpath("//p[contains(@class, 'MuiTypography-root') and contains(@class, 'MuiTypography-alignCenter') and contains(@data-test-id, 'main-react__no-content-header')]");

    public KinaxisLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void enterCredentials(String username, String password, String company) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(companyLocator).sendKeys(company);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public void waitForDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }

    public boolean isLoginSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement successIndicator = wait.until(ExpectedConditions.visibilityOfElementLocated(hompage_text_locator));
            return successIndicator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
