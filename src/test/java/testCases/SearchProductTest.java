package testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.qa.flipkart.base.BaseClass;
import org.qa.flipkart.dataProvider.ConfigReader;
import org.qa.flipkart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductTest extends BaseClass {


    @Test
    public void searchProductTest(){
        List<WebElement> prices;
        List<WebElement> phoneName;
        List<WebElement> links;

        //driver.get("https://www.flipkart.com/");
        HomePage homepage = new HomePage(driver);
        homepage.searchProductSearchTextBox("Samsung Galaxy S10");
        System.out.println("Page title is ::"+driver.getTitle());
        homepage.selectMobilesCategory();
        homepage.clickOnSamsungCheckboxJS();
        homepage.clickOnFlipkartAssuredCheckbox();
        homepage.clickOnHighToLowPriceFilter();

         List<WebElement> phones = homepage.listOfPhones();
        Assert.assertFalse(phones.isEmpty());
        System.out.println("Total number of phones on the first page :"+phones.size());

        try{
            phoneName = homepage.listOfPhoneNames();
            Assert.assertEquals(phones.size(),phoneName.size());
            System.out.println("Total number of phones names :"+phoneName.size());
            for(WebElement ele: phoneName){
                System.out.println(ele.getText());
            }

            prices= homepage.listOfPhonePrices();
            System.out.println("Total number of prices :"+prices.size());
            Assert.assertEquals(phones.size(),prices.size());
            for(WebElement ele: prices){
                System.out.println(ele.getText());
            }

           links = homepage.listOfPhoneLinks();
            System.out.println("Total number of links :"+links.size());
           for(WebElement ele: links){
           System.out.println(ele.getAttribute("href"));
       }
        }catch(StaleElementReferenceException se){
            phoneName = homepage.listOfPhoneNames();
            prices= homepage.listOfPhonePrices();
            links = homepage.listOfPhoneLinks();
        }


    }
}
