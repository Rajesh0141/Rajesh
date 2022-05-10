package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is organizationInformation object libraries
 * @author RajeshBhukya
 *
 */
public class InformationOfOrganizationPage {
	
	//initialization of WebElement 
	public InformationOfOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration of WebElement 
	@FindBy(css="span.dvHeaderText")
	private WebElement orgInformation;

	public WebElement getOrgInformation() {
		return orgInformation;
	}
	/**
	 * its return organizationInformationText 
	 * @return
	 */
	public String  actualOrgNameText() {
		return orgInformation.getText();
		
	}

}
