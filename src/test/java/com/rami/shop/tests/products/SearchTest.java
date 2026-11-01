package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchProduct() {
        String keyword = "top";

        homePage.goToProductsPage();
        productsPage.searchProduct(keyword);

        Assert.assertTrue(productsPage.getSearchedTitle().equalsIgnoreCase("Searched Products"),
                "The searched product wasn't found");

        List<String> names = productsPage.getResultName();
        Assert.assertFalse(names.isEmpty(), "No products were found for " + keyword);
    }
}
