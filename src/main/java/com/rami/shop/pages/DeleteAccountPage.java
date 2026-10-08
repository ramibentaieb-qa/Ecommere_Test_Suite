package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class DeleteAccountPage extends BasePage {

    private By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");


    public String getAccountDeletedText() {
        return find(accountDeletedText).getText();
    }

    public HomePage clickContinueButton() {
        click(continueButton);
        return new HomePage();
    }


}
