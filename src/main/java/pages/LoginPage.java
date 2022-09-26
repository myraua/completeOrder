package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebDrivers {

    private static final By USER_NAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("#login-button");

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(USER_NAME).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    public ProductPage clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductPage();
    }
}
