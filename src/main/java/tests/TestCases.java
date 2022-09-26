package tests;

import drivers.GetProperties;
import drivers.WebDrivers;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestCases extends WebDrivers {

    @Test
    public void loginAndPurchase() throws InterruptedException {
        GetProperties.url();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.enterEmail("standard_user").enterPassword("secret_sauce").clickLogin();
        Thread.sleep(3000);
        WebElement backpack = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack"));
        productPage.addProductToCart(backpack);
        CartPage cartPage = productPage.viewCart();
        CheckoutPage checkoutPage = cartPage.performCheckout();
        OverviewPage overviewPage = checkoutPage.
                enterFirstName("Test").
                enterLastName("Tester").
                enterPostalCode("12345").
                continueToConfirm();
        SuccessPage successPage = overviewPage.completeOrder();
        Assert.assertTrue(successPage.isThankYouPresent());
        Assert.assertTrue(successPage.isOrderCompleted());
        driver.quit();
    }

    public String decodePassword(String password) {
        byte[] decodedString = Base64.decodeBase64(password);
        return new String(decodedString); //does not return String ?
    }
}
