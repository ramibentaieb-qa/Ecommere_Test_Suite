package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void testNegativeLogin() {

        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail("rami@negative.com");
        signupLoginPage.setPassword("negativePassword");
        signupLoginPage.loginToHomePage();

        String ExpectedErrorMessage = "Your email or password is incorrect!";
        String ActualErrorMessage = signupLoginPage.getErrorLoginMessage();
        Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage);
    }





}
