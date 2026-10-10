package com.rami.shop.base;

import com.rami.shop.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utilities.Utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    protected static CheckoutPage checkoutPage;
    protected static ProductDetailsPage productDetailsPage;

    protected static String createdEmail;
    protected static String createdPassword;

    private String url = "https://automationexercise.com/";

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");

        ChromeDriver chrome = new ChromeDriver(options);
        chrome.executeCdpCommand("Network.enable", new HashMap<>());
        chrome.executeCdpCommand("Network.setBlockedURLs", Map.of("urls", List.of(
                "*googlesyndication.com*", "*doubleclick.net*",
                "*googleadservices.com*", "*adservice.google.com*")));
        driver = chrome;
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        BasePage.setDriver(driver);
        Utility.setUtilityDriver();
        homePage = new HomePage();
        signupLoginPage = new SignupLoginPage();
        signupPage = new SignupPage();
        deleteAccountPage = new DeleteAccountPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        productDetailsPage = new ProductDetailsPage();
    }


    @AfterMethod
    public void teardown() {
        delay(4000);
        driver.quit();
    }



























}
