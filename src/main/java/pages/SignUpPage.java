package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends WebDrivers {

    public final static By DEMO = By.xpath("//h1[contains(text(),'Request a Free Demo')]");
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage() {

    }

    public WebElement demoVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement demoElement = wait.until(ExpectedConditions.presenceOfElementLocated(DEMO));
        return demoElement;
    }

    public boolean isDemoPresent() {
        try {
            driver.findElement(DEMO);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
