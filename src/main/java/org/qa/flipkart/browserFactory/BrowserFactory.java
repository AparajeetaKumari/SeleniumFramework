package org.qa.flipkart.browserFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.qa.flipkart.dataProvider.ConfigReader;


public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getBrowserInstance()
    {
        return driver;
    }


    public static WebDriver startBrowser(String browserName,String applicationURL) throws MalformedURLException {


        if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome"))
        {
            ChromeOptions opt=new ChromeOptions();
            driver=new ChromeDriver(opt);

        }
        else if(browserName.contains("Firefox"))
        {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver=new FirefoxDriver();
        }
        else if(browserName.contains("Safari"))
        {
            driver=new SafariDriver();
        }
        else if(browserName.contains("Edge"))
        {
            driver=new EdgeDriver();
        }
        else {
            driver=new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.get(applicationURL);

       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

       driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
        //return new RemoteWebDriver(new URL("https://" + username + ":" +  accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
    }

}