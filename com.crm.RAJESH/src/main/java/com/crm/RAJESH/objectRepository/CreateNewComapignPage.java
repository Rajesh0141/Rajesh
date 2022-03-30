package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.RAJESH.genericUtility.WebDriverUtility;




/**
 * this is CreateNewComapignPage libraries
 * @author RajeshBhukya
 *
 */
public class CreateNewComapignPage {
	WebDriverUtility wLib=new WebDriverUtility();
	//initialization for WebElement 
	public CreateNewComapignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//declaration For WebElement 
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif' and @style]")
	private WebElement clickProductAddImage;
	
	@FindBy(xpath="//b[text()='Campaign Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}
	public WebElement getClickProductAddImage() {
		return clickProductAddImage;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * its provide 
	 * @param compaginName compaginName and ProductAddImage and Switch to window for Campaign
	 * Page to Product window page
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void compaignName(String compaginName,WebDriver driver ,String partialWindowTitle) {
		campaignNameTextField.sendKeys(compaginName);
		clickProductAddImage.click();
		wLib.switchToWindow(driver, partialWindowTitle);
	}
	/**
	 * Switch to window from ProductWindow to MainPage and Save the CampaignPage
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void saveCompaign(WebDriver driver , String partialWindowTitle) {
		wLib.switchToWindow(driver, partialWindowTitle);
		saveButton.click();
	}
	
	
	
}
