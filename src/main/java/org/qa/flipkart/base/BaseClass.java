package org.qa.flipkart.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.flipkart.browserFactory.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseClass {

    protected WebDriver driver;
    static String pageLoadStatus = null;

    JavascriptExecutor js;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Parameters({ "browser", "url" })
   @BeforeMethod
    public WebDriver setupBrowser(String browser, String url) throws MalformedURLException {

        System.out.println("Browser Name is::"+browser);
       // driver= BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));
        driver= BrowserFactory.startBrowser(browser,url);

        System.out.println("LOG:INFO - Application is up and running");
        return driver;

    }



    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();

        System.out.println("LOG:INFO - Closing the browser and application");
    }


    //Write explicit wait
    public void explicitWaitUtil(By element){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    protected void scrollDown(){
        Actions a = new Actions(driver);
        //scroll down a page
       a.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public  void waitForPageLoad() {

        do {

            js = (JavascriptExecutor) driver;

            pageLoadStatus = (String)js.executeScript("return document.readyState");

        } while ( !pageLoadStatus.equals("complete") );

        System.out.println("Page Loaded.");

    }



}
