package com.org.chalo.util.retry;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer {

    public RetryAnalyzer() {
        log = LogManager.getLogger(RetryAnalyzer.class);
    }

    int counter = 0;
    int retryLimit = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        while (counter < retryLimit) {
            log.info("Re-executing test method: {}", iTestResult.getMethod().getMethodName());
            counter++;
            return true;
        }
        return false;
    }


}
