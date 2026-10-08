package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(dependsOnMethods = "testSignupLogoutLogin")
    public void addToCartTest() {

        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(createdEmail);
        signupLoginPage.setPassword(createdPassword);
        signupLoginPage.loginToHomePage();
        Assert.assertEquals(homePage.getLogoutText(),
                "Logout", "You are not logged in!");

        homePage.goToProductsPage();
        productsPage.addProductToCart(7);
        productsPage.addProductToCart(8);
        Assert.assertEquals(productsPage.getModalTitle(),
                "Added!", "Product is not added!");
        productsPage.clickContinueShoppingButton();
        productsPage.clickCartButton();

        Assert.assertEquals(cartPage.getShoppingCartTitle(),
                "Shopping Cart", "You are not on shopping cart page");

        cartPage.deleteProductFromCart(7);
        cartPage.deleteProductFromCart(8);














    }
}
