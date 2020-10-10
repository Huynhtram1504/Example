package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTest {

    static WebDriver driver;
    private static final By username_TXB = By.id("username");
    private static final By password_TXB = By.id("password");
    private static final By login_BTN = By.tagName("button");

    public static void login (String name, String password ){
        driver.findElement(username_TXB).sendKeys(name);
        driver.findElement(password_TXB).sendKeys(password);
        driver.findElement(login_BTN).click();
    }

    @BeforeMethod
    public static void setUp (){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");


    }
    @Test
    public static void testcase1 (){
        login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/secure"));

    }
    @AfterMethod
    public static void closeweb (){
        driver.close();

    }

}
