package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    private By productImage(int productDetailsId) {
        return By.cssSelector("img[src='/get_product_picture/'" + productDetailsId + "']");
    }
    private By productName = By.cssSelector(".product-information h2");
    private By productCategory = By.xpath("//div[@class='product-information']/p[contains(text(),'Category:')]");
    private By productPrice = By.xpath("//div[@class='product-information']//span[normalize-space()='Rs. 500']");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.xpath("//div[@class='product-information']//button[normalize-space()='Add to cart']");
    private By modalTitle = By.xpath("//h4[contains(text(), 'Added!')]");
    private By continueShoppingButton = By.cssSelector("button[data-dismiss='modal']");
    private By viewCartButton = By.xpath("//div[@class='modal-content']//p[a[@href='/view_cart']]");

    public String getProductName() {
        return find(productName).getText();
    }

    public String getProductCategory() {
        return find(productCategory).getText();
    }

    public String getProductPrice() {
        return find(productPrice).getText();
    }

    public void setQuantity(int quantity) {
        set(quantityInput, String.valueOf(quantity));
    }

    public String getQuantity() {
        return find(quantityInput).getDomProperty("value");
    }

    public void addProductToCart() {
        click(addToCartButton);
    }

    public String getModalTitle() {
        return find(modalTitle).getText();
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
        delay(2000);
    }

    public CartPage navigateToCart() {
        click(viewCartButton);
        return new CartPage();
    }





}
