package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class HomePage  extends BasePage {

private By signupLoginButton = By.cssSelector("a[href='/login']");
private By logoutButton = By.cssSelector("a[href='/logout']");


public SignupLoginPage goToSignupPage() {
    click(signupLoginButton);
    return new SignupLoginPage();
}

public SignupLoginPage logoutToSignupPage() {
    click(logoutButton);
    return new SignupLoginPage();
}

public String getLogoutText() {
    return find(logoutButton).getText();
}






}
