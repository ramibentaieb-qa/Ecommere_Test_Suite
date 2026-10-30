package com.rami.shop.base;

import com.rami.shop.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;
import utilities.DownloadUtility;
import utilities.Utility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.rami.shop.base.BasePage.delay;

@Listeners(com.rami.shop.utils.TestListener.class)
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
    protected static PaymentPage paymentPage;
    protected static ConfirmedPaymentPage confirmedPaymentPage;

    protected static String createdEmail;
    protected static String createdPassword;
    protected static String createdUsername;

    private String url = "https://automationexercise.com/";

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome")String browser) throws Exception {
            Path downloadPath = prepareDownloadFolder();
            Map<String, Object> prefs = buildPrefs(downloadPath);

            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-notifications");
                if (Boolean.getBoolean("headless")) {
                    options.addArguments("--headless=new", "--no-sandbox",
                            "--disable-dev-shm-usage", "--window-size=1920,1080");
                }

                ChromeDriver chrome = new ChromeDriver(options);
                chrome.executeCdpCommand("Network.enable", new HashMap<>());
                chrome.executeCdpCommand("Network.setBlockedURLs", Map.of("urls", List.of(
                        "*googlesyndication.com*", "*doubleclick.net*",
                        "*googleadservices.com*", "*adservice.google.com*")));
                driver = chrome;
            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-notifications");
                if (Boolean.getBoolean("headless")) {
                    options.addArguments("--headless=new", "--no-sandbox",
                            "--disable-dev-shm-usage", "--window-size=1920,1080");
                }
                driver = new EdgeDriver(options);
        } else {
                throw  new Exception("Incorrect Browser");
            }

        if (!Boolean.getBoolean("headless")) {
            driver.manage().window().maximize();
        }

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
        paymentPage = new PaymentPage();
        confirmedPaymentPage = new ConfirmedPaymentPage();
    }

    private Path prepareDownloadFolder() throws Exception {
        Path downloadPath = DownloadUtility.getDownloadFolder();
        Files.createDirectories(downloadPath);
        try (var files = Files.list(downloadPath)) {
            for (Path f : files.toList()) Files.delete(f);
        }
        return downloadPath;
    }

    private Map<String, Object> buildPrefs(Path downloadPath) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("download.default_directory", downloadPath.toString());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", false);
        return prefs;
    }


    @AfterMethod
    public void teardown() {
        delay(4000);
        driver.quit();
    }

    protected void loginAs(String email, String password) {
        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(email);
        signupLoginPage.setPassword(password);
        signupLoginPage.loginToHomePage();
        homePage.waitUntilLoggedIn();
    }
}