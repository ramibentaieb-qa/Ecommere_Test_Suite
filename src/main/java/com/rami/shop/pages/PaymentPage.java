package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private By nameOnCard = By.cssSelector("input[data-qa='name-on-card']");
    private By numberOnCard = By.cssSelector("input[data-qa='card-number']");
    private By cvcOnCard = By.cssSelector("input[data-qa='cvc']");
    private By expiryMonth = By.cssSelector("input[data-qa='expiry-month']");
    private By expiryYear = By.cssSelector("input[data-qa='expiry-year']");
    private By confirmButton = By.cssSelector("button[data-qa='pay-button']");
    private By successPaymentMessage = By.id("success_message");

    public void setNameOnCard(String cardName) {
        set(nameOnCard,  cardName);
    }

    public void setCardNumber(String cardNumber) {
        set(numberOnCard, cardNumber);
    }

    public void setCvc(String cvc) {
        set(cvcOnCard, cvc);
    }

    public void setExpiryMonth(String month) {
        set(expiryMonth, month);
    }

    public void setExpiryYear(String year) {
        set(expiryYear, year);
    }

    public ConfirmedPaymentPage navigateToConfirmedPaymentPage() {
        click(confirmButton);
        return new ConfirmedPaymentPage();
    }

    public String getSuccessfulMessage() {
        return find(successPaymentMessage).getText();
    }

//    public String getFieldValidationMessage() {
//        return find(emailField).getDomProperty("validationMessage");
//    }






}
