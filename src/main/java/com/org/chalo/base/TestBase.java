package com.org.chalo.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.org.chalo.util.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.List;


public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static ExtentTest extentLogger;
    public static Logger log;
    private static String browserName;
    public static String language;
    public static Properties properties;

    public TestBase() {
        log = LogManager.getLogger(TestBase.class);

        properties = new Properties();
        try (FileInputStream ip = new FileInputStream("src/main/java/com/org/chalo/config/config.properties")) {
            properties.load(ip);
        } catch (IOException e) {
            log.error("-->Unable to find config.properties file | Message: {}", e.getMessage(), new IOException("Unable to read config.properties file"));
        }
        try (FileInputStream ip = new FileInputStream("src/main/java/object_repository/xpathConfig.properties")) {
            properties.load(ip);
        } catch (IOException e) {
            log.error("-->Unable to find xpath.properties file | Message: {}", e.getMessage(), new IOException("Unable to read xPath.properties file"));
        }
    }

    @BeforeSuite
    public void setupSuite() {
        htmlReporter = new ExtentSparkReporter("chalo_automation_report-.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extentLogger = extentTest;
        log.info("Extent Reports initialized successfully.");
    }

    @BeforeClass
    public void startClassLogger() {


        String className = this.getClass().getSimpleName();

        log.info(Constants.STARTS);
        log.info("                      Executing Test Cases of the Class: {}", className);
        log.info(Constants.STARTS);

        String styledClassName = "<span style='color:white; background-color:#007bff; padding: 5px; border-radius: 5px;'>"
                + className + "</span>";

        extentLogger = extent.createTest(styledClassName);

        extentLogger.info(
                "<div style='background-color:#E7FBE6; color:#09122C; padding: 4px; border-radius: 5px;'>"
                        + "▶ Starting Test Class: " + styledClassName + "</div>");
    }

    @AfterClass
    public void endClassLogger() {

        log.info(Constants.STARTS);
        log.info("                      Finished with Test Cases of the Class {}", this.getClass().getSimpleName());
        log.info(Constants.STARTS);
        log.info("\n");
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }

    public WebElement getElement(String locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By by = By.xpath(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            log.error(Constants.PRINT_ELEMENT_NOT_FOUND_AND_MESSAGE, locator, e.getMessage());
            throw new RuntimeException("--->xPath not found");
        } catch (TimeoutException e) {
            log.error(Constants.PRINT_TIMEOUT_AND_MESSAGE, locator, e.getMessage());
            throw new RuntimeException("--->xPath not found");
        } catch (Exception e) {
            log.error(Constants.PRINT_UNEXPECTED_ERROR_AND_MESSAGE, locator, e.getMessage());
            throw new RuntimeException("-->xPath not found");
        }
    }

    public WebElement getElement(String locator, int waitInSec) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSec));
        By by = By.xpath(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            log.error(Constants.PRINT_ELEMENT_NOT_FOUND_AND_MESSAGE, locator, e.getMessage());
        } catch (TimeoutException e) {
            log.error(Constants.PRINT_TIMEOUT_AND_MESSAGE, locator, e.getMessage());
        } catch (Exception e) {
            log.error(Constants.PRINT_UNEXPECTED_ERROR_AND_MESSAGE, locator, e.getMessage());
        }
        return null;
    }

    public List<WebElement> getElements(String locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By by = By.xpath(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElements(by);
        } catch (NoSuchElementException e) {
            log.error(Constants.PRINT_ELEMENT_NOT_FOUND_AND_MESSAGE, locator, e.getMessage());
        } catch (TimeoutException e) {
            log.error(Constants.PRINT_TIMEOUT_AND_MESSAGE, locator, e.getMessage());
        } catch (Exception e) {
            log.error(Constants.PRINT_UNEXPECTED_ERROR_AND_MESSAGE, locator, e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<WebElement> getElementsByCssSelector(String locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By by = By.cssSelector(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElements(by);
        } catch (NoSuchElementException e) {
            log.error(Constants.PRINT_ELEMENT_NOT_FOUND_AND_MESSAGE, locator, e.getMessage());
        } catch (TimeoutException e) {
            log.error(Constants.PRINT_TIMEOUT_AND_MESSAGE, locator, e.getMessage());
        } catch (Exception e) {
            log.error(Constants.PRINT_UNEXPECTED_ERROR_AND_MESSAGE, locator, e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void robotClass(int key) throws AWTException {
        Robot rb = new Robot();
        rb.keyPress(key);
        rb.keyRelease(key);
    }

    public List<WebElement> getElements(String locator, int waitInSec) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSec));
        By by = By.xpath(locator);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElements(by);
        } catch (NoSuchElementException e) {
            log.error(Constants.PRINT_ELEMENT_NOT_FOUND_AND_MESSAGE, locator, e.getMessage());
        } catch (TimeoutException e) {
            log.error(Constants.PRINT_TIMEOUT_AND_MESSAGE, locator, e.getMessage());
        } catch (Exception e) {
            log.error(Constants.PRINT_UNEXPECTED_ERROR_AND_MESSAGE, locator, e.getMessage());
        }
        return new ArrayList<>();
    }

    @BeforeTest
    @Parameters({"browser"})
    public static void setUpBrowserName(@Optional("chrome") String browserName) {
        TestBase.browserName = browserName;
    }

    @AfterTest
    public static void dereferenceBrowserName() {
        language = null;
        TestBase.browserName = null;
//        Utility.rerunFailedTestsIfAny();
    }

    public static void initialization() {

        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
//            driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/home/unthinkable-lap/Downloads/Webdrivers/geckodriver-v0.35.0-linux64/geckodriver");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("/usr/bin/firefox");
            driver = new FirefoxDriver(firefoxOptions);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get(properties.getProperty("loginUrl"));
    }
}
