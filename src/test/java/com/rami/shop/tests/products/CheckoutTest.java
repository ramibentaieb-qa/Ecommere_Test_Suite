package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import com.rami.shop.models.SignupData;
import com.rami.shop.utils.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckoutTest extends BaseTest {

    private static final String EXISTING_EMAIL  = "michele@test.com";
    private static final String EXISTING_PASSWORD  = "Michele123";
    int quantity = 5;
    private int expectedTotal;

    private void verifyInvoiceContent() throws Exception {
        Path downloadPath = Paths.get("target","downloads").toAbsolutePath();
        Path invoiceFile = null;
        long deadline = System.currentTimeMillis() + 15000;

        while (System.currentTimeMillis() < deadline) {
            try (Stream<Path> files = Files.list(downloadPath)) {
                invoiceFile = files
                        .filter(Files::isRegularFile)
                        .filter(file -> !file.getFileName().toString().endsWith(".crdownload"))
                        .findFirst()
                        .orElse(null);
            }
            if (invoiceFile != null) {
                break;
            }
            Thread.sleep(500);
        }

        Assert.assertNotNull(invoiceFile, "Invoice was not downloaded");
        String invoiceContent = Files.readString(invoiceFile);
        Assert.assertTrue(
                invoiceContent.contains("Hi Johana Doe"), "Customer name was not found in the invoice."
        );
        Assert.assertTrue(
                invoiceContent.contains("278"), "Total purchase amount was not found in the invoice."
        );
    }

    @BeforeMethod
    public void prepareCart() {
        homePage.goToSignupPage();
        signupLoginPage.setLoginEmail(EXISTING_EMAIL);
        signupLoginPage.setPassword(EXISTING_PASSWORD);
        signupLoginPage.loginToHomePage();
        homePage.goToProductsPage();
        productsPage.navigateToProductDetails(6);
        productDetailsPage.setQuantity(quantity);
        Assert.assertEquals(productDetailsPage.getQuantity(), String.valueOf(quantity));

        productDetailsPage.addProductToCart();
        homePage.goToProductsPage();
        productsPage.addProductToCart(8);
        productsPage.clickContinueShoppingButton();
        productsPage.clickCartButton();


        Assert.assertEquals(cartPage.getQuantity(6),  String.valueOf(quantity));
        int price = cartPage.getPrice(6);
        int total = cartPage.getTotal(6);
        Assert.assertEquals(total, price * quantity,
                "Total price is incorrect");

        expectedTotal = cartPage.getTotal(6) + cartPage.getTotal(8);
        cartPage.navigateToCheckoutPage();
    }

    @Test(dataProvider = "signupDataProvider",
            dataProviderClass = TestDataProviders.class)
    public void testCheckoutProcess(SignupData data) throws Exception {

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

    Assert.assertEquals(checkoutPage.getTotalAmount(), expectedTotal, "Total amount is wrong");
    System.out.println("Total amount is: " + checkoutPage.getTotalAmount());

        checkoutPage.navigateToPaymentPage();
        paymentPage.setNameOnCard("Michele on the Card");
        paymentPage.setCardNumber("1234567890123");
        paymentPage.setCvc("951");
        paymentPage.setExpiryMonth("02");
        paymentPage.setExpiryYear("2027");
        paymentPage.navigateToConfirmedPaymentPage();

//        String EmptyField = paymentPage.getFieldValidationMessage();
//        Assert.assertTrue(EmptyField.contains("Please"),
//                "A field is empty");

        String ExpectedConfirmedPayment = "Order Placed!";
        Assert.assertEquals(confirmedPaymentPage.getConfirmationMessage(),  ExpectedConfirmedPayment.toUpperCase(),
                "Confirmation message is not shown");

        confirmedPaymentPage.downloadInvoice();
        verifyInvoiceContent();

        confirmedPaymentPage.backToHomePage();

    }
}
