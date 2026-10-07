package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import com.rami.shop.pages.accountCreatedPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupTest extends BaseTest {

    @Test
    public void testSignup() {
        String day = "1";
        String month = "2";
        String year = "1992";
        String countryName = "Canada";


        homePage.goToSignupPage();
        signupLoginPage.setUsername("wee");
        signupLoginPage.setEmail("wee@tester.com");
        signupLoginPage.clickSignupButton();

        signupPage.ClickMaleRadioButton();
        signupPage.setPassword("wee123");
        signupPage.selectDayDropDown(day);
        signupPage.selectMonthDropDown(month);
        signupPage.selectYearDropDown(year);
        signupPage.clickNewsletterCheckbox();
        signupPage.clickSpecialOffersCheckbox();
        signupPage.setFirstNameField("aymen");
        signupPage.setLastNameField("the tester");
        signupPage.setCompanyField("Tester");
        signupPage.setAddress1Field("123 street");
        signupPage.selectCountryDropDown(countryName);
        signupPage.setStateField("BC");
        signupPage.setCityField("Vancover");
        signupPage.setZipCodeField("12345");
        signupPage.setMobileNumberField("225588996633");
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
