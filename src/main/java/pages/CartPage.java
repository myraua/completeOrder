package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends WebDrivers {

    public final static By CHECKOUT = By.cssSelector("#checkout");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage() {
    }

    public CheckoutPage performCheckout() {
        driver.findElement(CHECKOUT).click();
        return new CheckoutPage();
    }
}
