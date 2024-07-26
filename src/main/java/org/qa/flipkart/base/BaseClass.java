package org.qa.flipkart.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.flipkart.browserFactory.BrowserFactory;
import org.qa.flipkart.browserFactory.BrowserStackFactory;
import org.qa.flipkart.dataProvider.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseClass {

    protected WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Parameters({ "browser", "url" })
   @BeforeMethod
    public WebDriver setupBrowser(String browser, String url) throws MalformedURLException {

        System.out.println("Browser Name is::"+browser);
       // driver= BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));
        driver= BrowserFactory.startBrowser(browser,url);
       //driver= BrowserStackFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));

        System.out.println("LOG:INFO - Application is up and running");
        return driver;

    }



    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();

        System.out.println("LOG:INFO - Closing the browser and application");
    }


    protected  void waitForPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    protected void scrollDown(){
        Actions a = new Actions(driver);
        //scroll down a page
       a.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    protected void waitForElementToBeVisible(By element){
       wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }



}
