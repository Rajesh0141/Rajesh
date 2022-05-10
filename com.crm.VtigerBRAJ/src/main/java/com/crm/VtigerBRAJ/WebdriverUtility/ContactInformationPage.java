package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is ContactInformationPage libraries
 */
public class ContactInformationPage {
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getContactInformation() {
		return contactInformation;
	}

	@FindBy(css="span.dvHeaderText")
	private WebElement contactInformation;
	
	/**
	 * its return contactInformation text
	 * @return
	 */
	public String ActualContacxtInfo() {
		return contactInformation.getText();
	}

}
