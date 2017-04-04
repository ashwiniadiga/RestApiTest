package com.rest.util;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

public class CustomReport implements IReporter{
    protected static final Logger LOG = LoggerFactory.getLogger(CustomReport.class);
        @Override
        public void generateReport(List xmlSuites, List suites,
                                   String outputDirectory) {
            LOG.info("*****************Reporting********");
            //Iterating over each suite included in the test
            List<ISuite> testSuites =  suites;
            for (ISuite suite : testSuites) {
                //Following code gets the suite name
                String suiteName = suite.getName();
                //Getting the results for the said suite
                Map<String, ISuiteResult> suiteResults = suite.getResults();
                for (ISuiteResult sr : suiteResults.values()) {
                    ITestContext tc = sr.getTestContext();
                    LOG.info("Passed tests for suite '" + suiteName +
                            "' is:" + tc.getPassedTests().getAllResults().size());
                    LOG.info("Failed tests for suite '" + suiteName +
                            "' is:" +
                            tc.getFailedTests().getAllResults().size());
                    LOG.info("Skipped tests for suite '" + suiteName +
                            "' is:" +
                            tc.getSkippedTests().getAllResults().size());
                }

        }
    }
}
