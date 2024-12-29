package com.Flipkart.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base implements Flipkart_API {
	
	RemoteWebDriver driver;
	WebDriverWait wait=null;
	
	long maximumwait=10;

	@Override
	public void setup(String url) {
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maximumwait));
		driver.get(url);
		
	}

	@Override
	public void setup(Browsers Browsername, String Url) {
		// TODO Auto-generated method stub
		
		switch (Browsername) {
		case CHROME:
			driver=new ChromeDriver();
		  break;
		case FIREFOX:
			driver=new FirefoxDriver();
		  break;
		case EDGE:
			driver=new EdgeDriver();
		  break;


		default:
			System.err.println("driver is not defined");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(Url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(maximumwait)); 

		
	}

	@Override
	public WebElement element(Locator type, String value) {
		// TODO Auto-generated method stub
		switch (type) {
		case id:
			return driver.findElement(By.id(value));
			//break;
		case name:
			return driver.findElement(By.name(value));
		case classname:
			return driver.findElement(By.className(value));
		case tagName :
			return	driver.findElement(By.tagName(value));
		case linktext:
			return driver.findElement(By.linkText(value));
		case css:
			return driver.findElement(By.cssSelector(value));
		case xpath:
			return driver.findElement(By.xpath(value));
		case partialLinktext:
			return driver.findElement(By.partialLinkText(value));

		default:
			break;
		}

		return null;
	}

	@Override
	public void selectvalue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select oselect=new Select(ele);
		oselect.selectByValue(value);
	
		
		
	}

	@Override
	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		
	}

	@Override
	public void type(WebElement ele, String testdata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isdisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isselected(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
		driver.close();
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		driver.quit();
		
	}

	public void type(WebElement ele, String testdata, Keys key) {
		// TODO Auto-generated method stub
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
	      element.clear();
	      element.sendKeys(testdata,key);
		
	}

	@Override
	public void windowhandling(int i) {
		// TODO Auto-generated method stub
		Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> windowHandlesList = new ArrayList<>(allWindowHandles); // Convert Set to ArrayList

        // Check if the index is valid
        if (i < 0 || i >= windowHandlesList.size()) {
            System.out.println("Invalid index: " + i);
            return;
        }

        // Switch to the window with the index i
        String windowHandle = windowHandlesList.get(i);
        driver.switchTo().window(windowHandle);
	}

	@Override
	public void action(WebElement ele) {
		// TODO Auto-generated method stub
		
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		act.perform();
		
	}
	
	

}
