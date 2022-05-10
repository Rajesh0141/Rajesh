package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is ProductInformationPage Object Repository
 * @author RajeshBhukya
 *
 */
public class ProductInformationPage {
	//initialization of webElement 
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration of WebElement 
	@FindBy(css="span.lvtHeaderText")
	private WebElement productInformation;

	public WebElement getProductInformation() {
		return productInformation;
	}
	/**
	 * used to get the  InformationMsg 
	 * @return
	 */
	public String getInformationMsg() {
		return productInformation.getText();
	}
	
	

}
