package pages;

import drivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends WebDrivers  {

    //locators
    public final static By USER = By.cssSelector("h5[class='uni-avatar__initials uni-avatar__initials--user']"); //parent Element
    public final static By LOG_OUT = By.cssSelector(("a[href*='logout']")); //selects two elements


    //WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage() {
    }

    public void logOut() {
        WebElement user = driver.findElement(USER);
        Actions actions = new Actions(driver);
        actions.moveToElement(user).perform();
        driver.findElement(LOG_OUT).click();
    }
    //I don't need this
//    public String getUrl() {
//        String url = driver.getCurrentUrl();
//        return url;
//    }

}
