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


    public String getShoppingCartTitle() {
        return find(shoppingCartTitle).getText();
    }

//    public boolean isProductAddedToCart(int addedProductId) {
//        return find(productAddedToCart(addedProductId)).isDisplayed();
//    }

    public void deleteProductFromCart(int productId) {
        click(deleteProductButton(productId));
    }








}
