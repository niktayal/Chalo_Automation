package com.org.chalo.tests;

import com.org.chalo.base.TestBase;
import com.org.chalo.pages.LoginPage;
import com.org.chalo.util.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class LoginPageTest extends TestBase {
    private LoginPage loginPage = new LoginPage();
    //loginPage = new LoginPage();
    @BeforeMethod
    public void setUp(Method method) {
        initialization();
        //loginPage = new LoginPage();
        log.info(Constants.LINE);
    }

    @Test(description = "Test Method")
    void testMethod() throws AWTException, InterruptedException {

        loginPage.enterUserName(properties.getProperty("username"));

        loginPage.enterPassword(properties.getProperty("password"));

        loginPage.clickSignInButton();

        loginPage.enterCity(properties.getProperty("city"));

        loginPage.enterDepot(properties.getProperty("depot"));

        Thread.sleep(5000);

        try {
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Test Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info(Constants.LINE);
        driver.close();
    }
}
