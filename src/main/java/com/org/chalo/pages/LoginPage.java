package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import object_repository.LoginPageOR;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginPage extends TestBase {

    public LoginPage() {
        log = LogManager.getLogger(LoginPage.class);
    }

    public void enterUserName(String userName) {

        log.info("Entering Username");
        //getElement(LoginPageOR.INP_USER_NAME_XP.getLocator())
                //.sendKeys(userName);
        getElement(properties.getProperty("inputUserName")).sendKeys(userName);
        log.info("Entered username: {}", userName);
    }

    public void enterPassword(String password) {
        getElement(properties.getProperty("inputPassword")).sendKeys(password);
    }

    public void clickSignInButton() {

        getElement(properties.getProperty("btnSingIn")).click();
    }

    public void clickSelectCity() {
        getElement(properties.getProperty("btnSelectCity")).click();
    }

    public void enterCity(String city) throws AWTException {
        getElement(properties.getProperty("btnSelectCity")).clear();
        getElement(properties.getProperty("btnSelectCity")).sendKeys(city);
        TestBase.robotClass(KeyEvent.VK_ENTER);
    }

    public void enterDepot(String depot) throws AWTException {
        getElement(properties.getProperty("btnSelectDepo")).clear();
        getElement(properties.getProperty("btnSelectDepo")).sendKeys(depot);
        TestBase.robotClass(KeyEvent.VK_ENTER);
    }
}
