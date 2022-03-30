package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is contactPage Repository
 * @author RajeshBhukya
 *
 */
public class ContactPage {
	
	//initialization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	//declaration for WebElement 
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement clickaddImageIcon;

	
	public WebElement getClickaddImageIcon() {
		return clickaddImageIcon;
	}
	/**
	 * this is perform to click addIcon image
	 */
	public void clickAddIcon() {
		clickaddImageIcon.click();
	}
	
	

}
