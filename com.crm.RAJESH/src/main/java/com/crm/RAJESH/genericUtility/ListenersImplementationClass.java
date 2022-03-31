package com.crm.RAJESH.genericUtility;


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenersImplementationClass implements ITestListener {

	
	ExtentTest test;
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		//Step 3 : create test method during the test execution starts
		
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//Step 4 : log the pass methods
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// step 6 : log fail method , take screenshot , attach screenshot  to extent reports 
		//add exception log
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		WebDriverUtility wLib=new WebDriverUtility();
		String path=null;
		try {
			path=wLib.takesScreenshot(BaseClass.sDriver, result.getMethod().getMethodName());
					
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		//Step 5: log the skip method (test case name and execution logs)
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		
		//step 1 : Extent report configuration
		JavaUtility jUtil = new JavaUtility();
		
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./Reporter/extentReport"+jUtil.getsystemDateAndTime()+".html");
		htmlReporter.config().setReportName("regression execution reports");
		htmlReporter.config().setDocumentTitle("comcast autoTest execution report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		//step 2 : attach the physical report  and do the system config
		
	    report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("url", "http://localhost:88888");
		report.setSystemInfo("Reporter Neme", "Rajesh");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
}
