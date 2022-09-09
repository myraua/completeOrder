package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends WebDrivers {

    private static final By EMAIL = By.id("email");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("#logIn");
    private static final By REMEMBER_ME_CHECKBOX = By.cssSelector("uni-form__check-indicator__background");
    private static final By ORGANIZATION = By.xpath("//button[@data-qa-id='log-in-with-organization-btn']");
    private static final By SIGN_UP = By.xpath(("//a[contains(text(),'Sign up')]"));
    private static final By NEED_HELP = By.cssSelector("[data-qa-id=need-help-link]");
    private static final By ERROR = By.cssSelector("[data-qa-id=error-display]");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage enterEmail(String email) {
        driver.findElement(EMAIL).sendKeys(email);
        return this;
    }

    //method to enter password
    public LoginPage enterPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    //method to click on Login button
    public HomePage clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage();
    }

    public SignUpPage clickSignUpLink() {
        driver.findElement(SIGN_UP).click();
        return new SignUpPage();
    }

    public boolean isErrorMessagePresent() {
        try {
            driver.findElement(ERROR);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isEmailFieldPresent() {
        try {
            driver.findElement(EMAIL);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPasswordFieldPresent() {
        try {
            driver.findElement(PASSWORD);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPasswordFieldEmpty() {
        WebElement password = driver.findElement(PASSWORD);
        String passwordText = password.getAttribute("value");
        if (passwordText.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

