package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.*;
import static utilities.DropDownUtility.*;


public class SignupPage extends SignupLoginPage {

    //Radio
private By maleRadioButton = By.id("uniform-id_gender1");
private By femalesRadioButton = By.id("uniform-id_gender2");
private By passwordField = By.id("password");


    //DropDown
private By dayDropDown = By.id("days");
private By dayValue(String day) {
    return By.xpath("//div[contains(@id, 'uniform-days')][text()='"+day+"']");
}

private By monthDropDown = By.id("months");
private By monthValue(String month) {
    return By.xpath("//div[contains(@id, 'uniform-months')][text()='"+month+"']");
}

private By yearDropDown = By.id("years");
private By yearValue(String year) {
    return By.xpath("//div[contains(@id, 'uniform-years')][text()='"+year+"']");
}

    //Checkbox
private By newsletterCheckbox = By.id("uniform-newsletter");
private By specialOffersCheckbox = By.id("uniform-optin");

//Address Information
private By firstNameField = By.id("first_name");
private By lastNameField = By.id("last_name");
private By companyField = By.id("company");
private By address1Field = By.id("address1");
private By address2Field = By.id("address2");
private By countryDropDwn = By.id("country");
private By countryValue(String country) {
    return By.xpath("//select[contains(@id, 'country')][text()='"+country+"']");
}
private By stateField =  By.id("state");
private By cityField = By.id("city");
private By zipCodeField = By.id("zipcode");
private By mobileNumberField = By.id("mobile_number");
private By createAccountButton = By.cssSelector("button[data-qa='create-account']");



public void ClickMaleRadioButton() {
    clickJs(maleRadioButton);
}

//Methods for Radio
public boolean isMaleRadioButtonSelected() {
    return find(maleRadioButton).isSelected();
}

public void ClickFemalesRadioButton() {
    clickJs(femalesRadioButton);
}

public boolean isFemalesRadioButtonSelected() {
    return find(femalesRadioButton).isSelected();
}


//Methods for password field
public void setPassword(String password) {
    set(passwordField, password);
}


//Methods for dropDown

public void selectDayDropDown(String day) {
    scrollToElementJS(dayDropDown);
    selectByValue(dayDropDown, day);
}

public void clickDay(String day) {
    click(dayValue(day));
}



public void selectMonthDropDown(String month) {
      scrollToElementJS(monthDropDown);
      selectByValue(monthDropDown, month);
}

public void clickMonth(String month) {
      click(monthValue(month));
}


public void selectYearDropDown(String year) {
       scrollToElementJS(yearDropDown);
       selectByValue(yearDropDown, year);
}

public void clickYear(String year) {
      click(yearValue(year));
}


//Methods for checkbox
public void clickNewsletterCheckbox() {
    if(!find(newsletterCheckbox).isSelected()) {
        scrollToElementJS(newsletterCheckbox);
        clickJs(newsletterCheckbox);
    }
}

public void clickSpecialOffersCheckbox() {
    if(!find(specialOffersCheckbox).isSelected()) {
        scrollToElementJS(specialOffersCheckbox);
        clickJs(specialOffersCheckbox);
    }
}

public void unClickNewsletterCheckbox() {
     if(find(newsletterCheckbox).isSelected()) {
         scrollToElementJS(newsletterCheckbox);
         clickJs(newsletterCheckbox);
     }
}

public void unClickSpecialOffersCheckbox() {
    if(find(specialOffersCheckbox).isSelected()) {
        scrollToElementJS(specialOffersCheckbox);
        clickJs(specialOffersCheckbox);
        }
}


//Methods for Address Info
public void setFirstNameField(String firstName) {
    set(firstNameField, firstName);
}

public void setLastNameField(String lastName) {
    set(lastNameField, lastName);
}

public void setCompanyField(String company) {
    set(companyField, company);
}

public void setAddress1Field(String address1) {
    set(address1Field, address1);
}

public void setAddress2Field(String address2) {
    set(address2Field, address2);
}

public void selectCountryDropDown(String country) {
    scrollToElementJS(countryDropDwn);
    clickJs(countryDropDwn);
}

public void setCountryValue(String country) {
    scrollToElementJS(countryDropDwn);
    click(countryValue(country));
}

public void setStateField(String state) {
    scrollToElementJS(stateField);
    set(stateField, state);
}

public void setCityField(String city) {
    scrollToElementJS(cityField);
    set(cityField, city);
}

public void setZipCodeField(String zip) {
    scrollToElementJS(zipCodeField);
    set(zipCodeField, zip);
}

public void setMobileNumberField(String mobileNumber) {
    scrollToElementJS(mobileNumberField);
    set(mobileNumberField, mobileNumber);
}

public accountCreatedPage clickCreateAccountButton() {
    scrollToElementJS(createAccountButton);
    WebDriverWait wait = new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
    clickJs(createAccountButton);
    return new accountCreatedPage();
}




}
