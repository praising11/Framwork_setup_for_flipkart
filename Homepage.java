package com.Flipkart.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homepage extends Base {
    // Create a Logger instance for the class
    private static final Logger log = LoggerFactory.getLogger(Homepage.class);
    
    SoftAssert same = new SoftAssert();

    @Test
    void Flipkart_homepage() {
        // Log the test start
        log.info("Starting the Flipkart homepage test.");

        // Setup browser and navigate to the URL
        setup(Browsers.CHROME, "https://www.flipkart.com/");
        
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        String actualTitle = driver.getTitle();
        
        log.info("Page Title is: {}", actualTitle); // Log the actual page title
        
        // Assert the page title
         same.assertEquals(actualTitle, expectedTitle);
        
        // Perform actions on the webpage
        log.info("Entering search term 'Nothing2a' in the search box.");
        type(element(Locator.xpath, "//input[@class=\"Pke_EE\"]"), "Nothing2a",Keys.ENTER);
        
        log.info("Selecting value '20000' from the dropdown.");
        selectvalue(element(Locator.xpath, "(//select[@class=\"Gn+jFg\"])[1]"), "20000");
        
        log.info("Clicking on 'Offer Zone' link.");
        click(element(Locator.xpath, "//a[@class=\"TSD49J\" and contains(text(), \"Offer Zone\")]"));
		/*
		 * WebElement mi,
		 * electronics=driver.findElement(By.xpath("(//span[@class=\\\"TSD49J\\\"])[1]")
		 * ); action(electronics); mi=driver.findElement(By.xpath("//a[@title='Mi']"));
		 * mi.click();
		 */
        driver.navigate().back();
 
        
        click(element(Locator.xpath, "//div[@class=\"ZHvV68\" and contains(text(),\"Camera Bags\")]"));
        click(element(Locator.xpath, "(//div[@class=\"+7E521\"])[1]"));
        // Assert all soft assertions
        same.assertAll();
        
       
    }
}
