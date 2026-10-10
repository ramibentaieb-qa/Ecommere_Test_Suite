package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clickJs;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class ProductsPage extends BasePage {

    private By singleProduct = By.cssSelector("//h2[@data-qa='single-product']");
//    private By addToCart = By.cssSelector("a[data-product-id='2']");
    private By addToCartButton(int productId) {
        return By.cssSelector(".productinfo a[data-product-id='" + productId + "']");
    }
    private By modalTitle = By.xpath("//h4[contains(text(), 'Added!')]");
    private By continueShoppingButton = By.cssSelector("button[data-dismiss='modal']");
    private By cartButton = By.cssSelector("a[href='/view_cart']");




    public boolean getSingleProduct() {
        return find(singleProduct).isDisplayed();
    }

    public void addProductToCart(int productId) {
        delay(5000);
        scrollToElementJS(addToCartButton(productId));
        clickJs(addToCartButton(productId));
        delay(2000);
    }

    public String getModalTitle() {
        return find(modalTitle).getText();
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
        delay(2000);
    }

    public CartPage clickCartButton() {
        scrollToElementJS(cartButton);
        click(cartButton);
        return new CartPage();
    }







}
