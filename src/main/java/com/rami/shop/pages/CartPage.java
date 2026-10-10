package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class CartPage extends BasePage {

    private By shoppingCartTitle = By.xpath("//li[contains(text(), 'Shopping Cart')]");


    private By deleteProductButton(int productId) {
        return By.cssSelector(".cart_delete a[data-product-id='" + productId + "']");
    }
    private By emptyCartText = By.cssSelector("span[id='empty_cart'] b");
    private By backToProductsButton = By.cssSelector("#empty_cart a[href='/products']");
    private By checkoutButton = By.cssSelector("a.check_out");

    private By quantityOf(int productId) {
        return By.cssSelector("#product-" + productId + " .cart_quantity button");
    }




    public String getShoppingCartTitle() {
        return find(shoppingCartTitle).getText();
    }


    public void deleteProductFromCart(int productId) {
        click(deleteProductButton(productId));
    }

    public String getEmptyCartText() {
        delay(2000);
        return find(emptyCartText).getText();
    }

    public ProductsPage clickBackToProductsButton() {
        click(backToProductsButton);
        return new ProductsPage();
    }

    public CheckoutPage navigateToCheckoutPage() {
        click(checkoutButton);
        return new CheckoutPage();
    }

    public String getQuantity(int productDetailsId) {
        scrollToElementJS(quantityOf((productDetailsId)));
        return find(quantityOf(productDetailsId)).getText();
    }








}
