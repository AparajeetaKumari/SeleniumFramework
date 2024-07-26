package org.qa.flipkart.browserFactory;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class BrowserStackFactory {

    protected WebDriver driver;
    protected static final String USERNAME ="aparajeeta_guXlID";
    protected static final String AUTOMATE_KEY="Vnbh6wLe9HonykepqpYd";

    protected static final String BS_URL= "https://" +USERNAME+":"+AUTOMATE_KEY+"@hub.browserstack.com/wd/hub";
    protected static MutableCapabilities capabilities = new MutableCapabilities();
    protected static   HashMap<String, Object> bstackOptions = new HashMap<String, Object>();




    public static WebDriver startBrowser(String browserName,String applicationURL) throws MalformedURLException {

        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("browserVersion", "latest");
        bstackOptions.put("consoleLogs", "info");

        bstackOptions.put("projectName", "Test");
        bstackOptions.put("buildName", "1");
        capabilities.setCapability("bstack:options", bstackOptions);
        if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            bstackOptions.put("seleniumVersion", "3.14.0");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("browserName", "Chrome");

        } else if(browserName.contains("Firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            bstackOptions.put("seleniumVersion", "3.5.2");
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
            capabilities.setCapability("browserName", "Firefox");

        }

        return new RemoteWebDriver(new URL(BS_URL), capabilities);

    }
}
