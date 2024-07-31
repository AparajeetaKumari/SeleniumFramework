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
    protected static MutableCapabilities capabilities;
    protected static   HashMap<String, Object> bstackOptions;




    public static WebDriver startBrowser(String browserName,String applicationURL) throws MalformedURLException {


        if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome"))
        {
            bstackOptions = new HashMap<String, Object>();
            capabilities = new MutableCapabilities();
            capabilities.setCapability("bstack:options", bstackOptions);
            capabilities.setCapability("browserName", "Chrome");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("consoleLogs", "info");
            bstackOptions.put("browserVersion", "125.0");
            bstackOptions.put("projectName", "Test");
            bstackOptions.put("buildName", "1");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            //bstackOptions.put("seleniumVersion", "3.14.0");

//            capabilities.setCapability(ChromeOptions.CAPABILITY, options);


        } else if(browserName.contains("Firefox")){
            bstackOptions = new HashMap<String, Object>();
            capabilities = new MutableCapabilities();
            FirefoxOptions options = new FirefoxOptions();
            capabilities.setCapability("browserName", "Firefox");
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("consoleLogs", "info");
            bstackOptions.put("browserVersion", "127.0");
            bstackOptions.put("projectName", "Test");
            bstackOptions.put("buildName", "1");
            capabilities.setCapability("bstack:options", bstackOptions);
            options.addArguments("--start-maximized");
           //bstackOptions.put("seleniumVersion", "3.5.2");

        }



       WebDriver driver =   new RemoteWebDriver(new URL(BS_URL), capabilities);
         driver.get(applicationURL);
         return driver;



    }
}
