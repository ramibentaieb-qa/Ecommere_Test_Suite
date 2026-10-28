package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;
import static utilities.WaitUtility.*;

public class ConfirmedPaymentPage extends BasePage {

    private By confirmMessage = By.cssSelector("h2[data-qa='order-placed']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");
    private By downloadButton = By.ById.linkText("Download Invoice");


    public String getConfirmationMessage() {
        explicitWaitUntilVisible(10, confirmMessage);
        return find(confirmMessage).getText();
    }

    public HomePage backToHomePage() {
        click(continueButton);
        return new HomePage();
    }

    public void downloadInvoice() {
        click(downloadButton);
    }


}
