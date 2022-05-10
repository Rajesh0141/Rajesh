package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.VtigerBRAJ.genericUtility.WebDriverUtility;






/**
 * this is CreatingNewContactPage Libraries
 * @author RajeshBhukya
 *
 */
public class CreatingNewContactPage extends WebDriverUtility{
	
	WebDriverUtility wLib=new WebDriverUtility();
	//initialization of WebElement 
	
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration for WebElement
	@FindBy(name="lastname")
	private WebElement contacttLastName;
	
	public WebElement getClickOrganizationAddIcon() {
		return clickOrganizationAddIcon;
	}	
	@FindBy(id="search_txt")
	private WebElement serchTextField;
	
	@FindBy(name="search")
	private WebElement serchButton;
	
	@FindBy(xpath="//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath="//input[@name='imagename']")
	private WebElement chooseFile;

	public WebElement getChooseFile() {
		return chooseFile;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSerchTextField() {
		return serchTextField;
	}

	public WebElement getSerchButton() {
		return serchButton;
	}

	@FindBy(xpath="//input[@name='account_name']/ancestor::td[@class='dvtCellInfo']/img")
	private WebElement clickOrganizationAddIcon;
	
	@FindBy(xpath="//input[@name='contact_name']/following-sibling::img[@alt='Select']")
	private WebElement clickReporterToAddIconImage;
	
	public WebElement getContactLastName() {
		return contacttLastName;
	}
	public WebElement getClickReporterToAddIconImage() {
		return clickReporterToAddIconImage;
	}
	//business Logic
	/**
	 * its create new Contact With MandatoryFields and choose one Organization
	 * Switch to window From MainPageWindowPage to OrganizationPage
	 * @param ContactLastName
	 * @param partialWindow
	 * @param driver
	 */
	public void contactLastName(String ContactLastName, String partialWindow, WebDriver driver){
		contacttLastName.sendKeys(ContactLastName);
		clickOrganizationAddIcon.click();
		wLib.switchToWindow(driver, partialWindow);
	}
	
	/**
	 *  Switch to window From OrganizationPage to MainPageWindowPage and Save the Contact
	 * @param driver
	 * @param partialWindow
	 */
	public void contactSave(WebDriver driver, String partialWindow) {
		wLib.switchToWindow(driver, partialWindow);
		saveButton.click();
	}
	/**
	 * this is contactWithMandatoryFields to create Contact
	 * @param ContactLastName
	 */
	
	public void contactWithMandatoryFields(String ContactLastName){
		contacttLastName.sendKeys(ContactLastName);
	}
	/**
	 * this is createNewContact ChooseFile action
	 * @param driver
	 */
	public void contactChooseFile(WebDriver driver) {
		wLib.waitForElementToBeClickAble(driver, chooseFile);
		chooseFile.click();
	}
	/**
	 * this is  CreateNewContact and clickReportsTo IconImage and change its DriverFocus  mainPage to ReportsToWindowPage
	 * @param driver
	 * @param parrtialWindowTiltle
	 */
	public void clickReportsTo(WebDriver driver, String parrtialWindowTiltle) {
		clickReporterToAddIconImage.click();
		wLib.switchToWindow(driver, parrtialWindowTiltle);
	}
	
}




