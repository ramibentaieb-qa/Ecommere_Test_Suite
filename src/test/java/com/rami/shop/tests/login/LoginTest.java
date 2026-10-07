package com.rami.shop.tests.login;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){

        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail("wee@tester.com");
        signupLoginPage.setPassword("wee123");
        signupLoginPage.loginToHomePage();


        String ActualTextMessage = homePage.getLogoutText();
        String ExpectedTextMessage = "Logout";
        Assert.assertEquals(ActualTextMessage, ExpectedTextMessage, "You are not logged!");
    }
}
