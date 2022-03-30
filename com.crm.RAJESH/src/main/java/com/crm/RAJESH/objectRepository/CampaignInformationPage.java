package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is CampaignInformation Page libraries
 * @author RajeshBhukya
 *
 */
public class CampaignInformationPage {
	
	//initialization for WebElement 
    public CampaignInformationPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
	//declaration for WebElement 
	@FindBy(css="span.dvHeaderText")
	private WebElement informationText;
	public WebElement getInformationText() {
		return informationText;
	}
	/**
	 * its return campaignInformationText
	 * @return
	 */
	public String  campaignInformationText() {
		return informationText.getText();
		
	}

}
