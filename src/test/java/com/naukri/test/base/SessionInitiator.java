package com.naukri.test.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.TemporaryFilesystem;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.YamlReader;

import cucumber.api.Scenario;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarRequest;
import net.lightbody.bmp.core.har.HarResponse;

public class SessionInitiator {

    private static String browser, implicitTimeout, explicitTimeout, saveScreenshot;
    private DriverInitiator init;
    private static SessionInitiator sessionInitiator;
    public static String environment;
    public static ArrayList<String> screenshots;
    private final String screenshotPath = System.getProperty("user.dir") + File.separator + "target" + File.separator;

    private SessionInitiator() {
        _configureTestEnvironment();
        _configurePathAndGlobalVariables();
        screenshots = new ArrayList<String>();
    }

    public static SessionInitiator getInstance() {
        if (sessionInitiator == null) {
            sessionInitiator = new SessionInitiator();
        }
        return sessionInitiator;
    }

    public void initializeSession(Scenario scenario) {
        System.out.println("----------------------------------------------------");
        System.out.println("Scenario: " + scenario.getName() + "[Started]");
        System.out.println("----------------------------------------------------");
        _configureBrowser(scenario);
        _initializeSuperPO();
    }

    private void _initializeSuperPO() {
        new BaseAutomation(DriverInitiator.driver, implicitTimeout, explicitTimeout, browser);
    }

    private void _configurePathAndGlobalVariables() {
        YamlReader.configureTestDataPaths(SessionInitiator.environment);
        implicitTimeout = ReadWritePropertyFile.getProperty("implicitTimeout", BaseAutomation.configFile).toString();
        explicitTimeout = ReadWritePropertyFile.getProperty("explicitTimeout", BaseAutomation.configFile).toString();
        saveScreenshot = ReadWritePropertyFile.getProperty("saveScreenshot", BaseAutomation.configFile).toString();
    }

    private void _configureTestEnvironment() {
        String testEnv = System.getProperty("testEnvironment");
        if (testEnv == null) {
            _setTestEnvironment("default");
        } else if (testEnv.trim().isEmpty()) {
            _setTestEnvironment("default");
        } else {
            _setTestEnvironment(testEnv);
        }
    }

    private void _setTestEnvironment(String env) {
        if (env.equalsIgnoreCase("default")) {
            env = ReadWritePropertyFile.getProperty("testEnvironment", BaseAutomation.configFile);
        }
        switch (env.toUpperCase()) {
            case "LIVE":
            case "STAGE":
            case "STG":
            case "STAGING":
                SessionInitiator.environment = "LIVE";
                break;
            case "TEST":
                SessionInitiator.environment = "TEST";
                break;
        }
    }

    private void _configureBrowser(Scenario scenario) {
        init = new DriverInitiator();
        String browser = System.getProperty("browser");
        String browserType, browserVersion;
        String browserKeys[] = new String[2];
        if (browser == null) {
            browserKeys = _setBrowser("default");
        } else if (browser.trim().isEmpty()) {
            browserKeys = _setBrowser("default");
        } else {
            browserKeys = _setBrowser(browser);
        }
        browserType = browserKeys[0];
        browserVersion = browserKeys[1];
        init.setDriver(browserType, browserVersion, scenario);
    }

    private String[] _setBrowser(String browser) {
        if (browser.equalsIgnoreCase("default")) {
            browser = ReadWritePropertyFile.getProperty("browser", BaseAutomation.configFile);
        }
        String browserType = browser.replaceAll("[^a-zA-Z]", "");
        String browserVersion = browser.replaceAll("[^0-9]", "");
        switch (browserType.toUpperCase()) {
            case "CHROME":
                SessionInitiator.browser = "CHROME";
                break;
            case "FF":
            case "FIREFOX":
                SessionInitiator.browser = "FIREFOX";
                break;
            case "IE":
                SessionInitiator.browser = "IE";
                break;
        }
        return new String[]{SessionInitiator.browser, browserVersion};
    }

    public void takeScreenshot(Scenario scenario) {
        _saveScreenshots(scenario);
        if (DriverInitiator.driver != null) {
            final byte[] screenshot = ((TakesScreenshot) DriverInitiator.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    private void _saveScreenshots(Scenario scenario) {
        if (Boolean.parseBoolean(saveScreenshot)) {
            File scrFile = ((TakesScreenshot) DriverInitiator.driver).getScreenshotAs(OutputType.FILE);
            String saveImgFile = screenshotPath + "Scenario_" + scenario.getName().replaceAll("[^0-9a-zA-Z]", "")
                    + File.separator + "Scenario_" + scenario.getName().replaceAll("[^0-9a-zA-Z]", "")
                    + System.currentTimeMillis() + "_screenshot.png";
            screenshots.add(saveImgFile);
            File destinationPath = new File(saveImgFile);
            try {
                System.out.println("Saving screen shot.... ::  " + destinationPath);
                FileUtils.copyFile(scrFile, destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeSession(Scenario scenario) {
    	if(DriverInitiator.networkMonitorSwitch.equals("TRUE")) {
    		_filterAndSaveMonitoringResults(scenario);
    	}
        if (DriverInitiator.driver != null) {
            try {
                DriverInitiator.driver.quit();
                TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
            } catch (Exception e) {
                DriverInitiator.driver = null;
                e.printStackTrace();
            }
        }
    }

	private void _filterAndSaveMonitoringResults(Scenario scenario) {
		Har har = DriverInitiator.proxy.getHar();
//		String sFileName = BaseAutomation.testdataPath + scenario.getName().replaceAll("[^0-9a-zA-Z]", "")+"_harfile.har";
//		File harFile = new File(sFileName);
//		try {
//			har.writeTo(harFile);
//		} catch (IOException ex) {
//			 System.out.println (ex.toString());
//		     System.out.println("Could not find file " + sFileName);
//		}
		_filterHar(har);
	}
	
	private void _filterHar(Har har) {
		List<HarEntry> harEntries= har.getLog().getEntries();
		try {
			for(HarEntry entry : harEntries) {
				HarResponse response = entry.getResponse();
				HarRequest request = entry.getRequest();
				int responseCode = response.getStatus();
				if((responseCode != 200) && (responseCode !=301) && (responseCode != 302) && (responseCode != 204)) {
					//System.out.println("<<<< URL -> "+request.getUrl()+" || Status Code -> "+response.getStatus()+" >>>>");
					DriverInitiator.bw.write(request.getUrl()+","+response.getStatus());
					DriverInitiator.bw.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			DriverInitiator.proxy.stop();
			try {
				if (DriverInitiator.bw != null)
					DriverInitiator.bw.close();
				if (DriverInitiator.fw != null)
					DriverInitiator.fw.close();
				} catch (IOException ex) {
					System.err.format("IOException: %s%n", ex);
				}
		}
	}

}
