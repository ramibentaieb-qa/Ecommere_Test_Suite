package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryTest extends BaseTest {

    @Test
    public void testCategorySearch() {

        String category = "Women";
        String categoryProductName = "Dress ";

        homePage.goToProductsPage();
        productsPage.searchByCategory(category);
        productsPage.clickACategory(1);

        Assert.assertTrue(productsPage.getCategoryTitle().equalsIgnoreCase("Women - "+ categoryProductName +"Products"));

        List<String> categoryNames =  productsPage.getCategoryResultName();
        Assert.assertFalse(categoryNames.isEmpty(), "No products were found for " + categoryNames);


    }



}
