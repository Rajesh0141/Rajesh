package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is MoreOption Object Repository
 * @author RajeshBhukya
 *
 */
public class MoreOptionsPage {
	//initialization for WebElement
	public MoreOptionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//declaration of WebElement
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLinkText;
	
	public WebElement getCampaignsLinkText() {
		return CampaignsLinkText;
	}
	/**
	 * used to login compaignPage
	 */
	public void compaign() {
		CampaignsLinkText.click();
	}

}
