package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class GenericFunction {
	
	public void TypeInField(WebElement idelement, String value) throws Exception {
		idelement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		idelement.sendKeys(value);
		Thread.sleep(1000);
//		String elemtex= idelement.getAttribute("autocomplete");
//		System.out.println("elemtex-"+elemtex);
//		if(!elemtex.equalsIgnoreCase("")) {
//			idelement.clear();
//			idelement.sendKeys(value);
	
//		}
	//	idelement.sendKeys(Keys.RETURN);

//		Thread.sleep(1000);


//		String currentvalue = idelement.getAttribute("value");
//		System.out.println("currentvalue" + currentvalue);

// CHangest done on 9 nov at 3 PM		
//		do {
//			idelement.sendKeys(value);
//			Thread.sleep(1000);
//		} while (!idelement.getAttribute("autocomplete").equalsIgnoreCase(""));

		
		
		/*
		 * if (currentvalue.equalsIgnoreCase(value)) {
		 * System.out.println("value matches"); } else {
		 * System.out.println("value didn't matches"); String val = value; WebElement
		 * element = idelement; // driver.findElement(By.id(xpath)); element.clear();
		 * element.sendKeys(val); Thread.sleep(1000);
		 * 
		 * for (int i = 0; i < val.length(); i++) { char c = val.charAt(i); String s =
		 * new StringBuilder().append(c).toString(); element.sendKeys(s);
		 * Thread.sleep(100); }
		 * 
		 * }
		 */
		
/*		
		   String val = value; 
		    WebElement element = idelement;
		    	//	driver.findElement(By.id(xpath));
		    element.clear();
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element.sendKeys(s);

		    }  

			Thread.sleep(1000);
*/
	}

	public void retryingFindClick(WebElement webElement) throws Exception  {
	//	boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				webElement.click();
				Thread.sleep(1000);
		//		result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		//return result;
	}


}
