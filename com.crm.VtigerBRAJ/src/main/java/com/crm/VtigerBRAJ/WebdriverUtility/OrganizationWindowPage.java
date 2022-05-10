package com.crm.VtigerBRAJ.WebdriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is OrganizationWindowPage Object Repository
 * @author RajeshBhukya
 *
 */
public class OrganizationWindowPage {
	public OrganizationWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
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
	 * used to searchOraganizationName and click on SearchButton  and Click SearchOraganizationName
	 * @param driver
	 * @param orgName
	 */
	public void chooseOrganizationIn0Window(WebDriver driver ,String orgName) {
		searchTextField.sendKeys(orgName);
		searchButton.click();
		WebElement chooseOrgName= driver.findElement(By.xpath("//a[text()='"+orgName+"']"));
		chooseOrgName.click();
	}

}
