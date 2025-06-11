package com.org.chalo.util.retry;

import com.org.chalo.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transformer extends TestBase implements ITestListener, IAnnotationTransformer {

    public Transformer() {
        log = LogManager.getLogger(Transformer.class);
    }


    @Override
    public void onTestFailure(ITestResult result) {

        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(fileName + ".png"));
        } catch (IOException e) {
            log.error("Could not copy source file to destination file | Message: {}", e.getMessage());
        }
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }
}
