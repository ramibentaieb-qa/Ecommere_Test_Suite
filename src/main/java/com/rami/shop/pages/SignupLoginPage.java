package com.rami.shop.pages;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.By;

public class SignupLoginPage extends BasePage {
    private By nameField = By.name("name");
    private By emailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    private By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private By passwordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    private By errorLoginMessage = By.cssSelector("form[action='/login']  p");

    private By SignupText = By.className("signup-form");



    //Signup Methods
    public void setUsername(String username) {
        set(nameField, username);
    }

    public void setEmail(String email) {
        set(emailField, email);
    }

    public SignupPage clickSignupButton() {
        click(signupButton);
        return new SignupPage();
    }

    //Login Methods
    public void setLoginEmail(String loginEmail) {
        set(loginEmailField, loginEmail);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public HomePage loginToHomePage() {
        click(loginButton);
        return new HomePage();
    }

    public String getErrorLoginMessage() {
        return find(errorLoginMessage).getText();
    }





























}
