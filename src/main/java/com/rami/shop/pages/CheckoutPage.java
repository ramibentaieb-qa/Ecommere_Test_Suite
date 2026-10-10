package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class CheckoutPage extends BasePage {

    private By deliveryAddressBox = By.cssSelector("#address_delivery .page-subheading");
    private By billingAdressBox = By.cssSelector("#address_invoice .page-subheading");
    private By deliveryLines = By.cssSelector("#address_delivery li");
    private By billingLines = By.cssSelector("#address_invoice li");
    private By totalAmountOf = By.xpath("//table[contains(@class,'table-condensed')]//tr[td[@colspan='2']]//p[@class='cart_total_price']");
    private int amountToNumber(String text) {
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }
    private By placeOrderButton = By.cssSelector("a[href='/payment']");

    private List<String> getLines(By locator) {
        List<String> lines = new ArrayList<>();
        List<WebElement> items = driver.findElements(locator);
        for (int i = 1; i <items.size(); i++) {
            lines.add(items.get(i).getText().replaceAll("\\s+", " ").trim());
        }
        return lines;
    }

    public List<String> getDeliveryAddress() {
        return getLines(deliveryLines);
    }

    public List<String> getBillingAddress() {
        return getLines(billingLines);
    }

    public int getTotalAmount(  ) {
        scrollToElementJS(totalAmountOf);
        return amountToNumber(find(totalAmountOf).getText());
    }















}
