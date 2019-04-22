package com.ca.tools.docops.utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.util.StringUtil;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.xml.XmlSuite;

import com.ca.tools.docops.rally.RallyOpeartions;
import com.ca.tools.docops.tests.BaseTest;

/**
 * Class which listens on the test executions and performs the Rally updates 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 * @since DocOps framework 2.0
 * @version 2.0
 * 
 */
public class CustomTestListener extends TestListenerAdapter implements IReporter
{

    private static final Logger LOGGER = Logger.getLogger(CustomTestListener.class);
    RallyOpeartions   rallyOperations = new RallyOpeartions();
    @Override
    public void onFinish(ITestContext testContext)
    {
        // == new Email().createEmail(testContext);
    }

    @Override
    public void onTestFailure(ITestResult tr)
    {
        String[] idArray = getTestCaseID(tr);
        for (String id : idArray)
        {
            executeTestcaseAndUpdate(id, "Fail");
        }
    }

    @Override
    public void onTestSkipped(ITestResult tr)
    {
        String[] idArray = getTestCaseID(tr);
        for (String id : idArray)
        {
            executeTestcaseAndUpdate(id, "Blocked");
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr)
    {
        String[] idArray = getTestCaseID(tr);
        for (String id : idArray)
        {
            executeTestcaseAndUpdate(id, "Pass");
        }
    }

    private String[] getTestCaseID(ITestResult tr)
    {
        return tr.getMethod().getGroups();
    }

    private void executeTestcaseAndUpdate(String id, String status)
    {
        if (id != null && id != "")
        {
            try
            {
                rallyOperations.updateTestResults(id, status);
            }
            catch (URISyntaxException e)
            {
                LOGGER.error("Unable to execute test case:", e);
            }
        }
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
    {
    	String suiteName= null;
    	for(ISuite suite:suites){
    		suiteName = suite.getName();
    	}
    	
    	MailUtil.sendMail(suiteName, BaseTest.countFailures(), BaseTest.printFailuresName(), BaseTest.getEnvName());
    }
}
