package com.naukri.test.base;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.naukri.automation.util.MongoDBConnector;
import com.naukri.automation.util.XrayUtility;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/java/com/naukri/features" }, tags = "@RMS231", glue = {
		"com.naukri.stepdefinitions","com.naukri.test.base" }, plugin = { "pretty",
				"html:target/cucumber-reports", "json:target/cucumber-reports/Cucumber.json" }, monochrome = true)

public class Test_Runner extends AbstractTestNGCucumberTests {
	
	private static SessionInitiator session;
	private static XrayUtility xrayUtil;
	//private SessionInitiator session;

	@BeforeSuite
	public void start() {
		xrayUtil = new XrayUtility();
		xrayUtil.configureTests();
		//MongoDBConnector.getSetUpOperation();
		//MongoDBConnector.connectMongoDB();
		File file = new File(DriverInitiator.networkInfoCSVPath);
		if (file.exists())
			file.delete();
	}

	@AfterSuite
	public void tearDown() {
		xrayUtil.publishResultsOnXray();
		//MongoDBConnector.getTearDownOperation();
	}

	@Before(timeout = 0)
	public void initTest(Scenario scenario) {
		session = SessionInitiator.getInstance();
		session.initializeSession(scenario);
	}

	@After(timeout = 0)
	public void tearDown(Scenario scenario) {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Scenario: " + scenario.getName() + " [" + scenario.getStatus() + "]");
		System.out.println("------------------------------------------------------------------------------------");
		if (scenario.isFailed()) {
			session.takeScreenshot(scenario);
		}
		session.closeSession(scenario);
	}
}