package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.VtigerBRAJ.genericUtility.WebDriverUtility;




/**
 * this is used to ProductwindowPage Object Repository
 * @author RajeshBhukya
 *
 */
public class ProductwindowPage {
	WebDriverUtility wLib=new WebDriverUtility();
	//initialization for WebElement 
	public ProductwindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration for WebElement 
	@FindBy(id="search_txt")
	
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchButton;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	/**
	 * used to  search OrgName into searchTextField 
	 * switch to window MainPage to OrganizationPage and  click OrganizationName
	 * @param driver
	 * @param productName
	 */
	public void searchProduct(WebDriver driver , String productName) {
		searchTextField.sendKeys(productName);
		searchButton.click();
		WebElement chooseOrgName= driver.findElement(By.xpath("//a[text()='"+productName+"']"));
		wLib.waitForElementToBeClickAble(driver, chooseOrgName);
		chooseOrgName.click();
	}
}
