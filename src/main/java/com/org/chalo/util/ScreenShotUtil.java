package com.org.chalo.util;

import com.aventstack.extentreports.Status;
import com.org.chalo.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtil extends TestBase {

    public static void CaptureScreenShot(String screenShotName) {
        extentLogger.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), "Screenshot - " + screenShotName);
        extentLogger.log(Status.INFO, "-->Captured screenshot successfully and attached to the extent report Name: " + screenShotName);
        log.info("-->Captured screenshot successfully and attached to the extent report, Name: {}", screenShotName);
    }
}
