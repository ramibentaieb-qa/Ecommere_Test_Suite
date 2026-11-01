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

    private By singleProduct = By.cssSelector("//h2[@data-qa='single-product']");
//    private By addToCart = By.cssSelector("a[data-product-id='2']");
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

    private By brandProducts(String brandName) {
        return By.cssSelector("a[href='/brand_products/" + brandName + "']");
    }
    private By brandSearchedTitle = By.xpath("//h2[normalize-space()='Brand - Madame Products']");
    private By productList = By.cssSelector(".features_items .product-image-wrapper");



    public boolean getSingleProduct() {
        return find(singleProduct).isDisplayed();
    }

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

//    public void selectABrand(String brand) {
//        scrollToElementJS(brandProducts);
//        clickJs(brandProducts);
//    }

    public String getBrandTitle() {
        return find(brandSearchedTitle).getText();
    }

    public Map<String, Integer> getAllBrands(String brandName) {
        Map<String, Integer> brands = new LinkedHashMap<>();

        List<WebElement> elements = driver.findElements(brandProducts(brandName));

        for (WebElement element : elements) {
            String brandUrl = element.getAttribute("href");
            String countText = element.findElement(By.tagName("span")).getText();

            int expectedCount = Integer.parseInt(
                    countText.replaceAll("[^0-9]", "")
            );
            brands.put(brandUrl, expectedCount);
        }
        return brands;
    }

    public void clickBrand(String brandName) {
        scrollToElementJS(brandProducts(brandName));
        click(brandProducts(brandName));
    }

    public int getDisplayedProductsCount() {
        return driver.findElements(productList).size();
    }



}
