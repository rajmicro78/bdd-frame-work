package com.qa.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/**
	 * This method is used to initialize the threadlocal driver on basis of giver browser
	 * @param browser
	 * @return this will return driver
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("Execution Browser - "+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			tlDriver.set(new ChromeDriver(options));
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());			
		}else {
			System.out.println("Browser value not set check DriverFactory-"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	

}
