package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is productPage Object  repository
 * @author RajeshBhukya
 *
 */
public class ProductPage {
	//intialization of WebElement

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration of WebElement
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement AddImageIcon;

	//bussiness logic
	/**
	 * used to click AddImageIcon to get createNewProductPage 
	 */
	public void clickAddImageIcon() {
		AddImageIcon.click();
	}
}
