package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class accountCreatedPage extends BasePage {


    protected By textMessage = By.xpath("//h2[@data-qa='account-created']");
    protected By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean isAccountCreatedMessageDisplayed() {
        return find(textMessage).isDisplayed();
    }

    public  String getAccountCreatedMessageText() {
        return find(textMessage).getText();
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return new HomePage();
    }





}
