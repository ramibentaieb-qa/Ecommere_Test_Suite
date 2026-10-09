package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By shoppingCartTitle = By.xpath("//li[contains(text(), 'Shopping Cart')]");
//    private By productAddedToCart(int addedProductId) {
//        return By.cssSelector("tr[id='" + addedProductId +"']");
//    }

    private By deleteProductButton(int productId) {
        return By.cssSelector(".cart_delete a[data-product-id='" + productId + "']");
    }
    private By emptyCartText = By.cssSelector("span[id='empty_cart'] b");
    private By backToProductsButton = By.cssSelector("#empty_cart a[href='/products']");




    public String getShoppingCartTitle() {
        return find(shoppingCartTitle).getText();
    }

//    public boolean isProductAddedToCart(int addedProductId) {
//        return find(productAddedToCart(addedProductId)).isDisplayed();
//    }

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








}
