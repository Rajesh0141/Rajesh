package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.VtigerBRAJ.genericUtility.WebDriverUtility;


/**
 * this is HomePage Object Repository
 * @author RajeshBhukya
 *
 */
public class HomePage extends WebDriverUtility {
	//initialization of WebElement
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of WebElement 
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement administratorIconImag;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText="More")
	private WebElement MoreLinkText;

	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getAdministratorIconImag() {
		return administratorIconImag;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getMoreLinkText() {
		return MoreLinkText;
	}
	//bussiness logic
	/**organization home page will be display
	 */
	public void Organization() {
		organizationLink.click();
	}
	/**
	 * contacts homePage Display
	 * @param driver 
	 */
	public void Contacts(WebDriver driver) {
		mouseOverOnElement(driver, contactsLink);
		contactsLink.click();
	}
	/**
	 * product  HomePage display
	 */
	public void products() {
		productsLink.click();
	}
	/*
	 * signOut from the application
	 */
	public void signOut(WebDriver driver) {
		mouseOverOnElement(driver, administratorIconImag);
		signOutLink.click();
	}
	/**
	 * its perform MouseOver action in MoreOptionLinkText
	 * @param driver
	 */
	public void MoreOption(WebDriver driver) {
		mouseOverOnElement(driver, MoreLinkText);
	}
}
