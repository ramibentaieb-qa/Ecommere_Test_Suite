package com.rami.shop.base;

import com.rami.shop.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.rami.shop.base.BasePage.delay;

public class BaseTest {

    protected static WebDriver driver;
    protected static BasePage basePage;
    protected static HomePage  homePage;
    protected static SignupLoginPage signupLoginPage;
    protected static SignupPage signupPage;
    protected static DeleteAccountPage deleteAccountPage;
    protected static ProductsPage productsPage;
    protected static CartPage cartPage;

    protected static String createdEmail;
    protected static String createdPassword;

    private String url = "https://automationexercise.com/";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        BasePage.setDriver(driver);
        homePage = new HomePage();
        signupLoginPage = new SignupLoginPage();
        signupPage = new SignupPage();
        deleteAccountPage = new DeleteAccountPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
    }


    @AfterMethod
    public void teardown() {
        delay(4000);
        driver.quit();
    }



























}
