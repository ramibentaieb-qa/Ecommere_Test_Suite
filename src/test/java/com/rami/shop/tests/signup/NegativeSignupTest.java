package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeSignupTest extends BaseTest {

    @Test
    public void testNegativeSignup() {

        homePage.goToSignupPage();
        signupLoginPage.setUsername("randomName");
        String signupEmail = "invalidEmail";
        signupLoginPage.setEmail(signupEmail);
        signupLoginPage.clickSignupButton();

        String actualMessage = signupLoginPage.getEmailValidationMessage();
        Assert.assertTrue(actualMessage.contains("@"),
                "The form should not have moved to the page");

    }





}
