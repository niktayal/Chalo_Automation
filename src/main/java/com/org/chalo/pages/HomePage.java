package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import object_repository.LoginPageOR;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class HomePage extends TestBase {

    public HomePage() {
        log = LogManager.getLogger(HomePage.class);
    }

    private String option;

    public void getMenuOptionsIsClickable() {

        log.info("Getting all the menu options");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> menuItems = getElements(properties.getProperty("btnMenuOptions"));

        boolean allEnabled = true;

        for (WebElement item : menuItems) {
            if (!item.isEnabled()) {
                log.info("Not Enabled: " + item.getText());
                allEnabled = false;
            } else {
                log.info("Enabled: " + item.getText());
            }
        }

        if (allEnabled) {
            log.info("All menu items are enabled");
        } else {
            log.info("Some menu items are not enabled");
        }
    }

}
