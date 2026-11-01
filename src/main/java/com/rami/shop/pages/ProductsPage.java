package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.*;

import static utilities.JavaScriptUtility.clickJs;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.*;

public class ProductsPage extends BasePage {

    private By addToCartButton(int productId) {
        return By.cssSelector(".productinfo a[data-product-id='" + productId + "']");
    }
    private By modalTitle = By.xpath("//h4[contains(text(), 'Added!')]");
    private By continueShoppingButton = By.cssSelector("button[data-dismiss='modal']");
    private By cartButton = By.cssSelector("a[href='/view_cart']");
    private By viewProductButton(int productDetailsId) {
        return By.cssSelector("a[href='/product_details/" + productDetailsId + "']");
    }
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedTitle = By.xpath("//h2[normalize-space()='Searched Products']");
    private By resultName = By.cssSelector(".features_items .productinfo p");

    private By categoryAccordion(String hrefCategory) {
        return By.cssSelector("a[href='#" + hrefCategory + "']");
    }
    private By categoryProduct(int categoryProductId) {
        return By.cssSelector("a[href='/category_products/" + categoryProductId + "']");
    }
    private By categorySearchedTitle = By.xpath("//h2[normalize-space()='Women - Dress Products']");
    private By categoryResultName = By.cssSelector(".features_items .productinfo p");

    private By brandLink(String brandName) {
        return By.cssSelector("a[href='/brand_products/" + brandName + "']");
    }
    private By brandTitle(String brandName) {
        return By.xpath("//h2[normalize-space()='Brand - " + brandName + " Products']");
    }
    private By productList = By.cssSelector(".features_items .product-image-wrapper");



    public void addProductToCart(int productId) {
        scrollToElementJS(addToCartButton(productId));
        clickJs(addToCartButton(productId));
        explicitWaitUntilVisible(5, modalTitle);
    }

    public String getModalTitle() {
        return find(modalTitle).getText();
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
        explicitWaitUntilInvisible(5, modalTitle);
    }

    public CartPage clickCartButton() {
        scrollToElementJS(cartButton);
        click(cartButton);
        return new CartPage();
    }

    public ProductDetailsPage navigateToProductDetails(int productDetailsId) {
        scrollToElementJS(viewProductButton(productDetailsId));
        clickJs(viewProductButton(productDetailsId));
        return new ProductDetailsPage();
    }

    public void searchProduct(String keyword) {
        set(searchInput, keyword);
        click(searchButton);
        explicitWaitUntilVisible(10, searchedTitle);
    }

    public String getSearchedTitle() {
        return find(searchedTitle).getText();
    }

    public List<String> getResultName() {
        List<String> names = new ArrayList<>();
        for (WebElement element : driver.findElements(resultName)) {
            scrollToElementJS(resultName);
            names.add(element.getText());
        }
        return names;
    }

    public void searchByCategory(String category) {
        scrollToElementJS(categoryAccordion(category));
        click(categoryAccordion(category));
    }

    public void clickACategory(int categoryID) {
        explicitWaitUntilVisible(10, categoryProduct(categoryID));
        click(categoryProduct(categoryID));
    }

    public String getCategoryTitle() {
        return find(categorySearchedTitle).getText();
    }

    public List<String> getCategoryResultName() {
        List<String> categoryNames = new ArrayList<>();
        for (WebElement element : driver.findElements(categoryResultName)) {
            scrollToElementJS(categoryResultName);
            categoryNames.add(element.getText());
        }
        return categoryNames;
    }

    public int getBrandCount(String brandName) {
        String text = find(brandLink(brandName)).findElement(By.tagName("span")).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public void clickBrand(String brandName) {
        scrollToElementJS(brandLink(brandName));
        click(brandLink(brandName));
        explicitWaitUntilVisible(10, brandTitle(brandName));
    }

    public int getDisplayedProductsCount() {
        return driver.findElements(productList).size();
    }
}
