package org.qa.flipkart.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.qa.flipkart.base.BaseClass;
import java.util.List;


public class HomePage extends BaseClass {
    JavascriptExecutor js ;
    By searchProductTestBox=By.xpath("//input[contains(@placeholder,'Search for')]");

    By serachBoxButton = By.xpath("//button[@type='submit']");
            //By.xpath("//button[contains(@title,'Search for')]");

    By categoryMobile = By.xpath("//a[@title='Mobiles']");

    By samsungBrand = By.xpath("//div[text()='Brand']//following::img[1]//preceding::input[@type='checkbox'][2]");

    By flipkartAssured = By.xpath("//div[text()='Brand']//following::img[1]//preceding::input[@type='checkbox'][1]");

    By highToLow = By.xpath("//div[contains(text(),'High to Low')]");

    By phones = By.xpath("//div[@class='tUxRFH']");

    By phoneName = By.xpath("//div[@class='KzDlHZ']");

    By price = By.xpath("//div[@class='cN1yYO']");

    By link = By.className("CGtC98");

    By crossButton = By.xpath("//span[@role='button']");



    public HomePage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver,this);
    }





    public void searchProductSearchTextBox(String searchProductName) {
        waitForPageLoad();
       driver.findElement(searchProductTestBox).sendKeys(searchProductName);
       clickOnElement(serachBoxButton);

    }

    public void selectMobilesCategory(){
        clickOnElement(categoryMobile);
    }

    public void clickOnSamsungCheckboxJS(){
        clickOnElement(samsungBrand);
    }

    public void clickOnFlipkartAssuredCheckbox(){
        clickOnElement(flipkartAssured);
    }

    public void clickOnHighToLowPriceFilter(){
        clickOnElement(highToLow);
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


    public void clickOnElement(By element){
        driver.navigate().refresh();
        js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(element));



    }
}
