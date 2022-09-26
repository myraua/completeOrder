package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends WebDrivers {

    public final static By FIRST_NAME = By.cssSelector("#first-name");
    public final static By LAST_NAME = By.cssSelector("#last-name");
    public final static By ZIP_CODE = By.id("postal-code");
    public final static By CONTINUE = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage() {
    }

    public CheckoutPage enterFirstName(String name) {
        driver.findElement(FIRST_NAME).sendKeys(name);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterPostalCode(String postalCode) {
        driver.findElement(ZIP_CODE).sendKeys(postalCode);
        return this;
    }

    public OverviewPage continueToConfirm() {
        driver.findElement(CONTINUE).click();
        return new OverviewPage();
    }
}


