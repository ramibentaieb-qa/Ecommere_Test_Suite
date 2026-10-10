package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTest extends BaseTest {

    private static final String EXISTING_EMAIL  = "michele@test.com";
    private static final String EXISTING_PASSWORD  = "Michele123";
    int quantity = 5;

    @BeforeMethod
    public void prepareCart() {
        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(EXISTING_EMAIL);
        signupLoginPage.setPassword(EXISTING_PASSWORD);
        signupLoginPage.loginToHomePage();
        homePage.goToProductsPage();
        productsPage.navigateToProductDetails(3);
        productDetailsPage.setQuantity(quantity);
        Assert.assertEquals(productDetailsPage.getQuantity(), String.valueOf(quantity));
        productDetailsPage.addProductToCart();
        productDetailsPage.navigateToCart();


        Assert.assertEquals(cartPage.getQuantity(5),  String.valueOf(quantity));
        cartPage.navigateToCheckoutPage();
    }

    @Test(dataProvider = "signupDataProvider",
            dataProviderClass = TestDataProviders.class)
    public void testCheckoutProcess(SignupData data) {

    String title = "male".equalsIgnoreCase(data.gender) ? "Mr." : "Mrs.";

        List<String> expected = new ArrayList<>();
        expected.add(title + " " + data.address.firstName + " " + data.address.lastName);
        expected.add(data.address.company);
        expected.add(data.address.address1);
        expected.add(data.address.address2);
        expected.add(data.address.city + " " + data.address.state + " " + data.address.zipcode);
        expected.add(data.address.country);
        expected.add(data.address.mobileNumber);

    List<String> delivery = checkoutPage.getDeliveryAddress();
    List<String> billing = checkoutPage.getBillingAddress();

Assert.assertEquals(delivery, expected, "Delivery address is wrong");
Assert.assertEquals(billing, expected, "Billing address is wrong");












    }
}
