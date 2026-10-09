package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test(dependsOnMethods = "com.rami.shop.tests.signup.SignupTest.testSignupLogoutLogin")
    public void addToCartTest() {

        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(createdEmail);
        signupLoginPage.setPassword(createdPassword);
        signupLoginPage.loginToHomePage();
        Assert.assertEquals(homePage.getLogoutText(),
                "Logout", "You are not logged in!");

        homePage.goToProductsPage();
        productsPage.addProductToCart(7);
        String ActualModalText = productsPage.getModalTitle();
        Assert.assertEquals(
                ActualModalText, "Added!"
        );
        System.out.println(productsPage.getModalTitle());

        productsPage.clickContinueShoppingButton();
        productsPage.addProductToCart(8);
        productsPage.clickContinueShoppingButton();
        productsPage.clickCartButton();

        Assert.assertEquals(cartPage.getShoppingCartTitle(),
                "Shopping Cart", "You are not on shopping cart page");

        cartPage.deleteProductFromCart(7);
        cartPage.deleteProductFromCart(8);



        Assert.assertEquals(cartPage.getEmptyCartText(),
                "Cart is empty!", "You are not on empty cart page");
        cartPage.clickBackToProductsButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/products"),
                "you are not redirected back to products page");













    }
}
