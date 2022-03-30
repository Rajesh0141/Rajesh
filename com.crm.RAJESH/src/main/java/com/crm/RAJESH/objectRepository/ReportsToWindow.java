package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsToWindow {
	
	//initialize the WebElement
	public ReportsToWindow(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration for WebElement
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement serachButton;
	
	@FindBy(linkText="Rajesh")
	private WebElement clickOnExistingContact;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSerachButton() {
		return serachButton;
	}
	
	
	public void searchContactInreportsToWindow(WebDriver driver ,String expectedContactName) {
		searchTextField.sendKeys(expectedContactName);
		serachButton.click();
		clickOnExistingContact.click();
	}

}
