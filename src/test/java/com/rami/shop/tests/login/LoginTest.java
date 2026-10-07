package com.rami.shop.tests.login;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "signupDataProvider", dataProviderClass = TestDataProviders.class)
    public void loginTest(SignupData data){

        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(data.email);
        signupLoginPage.setPassword(data.password);
        signupLoginPage.loginToHomePage();


        String ActualTextMessage = homePage.getLogoutText();
        String ExpectedTextMessage = "Logout";
        Assert.assertEquals(ActualTextMessage, ExpectedTextMessage, "You are not logged!");
    }
}
