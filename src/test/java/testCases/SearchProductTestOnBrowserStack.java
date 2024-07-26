package testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.qa.flipkart.base.BaseClass;
import org.qa.flipkart.base.BaseRemoteClass;
import org.qa.flipkart.dataProvider.ConfigReader;
import org.qa.flipkart.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductTestOnBrowserStack extends BaseRemoteClass {


    @Test
    public void searchProductTest(){
        List<WebElement> prices;
        List<WebElement> phoneName;
        List<WebElement> links;

        driver.get("https://www.flipkart.com/");
        HomePage homepage = new HomePage(driver);
        homepage.searchProductSearchTextBox("Samsung Galaxy S10");
        //Assert.assertTrue(driver.getTitle().contains("Samsung Galaxy S10"));
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
            for(WebElement ele: phoneName){
                System.out.println(ele.getText());
            }

            prices= homepage.listOfPhonePrices();
            Assert.assertEquals(phones.size(),prices.size());
            for(WebElement ele: prices){
                System.out.println(ele.getText());
            }

            links = homepage.listOfPhoneLinks();
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
