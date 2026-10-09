package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import org.testng.annotations.Test;

public class NegativeSignupTest extends BaseTest {

    @Test
    public void testNegativeSignup() {

        homePage.goToSignupPage();
        signupLoginPage.setUsername("randomName");
        String signupEmail = "invalidEmail";
        signupLoginPage.setEmail(signupEmail);
        signupLoginPage.clickSignupButton();

//        String expectedAlertMessage = "Please include an'@' in the email address. ";



    }





}
