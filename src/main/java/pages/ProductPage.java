package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends WebDrivers {

    public final static By PRODUCT_1 = By.cssSelector("button#add-to-cart-sauce-labs-backpack");
    public final static By SHOPPING_CART = By.cssSelector("a.shopping_cart_link");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage() {
    }

    public void addProductToCart(WebElement el) {
        driver.findElement(PRODUCT_1);
    }

    public CartPage viewCart() {
        driver.findElement(SHOPPING_CART).click();
        return new CartPage();
    }
}

