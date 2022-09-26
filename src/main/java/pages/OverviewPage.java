package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OverviewPage extends WebDrivers {

    public final static By FINISH = By.cssSelector("#finish");


    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public OverviewPage() {
    }

    public SuccessPage completeOrder() {
        driver.findElement(FINISH).click();
        return new SuccessPage();
    }
}
