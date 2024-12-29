package com.Flipkart.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface Flipkart_API {
	
	/**
	 * This  method will launch  chrome browser with given Url
	 * @author praising
	 * @param Url
	 * @exception NullpointerException
	 */	
	void setup(String ul);
	
	/**
	 * This method will launch the browser with given url
	 * @author praising
	 * @param Browsername
	 * @param Url
	 * @exception NullpointerException
	 */
	 
	 void setup(Browsers Browsername,String Url);
	 
	 /**
		 * This Method is used to find any Element  with in the package.
		 * @param type - Element type eg  -id,name ,classname,Tagname,linktext,partiallinktext,Css,Xpath
		 * @param value -Element value
		 * @return WebElement
		 */
	  WebElement element(Locator type,String value);
	  /**
		 * This method is used to select any value in dropdown
		 * @param ele
		 * @param value
		 */
		void selectvalue(WebElement ele,String value);
		
		void click(WebElement ele);
		
		
		
		void type(WebElement ele,String testdata);
		/**
		 * This method will check the image is displayed or not
		 * @param ele
		 * @return
		 */
		boolean isdisplayed(WebElement ele);
		
		/**
		 * This method will check the element is enabled or not
		 * @param ele
		 * @return
		 */
		
		boolean isEnabled(WebElement ele);
		
		/**
		 * This method will check the element is selected or not
		 * @param ele
		 * @return
		 */
		
		boolean isselected(WebElement ele);
		
		/**
		 * This Method is used to handle the window
		 * @param i
		 */
		void windowhandling(int i);
		
		 
		/**
		 * This  Method will close the current focused browser
		 */
		void close();
		/**
		 * This Method  Will close the all the browser .
		 */
		void quit();

		/**
		 * This method  have the webelement,testdata and keys to do mouse action.
		 * @author praising
		 * @param ele
		 * @param testdata
		 * @param key
		 */
		void type(WebElement ele, String testdata, Keys key);
		
		void action(WebElement ele);

}
