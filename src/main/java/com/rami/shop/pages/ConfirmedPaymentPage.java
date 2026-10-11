package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class ConfirmedPaymentPage extends BasePage {

    private By confirmMessage = By.cssSelector("h2[data-qa='order-placed']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");



    public String getConfirmationMessage() {
        return find(confirmMessage).getText();
    }

    public HomePage backToHomePage() {
        click(continueButton);
        return new HomePage();
    }


}
