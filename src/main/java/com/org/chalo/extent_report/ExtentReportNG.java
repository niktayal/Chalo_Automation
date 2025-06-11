package com.org.chalo.extent_report;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.org.chalo.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExtentReportNG extends TestBase implements ITestListener {

    public ExtentReportNG() {
        log = LogManager.getLogger(ExtentReportNG.class);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        log.info("-->Skipped test method: {}", result.getMethod().getMethodName());

//        extentTest = extent.createTest(result.getMethod().getDescription()).assignCategory("SkipedTest");
        extentLogger = extentTest.createNode("Report");
        extentLogger.log(Status.SKIP, result.getThrowable().getMessage());
        extentLogger.log(Status.SKIP, result.getMethod().getDescription());
        extentLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
        extentLogger.log(Status.INFO, "Test with name : " + result.getName() + " is Skipped as its depending test failed");

        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentLogger = null;
        extentTest = extent.createTest(result.getMethod().getDescription());
        log.info("-->Executing test method: {}", result.getMethod().getDescription());
        extentLogger = extentTest; // Assign new logger for the current test

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        log.info("-->Successfully passed test method: {}", result.getMethod().getMethodName());

//        extentLogger = extentTest.createNode("Report");
        extentLogger = extentTest;

        extentLogger.log(
                Status.PASS,
                MarkupHelper.createLabel(result.getMethod().getDescription()
                        + " :Test Case PASSED", ExtentColor.GREEN));

//        extentLogger.log(Status.PASS, "Successfully Passed Test Method: " + result.getMethod().getDescription());

        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.info("--->Inside Extent Report | On Test Failure");

        log.info("-->Failed test method: {} | Failure Reason: {}", result.getMethod().getMethodName(), result.getThrowable().getMessage());

        extentLogger = extentTest.createNode(result.getMethod().getDescription());

        extentLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()
                        + " :Test case FAILED due to below issues:",
                ExtentColor.RED));
//        extentLogger.log(Status.FAIL, result.getThrowable().getMessage());

        try {
            extentLogger.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), "Screenshot - " + result.getMethod().getMethodName());
            log.info("Successfully attached screenshot to the Extent Report with label: {}", "Screenshot - " + result.getMethod().getMethodName());
        } catch (Exception e) {
            log.error("Failed to attach screenshot: {}", e.getMessage());
        }
        extent.flush();


//        String methodName = result.getMethod().getMethodName();
//        String methodDescription = result.getMethod().getDescription();
//        String pageUrl = driver.getCurrentUrl();
//        String failedXpath = failedLocator;
//        failedTestMap.put(methodName, pageUrl + "::" + failedXpath);
//
//        String prompt = """
//                Go to this page: %s
//                The original (broken) XPath is: %s
//                Analyze the page and suggest a corrected, stable XPath for the same element.
//                Return only the corrected XPath in your response.
//                """.formatted(pageUrl, failedXpath);
//
//        AiResponseGenerator aiResponseGenerator = new AiResponseGenerator();
//        String aiResponse = aiResponseGenerator.generateResponse(prompt);
//
//        System.out.println("===> AI Response" + aiResponse);
    }


    @Override
    public void onStart(ITestContext context) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy--HH-mm");
//        Date resultdate = new Date(System.currentTimeMillis());
//        extent = new ExtentReports("QA-Report/ExtentReport_"+sdf.format(resultdate)+".html")
//                .viewConfigurer()
//                .viewOrder()
//                .as(new ViewName[]{ViewName.CATEGORY, ViewName.DASHBOARD,
//                        ViewName.TEST, ViewName.EXCEPTION, ViewName.AUTHOR,
//                        ViewName.DEVICE, ViewName.LOG}).apply();
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//        extentReports.setSystemInfo("Host Name", "Unthinkable Solutions");
////        extentReports.setSystemInfo("Environment", env);
//        extentReports.setSystemInfo("User Name", "Unthinkable Solutions");
//        extentReporter.config().setDocumentTitle("Automation-Testing");
//        extentReporter.config().setReportName("Project-AutomationReport");
//        extent.config().setTheme(Theme.DARK);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
