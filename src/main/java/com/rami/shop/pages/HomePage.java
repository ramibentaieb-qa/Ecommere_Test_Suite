package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class HomePage  extends BasePage {

private By signupLoginButton = By.cssSelector("a[href='/login']");
private By logoutButton = By.cssSelector("a[href='/logout']");
private By deleteAcountButton = By.cssSelector("a[href='/delete_account']");
private By usernameText = By.xpath("//a[contains(text(), 'Logged in as')]/b");
private By productButton =  By.cssSelector("a[href='/products']");

public SignupLoginPage goToSignupPage() {
    click(signupLoginButton);
    return new SignupLoginPage();
}

public SignupLoginPage logoutToSignupPage() {
    click(logoutButton);
    return new SignupLoginPage();
}

public DeleteAccountPage goToDeleteAccountPage() {
    click(deleteAcountButton);
    return new DeleteAccountPage();
}

public String getLogoutText() {
    return find(logoutButton).getText();
}

public String getUsernameText() {
    return find(usernameText).getText();
}


public ProductsPage goToProductsPage() {
    click(productButton);
    return new ProductsPage();
}






}
