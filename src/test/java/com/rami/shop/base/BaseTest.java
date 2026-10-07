package com.rami.shop.base;

import com.rami.shop.pages.HomePage;
import com.rami.shop.pages.SignupLoginPage;
import com.rami.shop.pages.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.rami.shop.base.BasePage.delay;

public class BaseTest {

    protected static WebDriver driver;
    protected static BasePage basePage;
    protected static HomePage  homePage;
    protected static SignupLoginPage signupLoginPage;
    protected static SignupPage signupPage;

    private String url = "https://automationexercise.com/";

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        BasePage.setDriver(driver);
        homePage = new HomePage();
        signupLoginPage = new SignupLoginPage();
        signupPage = new SignupPage();
    }


    @AfterSuite
    public void teardown() {
        delay(4000);
        driver.quit();
    }



























}
