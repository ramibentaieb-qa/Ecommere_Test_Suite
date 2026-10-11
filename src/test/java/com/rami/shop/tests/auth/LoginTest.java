package com.rami.shop.tests.auth;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dependsOnMethods = "com.rami.shop.tests.auth.SignupTest.testSignupLogoutLogin")
    public void testLoginFeature() {

        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(createdEmail);
        signupLoginPage.setPassword(createdPassword);
        signupLoginPage.loginToHomePage();
        Assert.assertEquals(homePage.getLogoutText(),
                "Logout", "You are not logged in!");

      Assert.assertTrue(homePage.getUsernameText().contains(createdUsername),
              "Are you sure you are logged in?");


        homePage.logoutToSignupPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "After logout we should be on the login page");
    }









}
