package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.AddressData;
import com.rami.shop.models.SignupData;
import com.rami.shop.pages.accountCreatedPage;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupTest extends BaseTest {

    @Test(dataProvider = "signupDataProvider", dataProviderClass = TestDataProviders.class)
    public void testSignupLogoutLogin(SignupData data) {

      String email = System.currentTimeMillis() + "_" + data.email;
      String password = System.currentTimeMillis() + "_" + data.password;

//Step 1: Signup
        homePage.goToSignupPage();
        signupLoginPage.setUsername(data.username);
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
        signupPage.selectCountryDropDown(data.address.country);
        signupPage.setStateField(data.address.state);
        signupPage.setCityField(data.address.city);
        signupPage.setZipCodeField(data.address.zipcode);
        signupPage.setMobileNumberField(data.address.mobileNumber);
        System.out.println("Current Page Title: " + driver.getTitle());

        accountCreatedPage accountCreatedPage = signupPage.clickCreateAccountButton();

        String actualTextMessage = accountCreatedPage.getAccountCreatedMessageText();
        String expectedTextMessage = "ACCOUNT CREATED!";
        Assert.assertEquals(
                actualTextMessage, expectedTextMessage
        );

        System.out.println(accountCreatedPage.getAccountCreatedMessageText());

        accountCreatedPage.clickContinueButton();



//Step 2: Logout

        homePage.logoutToSignupPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "After logout we should be on the login page");



//Ste 3: Login

        signupLoginPage.setLoginEmail(email);
        signupLoginPage.setPassword(password);
        signupLoginPage.loginToHomePage();
        Assert.assertEquals(homePage.getLogoutText(),
                "Logout", "You are not logged in!");

        homePage.goToDeleteAccountPage();


//Step 4: Delete Account

        Assert.assertEquals(deleteAccountPage.getAccountDeletedText(),
                "Account Deleted!", "Your account has not been deleted!");

        deleteAccountPage.clickContinueButton();

    }



}
