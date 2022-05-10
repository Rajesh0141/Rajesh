package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.VtigerBRAJ.genericUtility.WebDriverUtility;


/**
 * this is create new organization homePage
 * @author RajeshBhukya
 *
 */
public class CreatingNewOrganizationPage extends WebDriverUtility  {
	
	//initialization of WebElement
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration of WebElement 
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	
	@FindBy(xpath="//b[text()='Organization Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getindustryDropdown() {
		return industryDropdown;
	}
	public WebElement getOrganizationName() {
		return organizationNameTextField;
	}

	/**
	 * send the organization name and select the industry of dropdown
	 * @param orgName
	 * @param DropdownValue
	 */
	
	public void organizationTextField(String orgName , String DropdownValue) {
		organizationNameTextField.sendKeys(orgName);
		select(industryDropdown, DropdownValue);
		savebutton.click();
	}
}
