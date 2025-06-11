package com.org.chalo.util;

import org.testng.TestNG;

import java.awt.*;
import java.io.File;
import java.util.Collections;

public class Utility {

    public static String logError(String message, String expected, String actual, String exceptionMessage) {
        return Constants.ASSERTION_ERROR + " " + message + " Expected:" + expected + " but found: " + actual + " | Message: " + exceptionMessage;
    }

    public static void rerunFailedTestsIfAny() {
        File failedXml = new File("target/surefire-reports/testng-failed.xml");
        if (failedXml.exists()) {
            System.out.println("-->Found testng-failed");
            TestNG testng = new TestNG();
            testng.setTestSuites(Collections.singletonList(failedXml.getPath()));
            testng.run();
        }
        System.out.println("-->Could not find testng-failed");
    }

    public static void robotClass(int key) throws AWTException {
        Robot rb = new Robot();
        rb.keyPress(key);
        rb.keyRelease(key);
    }

}
