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
    public void testSignup(SignupData data) {
//        String day = (dataAddress.day);
//        String month = (dataAddress.month);
//        String year = (dataAddress.year);
//        String countryName = (dataAddress.country);


        homePage.goToSignupPage();
        signupLoginPage.setUsername(data.username);
        signupLoginPage.setEmail((data.email));
        signupLoginPage.clickSignupButton();

//        signupPage.ClickMaleRadioButton();
        if ("male".equalsIgnoreCase(data.gender)) {
            signupPage.ClickMaleRadioButton();
        } else {
            signupPage.ClickFemalesRadioButton();
        }

        signupPage.setPassword(data.password);
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
//        signupPage.clickCreateAccountButton();


        accountCreatedPage accountCreatedPage = signupPage.clickCreateAccountButton();

        String actualTextMessage = accountCreatedPage.getAccountCreatedMessageText();
        String expectedTextMessage = "ACCOUNT CREATED!";
        Assert.assertEquals(
//                accountCreatedPage.getAccountCreatedMessageText(),
                actualTextMessage, expectedTextMessage
        );

        System.out.println(accountCreatedPage.getAccountCreatedMessageText());

        accountCreatedPage.clickContinueButton();







    }



}
