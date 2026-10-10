package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.SwitchToUtility.getAlertMessage;

public class NegativeSignupTest extends BaseTest {

    @Test
    public void testNegativeSignup() {

        homePage.goToSignupPage();
        signupLoginPage.setUsername("randomName");
        String signupEmail = "invalidEmail";
        signupLoginPage.setEmail(signupEmail);
        signupLoginPage.clickSignupButton();

        String expectedAlertMessage = "Please include an'@' in the email address. '" + signupEmail + "' is missing an '@'.";
        Assert.assertEquals(getAlertMessage(), expectedAlertMessage,  "\n Actual and expected messages do not match \n");


    }





}
