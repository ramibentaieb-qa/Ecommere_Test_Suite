package com.rami.shop.tests.signup;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeSignupFormTest extends BaseTest {

    @Test(dataProvider = "signupDataProvider", dataProviderClass = TestDataProviders.class)
    public void testSignupLogoutLogin(SignupData data) {

      String email = System.currentTimeMillis() + "_" + data.email;
      String password = System.currentTimeMillis() + "_" + data.password;

      createdEmail = email;
      createdPassword = password;

//Step 1: Signup Page
      homePage.goToSignupPage();
      signupLoginPage.setUsername(data.username);
      signupLoginPage.setEmail(email);
      signupLoginPage.clickSignupButton();


//Page 2:  Account Information Page
      if ("male".equalsIgnoreCase(data.gender)) {
        signupPage.ClickMaleRadioButton();
      } else {
        signupPage.ClickFemalesRadioButton();
      }

      signupPage.setPassword("");
      signupPage.selectDayDropDown(data.day);
      signupPage.selectMonthDropDown(data.month);
      signupPage.selectYearDropDown(data.year);

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

      signupPage.clickCreateAccountButton();

      String actualValidationMessage = signupPage.getValidationMessage();
      Assert.assertTrue(actualValidationMessage.contains("Please"),
              "A field is empty");


    }
}
