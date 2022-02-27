package com.naukri.test.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.naukri.automation.util.ReadWritePropertyFile;

import cucumber.api.Scenario;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverInitiator {

    public static RemoteWebDriver driver;
    private String OSName;
    static BrowserMobProxy proxy;
    static String networkMonitorSwitch;
    static String networkInfoCSVPath = BaseAutomation.testdataPath + "networkInfo.csv";
    static BufferedWriter bw;
    static FileWriter fw;

    public void setDriver(String browserType, String browserVersion, Scenario scenario) {
        String driverFolderPath;
        browserVersion = browserVersion.trim();
        if (browserVersion.isEmpty() || browserVersion == "" || browserVersion == null) {
            driverFolderPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers" + File.separator;
            _setConfiguration(browserType, null, driverFolderPath);
        } else {
            driverFolderPath = System.getenv("Common_Resources") + File.separator;
            _setConfiguration(browserType, browserVersion, driverFolderPath);
        }
        _startDriver(scenario);
    }

    /*
     @auther Mohit Dagar, Vikash Agrawal
     This method set configuration before starting test i.e: maximize the browser wiondow and the network monitor logs
     */
    private void _startDriver(Scenario scenario) {
        String server = System.getProperty("server");
        if (server == null) {
            server = ReadWritePropertyFile.getProperty("seleniumserver", BaseAutomation.configFile);
        }
        OSName = System.getProperty("os.name").toLowerCase();
        if (!((server.contains("mobile")) || (OSName.indexOf("nix") >= 0 || OSName.indexOf("nux") >= 0 || OSName.indexOf("aix") > 0))) {
            driver.manage().window().maximize();
        }
        if (networkMonitorSwitch.equals("TRUE")) {
            proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
            proxy.newHar(scenario.getName().replaceAll("[^0-9a-zA-Z]", ""));
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(ReadWritePropertyFile.getProperty("implicitTimeout", BaseAutomation.configFile)),
                TimeUnit.SECONDS);
    }

    private void _setConfiguration(String browserType, String browserVersion, String driverFolderPath) {
        OSName = System.getProperty("os.name").toLowerCase();
        String server = System.getProperty("server");
        if (server == null) {
            server = ReadWritePropertyFile.getProperty("seleniumserver", BaseAutomation.configFile);
        }
        if (server.contains("local")) {
            if (browserVersion != null) {
                if (OSName.indexOf("win") >= 0) {
                    _setBinaryDriverOnWindows(browserType, browserVersion, driverFolderPath);
                } else if (OSName.indexOf("mac") >= 0) {
                    System.out.println("This is Mac");
                } else if (OSName.indexOf("nix") >= 0 || OSName.indexOf("nux") >= 0 || OSName.indexOf("aix") > 0) {
                    _setBinaryDriverOnLinux(browserType, browserVersion, driverFolderPath);
                } else if (OSName.indexOf("sunos") >= 0) {
                    System.out.println("This is Solaris");
                } else {
                    System.out.println("Your OS is not support!!");
                }
            } else {
                if (OSName.indexOf("win") >= 0) {
                    _setDefaultDriverOnWindows(browserType, driverFolderPath);
                } else if (OSName.indexOf("mac") >= 0) {
                    System.out.println("This is Mac");
                } else if (OSName.indexOf("nix") >= 0 || OSName.indexOf("nux") >= 0 || OSName.indexOf("aix") > 0) {
                    _setDefaultDriverOnLinux(browserType, driverFolderPath);
                } else if (OSName.indexOf("sunos") >= 0) {
                    System.out.println("This is Solaris");
                } else {
                    System.out.println("Your OS is not support!!");
                }
            }
        } else if (server.contains("remote")) {
            String seleniumhubaddress = System.getProperty("vm.IP");
            if (seleniumhubaddress == null || seleniumhubaddress.isEmpty()) {
                seleniumhubaddress = ReadWritePropertyFile.getProperty("seleniumserverhost", BaseAutomation.configFile);
            }
            if (browserVersion != null) {
                if (OSName.indexOf("win") >= 0) {
                    _setBinaryDriverOnWindows(browserType, browserVersion, driverFolderPath, seleniumhubaddress);
                }
            } else {
                if (OSName.indexOf("win") >= 0) {
                    _setDefaultDriverOnWindows(browserType, driverFolderPath, seleniumhubaddress);
                }
            }
        } else if (server.contains("mobile")) {
            String[] mobileDevice = null;
            if (System.getProperty("mobileDevice") != null) {
                mobileDevice = System.getProperty("mobileDevice").split(":");
            }
            if (mobileDevice == null || mobileDevice.length == 0) {
                mobileDevice = ReadWritePropertyFile.getProperty("mobileDevice", BaseAutomation.configFile).split(":");
            }
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", mobileDevice[0]);
            cap.setCapability("device", mobileDevice[1]);
            cap.setCapability("platformName", mobileDevice[1]);
            cap.setCapability("browserName", mobileDevice[2]);
//            cap.setCapability("real_mobile", "true");
            cap.setCapability("platformVersion", "8.0");
//            cap.setCapability(CapabilityType.PLATFORM, "Windows");
            String appiumServerHostUrl = ReadWritePropertyFile.getProperty("appiumIP", BaseAutomation.configFile);
            URL appiumServerHost = null;
            try {
                appiumServerHost = new URL(appiumServerHostUrl);
            } catch (MalformedURLException e) {

            }
            cap.setJavascriptEnabled(true);
            System.out.println(appiumServerHostUrl);
            DriverInitiator.driver = new RemoteWebDriver(appiumServerHost, cap);
        }
    }

    @SuppressWarnings("deprecation")
    private void _setDefaultDriverOnWindows(String browserType, String driverFolderPath) {
        if (browserType.equalsIgnoreCase("CHROME")) {
            String chromeDriverPath = driverFolderPath + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options = acceptSecureCertificate(options);
            _setProxyMonitor(capabilities, browserType, options);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            DriverInitiator.driver = new ChromeDriver((Capabilities) capabilities);
        }
        if (browserType.equalsIgnoreCase("FIREFOX")) {
            String firefoxDriverPath = driverFolderPath + "geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            DriverInitiator.driver = new FirefoxDriver();
        }
        if (browserType.equalsIgnoreCase("IE")) {
            String internetExplorerDriverPath = driverFolderPath + "IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", internetExplorerDriverPath);
            DriverInitiator.driver = new InternetExplorerDriver();
        }
    }

    private void _setDefaultDriverOnWindows(String browserType, String driverFolderPath, String serverHost) {
        DesiredCapabilities cap = null;
        URL selserverhost = null;
        try {
            selserverhost = new URL(serverHost);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (browserType.equalsIgnoreCase("CHROME")) {
            String chromeDriverPath = driverFolderPath + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options = acceptSecureCertificate(options);
            cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            _setProxyMonitor(cap, browserType, options);
            DriverInitiator.driver = new RemoteWebDriver(selserverhost, cap);
        }
        if (browserType.equalsIgnoreCase("FIREFOX")) {
            String firefoxDriverPath = driverFolderPath + "geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            cap = DesiredCapabilities.firefox();
            DriverInitiator.driver = new RemoteWebDriver(selserverhost, cap);
        }
        if (browserType.equalsIgnoreCase("IE")) {
            String internetExplorerDriverPath = driverFolderPath + "IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", internetExplorerDriverPath);
            cap = DesiredCapabilities.internetExplorer();
            DriverInitiator.driver = new RemoteWebDriver(selserverhost, cap);
        }
    }

    /*
     @auther Vikash Agrawal, Mohit Dagar
     This method set the chrome driver options and capabilities for linux machine
     */
    private void _setDefaultDriverOnLinux(String browserType, String driverFolderPath) {
        if (browserType.equalsIgnoreCase("CHROME")) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options = acceptSecureCertificate(options);
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--window-size=1366,768");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            _setProxyMonitor(capabilities, browserType, options);
            try {
                DriverInitiator.driver = (RemoteWebDriver) new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
                DriverInitiator.driver.setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException ex) {
                Logger.getLogger(DriverInitiator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (browserType.equalsIgnoreCase("FIREFOX")) {
            String firefoxDriverPath = driverFolderPath + "geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            try {
                DriverInitiator.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } catch (MalformedURLException ex) {
                Logger.getLogger(DriverInitiator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*
     @auther Vikash Agrawal,Mohit Dagar
     This method set the binary path for the driver to execute the test on specific browser version
     */
    private void _setBinaryDriverOnWindows(String browserType, String browserVersion, String driverFolderPath, String serverHost) {
        URL selserverhost = null;
        try {
            System.out.println("URL: " + serverHost);
            selserverhost = new URL(serverHost);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String binaryPath, driverPath;
        if (browserType.equalsIgnoreCase("CHROME")) {
            binaryPath = driverFolderPath + "ChromeVersions" + File.separator + "Chrome" + browserVersion + File.separator + "chrome.exe";
            driverPath = driverFolderPath + "jars" + File.separator + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options = acceptSecureCertificate(options);
            options.setExperimentalOption("useAutomationExtension", false);
            options.setBinary(binaryPath);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            _setProxyMonitor(capabilities, browserType, options);
            DriverInitiator.driver = new RemoteWebDriver(selserverhost, (Capabilities) capabilities);
        }
        if (browserType.equalsIgnoreCase("FIREFOX")) {
            binaryPath = driverFolderPath + "MozillaVersions" + File.separator + "Mozilla Firefox" + browserVersion + File.separator + "firefox.exe";
            driverPath = driverFolderPath + "jars" + File.separator + "geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", driverPath);
            FirefoxBinary binary = new FirefoxBinary(new File(binaryPath));
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.cache.disk.enable", false);
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(binary);
            options.setProfile(profile);
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            DriverInitiator.driver = new RemoteWebDriver(selserverhost, options);
        }
    }

    /*
     @auther Vikash Agrawal,Mohit Dagar
     This method set the binary path for the driver to execute the test on specific browser version
     */
    private void _setBinaryDriverOnLinux(String browserType, String browserVersion, String driverFolderPath) {
        String binaryPath, driverPath;
        if (browserType.equalsIgnoreCase("CHROME")) {
            binaryPath = driverFolderPath + "ChromeVersions" + File.separator + "Chrome" + browserVersion + File.separator + "chrome.exe";
            driverPath = driverFolderPath + "jars" + File.separator + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.setBinary(binaryPath);
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--window-size=1366,768");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            _setProxyMonitor(capabilities, browserType, options);
            try {
                DriverInitiator.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), (Capabilities) capabilities);
            } catch (MalformedURLException ex) {
                Logger.getLogger(DriverInitiator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (browserType.equalsIgnoreCase("FIREFOX")) {
            binaryPath = driverFolderPath + "MozillaVersions" + File.separator + "Mozilla Firefox" + browserVersion + File.separator + "firefox";
            driverPath = driverFolderPath + "jars" + File.separator + "geckodriver";
            System.setProperty("webdriver.gecko.driver", driverPath);
            FirefoxBinary binary = new FirefoxBinary(new File(binaryPath));
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.cache.disk.enable", false);
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(binary);
            options.setProfile(profile);
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            try {
                DriverInitiator.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (MalformedURLException ex) {
                Logger.getLogger(DriverInitiator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void _setBinaryDriverOnWindows(String browserType, String browserVersion, String driverFolderPath) {
        String binaryPath, driverPath;
        if (browserType.equalsIgnoreCase("CHROME")) {
            binaryPath = driverFolderPath + "ChromeVersions" + File.separator + "Chrome" + browserVersion + File.separator + "chrome.exe";
            driverPath = driverFolderPath + "jars" + File.separator + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options = acceptSecureCertificate(options);
            options.setExperimentalOption("useAutomationExtension", false);
            options.setBinary(binaryPath);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            DriverInitiator.driver = new ChromeDriver((Capabilities) capabilities);
        }
        if (browserType.equalsIgnoreCase("FIREFOX")) {
            binaryPath = driverFolderPath + "MozillaVersions" + File.separator + "Mozilla Firefox" + browserVersion + File.separator + "firefox.exe";
            driverPath = driverFolderPath + "jars" + File.separator + "geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", driverPath);
            FirefoxBinary binary = new FirefoxBinary(new File(binaryPath));
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.cache.disk.enable", false);
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary(binary);
            options.setProfile(profile);
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            DriverInitiator.driver = new FirefoxDriver(options);
        }
        if (browserType.equalsIgnoreCase("IE")) {
            String internetExplorerDriverPath = driverFolderPath + "IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", internetExplorerDriverPath);
            DriverInitiator.driver = new InternetExplorerDriver();
        }
    }

    private ChromeOptions acceptSecureCertificate(ChromeOptions options) {
        options.addArguments("ignore-certificate-errors");
        options.setAcceptInsecureCerts(true);
        return options;
    }

    private void _setProxyMonitor(DesiredCapabilities cap, String browserType, Object optionOrProfile) {
        String monitorNetwork = System.getProperty("monitorNetwork");
        if (monitorNetwork == null) {
            monitorNetwork = ReadWritePropertyFile.getProperty("monitorNetwork", BaseAutomation.configFile);
        } else if (monitorNetwork.trim().isEmpty()) {
            monitorNetwork = ReadWritePropertyFile.getProperty("monitorNetwork", BaseAutomation.configFile);
        }
        _configureProxyCapabilities(monitorNetwork.trim().toUpperCase(), cap, browserType.toUpperCase(), optionOrProfile);
    }

    private void _configureProxyCapabilities(String monitorNetwork, DesiredCapabilities cap, String browserType, Object optionOrProfile) {
        networkMonitorSwitch = monitorNetwork;
        switch (monitorNetwork) {
            case "TRUE":
                try {
                    fw = new FileWriter(networkInfoCSVPath, true);
                    bw = new BufferedWriter(fw);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                proxy = new BrowserMobProxyServer();
                proxy.setTrustAllServers(true);
                proxy.start(0);
                Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
                switch (browserType) {
                    case "CHROME":
                        ((ChromeOptions) optionOrProfile).setProxy(seleniumProxy);
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
    }
}
