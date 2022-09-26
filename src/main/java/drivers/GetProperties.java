package drivers;

public class GetProperties extends WebDrivers {

    public static void url() {

        WebDrivers.createDriverInstance();
        driver.navigate().to("https://www.saucedemo.com/");
    }
}
