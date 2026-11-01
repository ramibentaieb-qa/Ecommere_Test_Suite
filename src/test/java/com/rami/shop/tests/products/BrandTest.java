package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Map;

public class BrandTest extends BaseTest {

    @Test
    public void testBrandSearch() {
        String brandName = "Biba";

        homePage.goToProductsPage();
        Map<String, Integer> brands = productsPage.getAllBrands(brandName);

        for (Map.Entry<String, Integer> brand : brands.entrySet()) {

            String brandUrl = brand.getKey();
            int expectedCount = brand.getValue();

            productsPage.clickBrand(brandUrl);

            int actualCount = productsPage.getDisplayedProductsCount();

            Assert.assertEquals(actualCount, expectedCount, "Product count mismatch for: " + brandUrl);
        }


    }



}
