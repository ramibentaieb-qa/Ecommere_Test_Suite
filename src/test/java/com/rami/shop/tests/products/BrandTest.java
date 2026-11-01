package com.rami.shop.tests.products;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {

    @DataProvider(name = "brands")
    public Object[][] brands() {
        return new Object[][] { {"Mast & Harbour"}, {"Allen Solly Junior"}, {"Biba"} };
    }

    @Test(dataProvider = "brands")
    public void testBrandProductCount(String brandName) {
        homePage.goToProductsPage();
        int expectedCount = productsPage.getBrandCount(brandName);

        productsPage.clickBrand(brandName);

        int actualCount = productsPage.getDisplayedProductsCount();
        Assert.assertEquals(actualCount, expectedCount,
                "Product count is wrong for brand: " + brandName);
    }
}
