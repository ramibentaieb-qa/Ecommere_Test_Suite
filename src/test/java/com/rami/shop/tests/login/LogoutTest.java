package com.rami.shop.tests.login;

import com.rami.shop.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

     @Test
    public void testLogout() {

         homePage.logoutToSignupPage();



     }
}



