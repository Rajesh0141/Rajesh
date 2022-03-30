package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this is CreateNewProductPage libraries
 * @author RajeshBhukya
 *
 */
public class CreateNewProductPage {
	
	//initialization on WebElement 
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//declaration of WebElement 
	@FindBy(name="productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//b[text()='Product Information']/preceding::input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	public WebElement getSavebutton() {
		return savebutton;
	}
	/**
	 * choose 
	 * @param productName
	 */
	public void createNewOrganization(String productName) {
		productNameTextField.sendKeys(productName);
		savebutton.click();
	}
	

}
