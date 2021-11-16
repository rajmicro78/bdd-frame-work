package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.qa.util.GenericFunction;

import implementation.CommonFunction;

public class HomePage {
	private WebDriver driver;

	CommonFunction cf = new CommonFunction();
	GenericFunction gf = new GenericFunction();

	// page object of homepage

	@FindBy(xpath = "//h2[@class='site-logo']/a/img")
	private WebElement topLogo;
	@FindBy(xpath = "(//div[@class='category-level-1']/ul)[1]/li[contains(@class,'expandMenuItem')]")
	private List<WebElement> topMenuwithSubMenu;
	@FindBy(xpath = "(//li[contains(@class,'is-active')]//h3/a)[1]")
	private WebElement viewAllLink;
	@FindBy(xpath = "//div[contains(@class,'menu')]//a[contains(@href,'mypage')]")
	private WebElement topmypageicon;
	@FindBy(xpath="(//a[contains(@href,'logout')])[1]")
	private WebElement logoutBtn;
	private int topmenu;
	private int randomvalue;

	// Page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	public String getLogoText() {
		return topLogo.getAttribute("alt");
	}

	public void clicktopLogo() throws Exception  {
//		gf.retryingFindClick(topLogo);

		topLogo.click();
	}
	public void clickLogOut() throws Exception {
	//	gf.retryingFindClick(logoutBtn);
		logoutBtn.click();
	}

	public String getURL() {
		String url = cf.envioranment();
		return url;
	}

	public int clicktopMenu() {
		topmenu = topMenuwithSubMenu.size();
		System.out.println("topmenu Value-" + topmenu);
		randomvalue = cf.getRandom(topmenu);
		System.out.println("Menu Random Value-" + randomvalue);
		if (randomvalue == 0) {
			randomvalue = 1;
		}
		return randomvalue;
	}

	public void clickViewallLink(int menu) throws Exception  {
		String expandmenu = topMenuwithSubMenu.get(menu).getAttribute("class");
		System.out.println("expandmenu-" + expandmenu);
		if (expandmenu.contains("brands") && (topmenu == menu)) {
			menu = menu - 1;
		} else if (expandmenu.contains("brands")) {
			menu = menu + 1;
		}
		System.out.println("menu-" + menu);
	//	topMenuwithSubMenu.get(menu).click();
		gf.retryingFindClick(topMenuwithSubMenu.get(menu));
		System.out.println("View All- " + viewAllLink.getText());
		
		gf.retryingFindClick(viewAllLink);
	//	viewAllLink.click();
		// return new ProductListPage(driver);
	}

	public void clicktopmypage()   {
	//	gf.retryingFindClick(topmypageicon);
		topmypageicon.click();
	}
}
