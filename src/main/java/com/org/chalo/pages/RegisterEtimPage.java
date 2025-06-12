package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class RegisterEtimPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public RegisterEtimPage() {
        //this.driver= driver;
        log = LogManager.getLogger(RegisterEtimPage.class);
    }

    public void checkRedirectionOfEtimPage() {

        log.info("The user is on Hom Page and clicking on ETIM option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for ETIM link to become visible/clickable
        WebElement btnETIM = getElement(properties.getProperty("btnEtimRegister"));
        WebElement etim = wait.until(ExpectedConditions.elementToBeClickable(btnETIM));
        etim.click();

        expectedHeading = "Register ETIM";
        actualHeading = getElement(properties.getProperty("textRegisterEtim")).getText();

        Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Register ETIM page is loading correctly");
        }

}