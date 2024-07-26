package org.qa.flipkart.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.flipkart.base.BaseClass;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;


public class HomePage extends BaseClass {
    By searchProductTestBox= By.className("Pke_EE");
    By serachBox = By.xpath("//button[contains(@title,'Search for')]");

    By categoryMobile = By.xpath("//a[@title='Mobiles']");

    By samsungBrand = By.xpath("//div[text()='SAMSUNG']//preceding-sibling::input");
    //By samsungBrand=By.cssSelector(".XqNaEv");

    By flipkartAssured = By.xpath("//div[@class='XqNaEv eJE9fb']");

    By highToLow = By.xpath("//div[contains(text(),'High to Low')]");

    By phones = By.xpath("//div[@class='tUxRFH']");

    By phoneName = By.xpath("//div[@class='KzDlHZ']");

    By price = By.xpath("//div[@class='Nx9bqj _4b5DiR']");

    By link = By.className("CGtC98");

    JavascriptExecutor js ;




    //a[text()='Mobiles']

    //div[text()='SAMSUNG']
    public HomePage(WebDriver driver) {
       this.driver = driver;
    }





    public void searchProductSearchTextBox(String searchProductName) {
        waitForPageLoad();
       driver.findElement(searchProductTestBox).sendKeys(searchProductName);
       driver.findElement(serachBox).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();",driver.findElement(serachBox));
    }

    public void selectMobilesCategory(){
        driver.findElement(categoryMobile).click();
    }

    public void checkBrandsUsingJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();arguments[1].click();",driver.findElement(samsungBrand),driver.findElement(flipkartAssured));
    }

    public void clickOnSamsungCheckboxJS(){
        //waitForElementToBeVisible(samsungBrand);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(samsungBrand));
    }

    public void clickOnFlipkartAssuredCheckbox(){
         js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(flipkartAssured));
    }

    public void clickOnHighToLowPriceFilter(){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",driver.findElement(highToLow));
    }

    public List<WebElement> listOfPhones(){
        return driver.findElements(phones);
    }


    public List<WebElement> listOfPhoneNames(){
        //scrollDown();
        return driver.findElements(phoneName);

    }

    public List<WebElement> listOfPhonePrices(){
        //scrollDown();
        return driver.findElements(price);

    }

    public List<WebElement> listOfPhoneLinks(){
        System.out.println("Inside links");
        return driver.findElements(link);

    }
}
