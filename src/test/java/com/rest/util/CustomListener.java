package com.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;


//public class CustomListener implements ITestListener,  IConfigurationListener{
public class CustomListener implements ITestListener {
    protected static final Logger LOG = LoggerFactory.getLogger(CustomListener.class);
   // @Override
    public void onStart(ITestContext result) {
        LOG.info("Teststarted running:"  + result.getAllTestMethods());
    }

   // @Override
    public void onTestStart(ITestResult result) {
        LOG.info("Teststarted running:"  + result.getMethod().getMethodName() + " at:" + result.getStartMillis());
    }

  //  @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("Result success");
    }

 //   @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("Result failure");
    }

 //   @Override
    public void onTestSkipped(ITestResult result) {
    }

  //  @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

  //  @Override
    public void onFinish(ITestContext context) {
        LOG.info("Passeds: " + context.getPassedTests());
        LOG.info("Faileds:" + context.getFailedTests());
    }

//    @Override
//    public void onConfigurationFailure(ITestResult result){
//    }
//    @Override
//    public void onConfigurationSkip(ITestResult result){
//    }
//    @Override
//    public void onConfigurationSuccess(ITestResult result){
//    }
}
