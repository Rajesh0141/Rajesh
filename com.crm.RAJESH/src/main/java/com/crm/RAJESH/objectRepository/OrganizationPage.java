package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is Organization homePage Object  Repository
 * @author RajeshBhukya
 *
 */
public class OrganizationPage {
	
	//initialization of WebElement 
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of WebElement 
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement clickAddImageIcon;

	public WebElement getClickAddImageIcon() {
		return clickAddImageIcon;
	}
	//bussiness logic
	/**
	 * used to click AddImageIconc open createNewOrganization
	 */
	public void AddImageIconclick() {
		clickAddImageIcon.click();
	}

}
