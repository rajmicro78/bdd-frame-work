package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.GenericFunction;

public class ProductDetailPage {
	private WebDriver driver;
	GenericFunction gf = new GenericFunction();

	@FindBy(id = "ddlQuantityOptions")
	private WebElement qtyDropdown;
	
	@FindBy(xpath="(//button[contains(@class,'addToCartButton')])[1]")
	private WebElement addtoCartBtn;

	@FindBy(xpath="(//a[contains(@href,'cart')]//span)[1]")
	private WebElement carttext;
	
	// Page constructor
	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public void selectqty() {
		Select qtydrpdown = new Select(qtyDropdown);
		if(qtydrpdown.getOptions().size()>1) {
		qtydrpdown.selectByIndex(1);}else {
			qtydrpdown.selectByIndex(0);
		}
	}
	
	public void clickaddtocart() throws Exception  {
		
		System.out.println("Cart text-"+carttext.getAttribute("style"));
		do {
	//		gf.retryingFindClick(addtoCartBtn);
			addtoCartBtn.click();
			Thread.sleep(3000);
			System.out.println("Cart text-"+carttext.getAttribute("style"));
		}while(carttext.getAttribute("style").contains("none"));
		
		//addtoCartBtn.click();
	}

}
