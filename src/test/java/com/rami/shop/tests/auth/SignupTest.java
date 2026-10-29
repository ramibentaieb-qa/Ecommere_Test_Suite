package com.rami.shop.tests.auth;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.pages.AccountCreatedPage;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupTest extends BaseTest {

    @Test(dataProvider = "signupDataProvider", dataProviderClass = TestDataProviders.class)
    public void testSignupLogoutLogin(SignupData data) {

      String email = System.currentTimeMillis() + "_" + data.email;
      String password = System.currentTimeMillis() + "_" + data.password;
      String username = data.username;

      createdEmail = email;
      createdPassword = password;
      createdUsername = username;

//Step 1: Signup
        homePage.goToSignupPage();
        signupLoginPage.setUsername(username);
        signupLoginPage.setEmail(email);
        signupLoginPage.clickSignupButton();

//        signupPage.ClickMaleRadioButton();
        if ("male".equalsIgnoreCase(data.gender)) {
            signupPage.ClickMaleRadioButton();
        } else {
            signupPage.ClickFemalesRadioButton();
        }

        signupPage.setPassword(password);
        signupPage.selectDayDropDown(data.day);
        signupPage.selectMonthDropDown(data.month);
        signupPage.selectYearDropDown(data.year);

//        signupPage.clickNewsletterCheckbox();
//        signupPage.clickSpecialOffersCheckbox();
        if (data.newsletter) signupPage.clickNewsletterCheckbox();
        if (data.specialOffers) signupPage.clickSpecialOffersCheckbox();

        signupPage.setFirstNameField(data.address.firstName);
        signupPage.setLastNameField(data.address.lastName);
        signupPage.setCompanyField(data.address.company);
        signupPage.setAddress1Field(data.address.address1);
        signupPage.setAddress2Field(data.address.address2);
        signupPage.selectCountryDropDown(data.address.country);
        signupPage.setStateField(data.address.state);
        signupPage.setCityField(data.address.city);
        signupPage.setZipCodeField(data.address.zipcode);
        signupPage.setMobileNumberField(data.address.mobileNumber);
        System.out.println("Current Page Title: " + driver.getTitle());

        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccountButton();

        String actualTextMessage = accountCreatedPage.getAccountCreatedMessageText();
        String expectedTextMessage = "ACCOUNT CREATED!";
        Assert.assertEquals(
                actualTextMessage, expectedTextMessage
        );

        accountCreatedPage.clickContinueButton();


//Step 2: Logout
        homePage.logoutToSignupPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "After logout we should be on the login page");
    }
}
