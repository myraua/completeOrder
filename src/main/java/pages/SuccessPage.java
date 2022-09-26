package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends WebDrivers {

    public final static By THANK_YOU = By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");
    public final static By COMPLETE = By.xpath("//span[contains(text(),'Checkout: Complete!')]");


    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public SuccessPage() {
    }

    public boolean isThankYouPresent() {
        try {
            driver.findElement(THANK_YOU);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOrderCompleted() {
        try {
            driver.findElement(COMPLETE);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
