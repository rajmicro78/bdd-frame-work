package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import implementation.CommonFunction;

public class SearchPage {
	private WebDriver driver;
	@FindBy(id = "txt-search")
	private WebElement searchbox;
	@FindBy(xpath = "(//button[contains(@class, 'button-search')])[1]")
	private WebElement searchBtn;
	CommonFunction cf = new CommonFunction();

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public void doSearch(String sitecode) {
		String GiftCard = cf.getGC(sitecode);
		searchbox.click();
		searchbox.sendKeys(GiftCard);

	}

	public void clicksearchbtn() throws Exception {
		Thread.sleep(2000);

		searchBtn.click();
		Thread.sleep(2000);
	}

}
