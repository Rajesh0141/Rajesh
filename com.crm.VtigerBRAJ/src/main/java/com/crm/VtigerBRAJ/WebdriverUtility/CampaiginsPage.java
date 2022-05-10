package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

/**
 * this is CampaiginsPage Object libraries 
 * @author RajeshBhukya
 *
 */
public class CampaiginsPage {
	
	
	//initialization for WebElement 
	public CampaiginsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration for WebElement 
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement CreateCompaignAddImaeIcon;
	
	public WebElement getClickOnCreateCompaignAddImaeIcon() {
		return CreateCompaignAddImaeIcon;
	}

	/**
	 * click on "+" addImageIcon
	 * @return
	 */
	public void clickOnCreateCompaignAddImaeIcon() {
		CreateCompaignAddImaeIcon.click();
	}
	
}
