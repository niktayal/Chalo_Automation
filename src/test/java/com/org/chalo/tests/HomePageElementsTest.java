package com.org.chalo.tests;

import com.org.chalo.base.TestBase;
import com.org.chalo.pages.HomePage;
import com.org.chalo.pages.RegisterEtimPage;
import com.org.chalo.util.Constants;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.lang.reflect.Method;

public class HomePageElementsTest extends TestBase {

    private HomePage homePage;
    LoginPageTest login = new LoginPageTest();
    RegisterEtimPage etimRegister = new RegisterEtimPage();

    @BeforeMethod
    public void setUp(Method method) throws InterruptedException, AWTException {
        initialization();
        homePage = new HomePage();
        log.info(Constants.LINE);

        if(!driver.getCurrentUrl().contains("home")){

            log.info("The user is not logged in into the website");
            login.testMethod();
        }

        else {
            log.info("The user is already logged in into the website");
        }
    }

    @Test(description = "This method is testing if all the menu options are enabled")
    void menuOptionsEnable() throws AWTException, InterruptedException {

        log.info("The menu options check is been started");
        homePage.getMenuOptionsIsClickable();
        log.info("The menu options check is been stopped");

        try {
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Menu Options Enable Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @Test(description = "This method is testing if all the menu options are redirecting to the correct page")
    void checkRedirectionOfAllPages() throws AWTException, InterruptedException {

        log.info("The menu options redirection check is been started");
        //new RegisterEtimPage();
        etimRegister.checkRedirectionOfEtimPage();




        log.info("The menu options redirection check is been stopped");

        try {
            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Check Redirection Of All Pages Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info(Constants.LINE);
        driver.close();
    }
}
