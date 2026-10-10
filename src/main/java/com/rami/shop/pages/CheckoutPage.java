package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {

    private By deliveryAddressBox = By.cssSelector("#address_delivery .page-subheading");
    private By billingAdressBox = By.cssSelector("#address_invoice .page-subheading");

    private By deliveryLines = By.cssSelector("#address_delivery li");
    private By billingLines = By.cssSelector("#address_invoice li");

    private List<String> getLines(By locator) {
        List<String> lines = new ArrayList<>();
        List<WebElement> items = driver.findElements(locator);
        for (int i = 1; i <items.size(); i++) {
            lines.add(items.get(i).getText().replaceAll("\\s+", " ").trim());
        }
        return lines;
    }




    public String getDeliveryAddressBox() {
        return find(deliveryAddressBox).getText();
    }

    public String getBillingAddressBox() {
        return find(billingAdressBox).getText();
    }


    public List<String> getDeliveryAddress() {
        return getLines(deliveryLines);
    }

    public List<String> getBillingAddress() {
        return getLines(billingLines);
    }
















}
