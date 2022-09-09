package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AfterLogOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class TestCases {


    @Test
    void loginWithValidCreds() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hudl.com/login");

        //create an Object from LoginPage class
        LoginPage loginPage = new LoginPage(driver);
        String user = "myroslava.rabynyuk@gmail.com";
        String password = "@Un8J6YZ4VJwjva";
        loginPage.enterEmail(user);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.hudl.com/home";
        Assert.assertEquals(actualUrl, expectedUrl);
        driver.quit();
    }

    @Test
    public static void verifySignUpLink() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hudl.com/login");
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        loginPage.clickSignUpLink();
        Thread.sleep(3000);
        Assert.assertTrue(signUpPage.isDemoPresent());
        driver.quit();
    }

    @Test
    public static void loginWithInvalidPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hudl.com/login");

        //create an Object from LoginPage class
        LoginPage loginPage = new LoginPage(driver);
        String wrongEmail = "myroslava.rabynyuk@gmail.com";
        String password = "@Un8J6YZ4VJwjv";
        loginPage.enterEmail(wrongEmail);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
        driver.quit();
    }

    @Test
    public static void logOutNavigateToLoginPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hudl.com/login");

        //create an Object from LoginPage class
        LoginPage loginPage = new LoginPage(driver);
        String email = "myroslava.rabynyuk@gmail.com";
        String password = "@Un8J6YZ4VJwjva";
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Thread.sleep(3000);
        HomePage homePage = new HomePage(driver);
        homePage.logOut();
        Thread.sleep(3000);
        AfterLogOutPage afterLogOutPage = new AfterLogOutPage(driver);
        afterLogOutPage.clickLogIn2();
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.isEmailFieldPresent());
        Assert.assertTrue(loginPage.isPasswordFieldEmpty()); //Assertion that password is not cached!
        driver.quit();
        //If assertions fail > how to log them?
    }

    //        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")).build().perform();
//        String password1 = actions.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "c"))
//        String passwordText = loginPage.getElementTest(By.id("password"));
//        System.out.println(passwordText);
}
