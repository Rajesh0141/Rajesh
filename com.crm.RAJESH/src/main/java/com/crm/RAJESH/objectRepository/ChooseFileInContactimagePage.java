package com.crm.RAJESH.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.RAJESH.genericUtility.WebDriverUtility;


public class ChooseFileInContactimagePage {
	
	public ChooseFileInContactimagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	public void ChooseFileContactImage(WebDriver driver,String partialWindowTitle) {
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.switchToWindow(driver, partialWindowTitle);
		WebElement uploadFile= driver.findElement(By.name("imagename_hidden"));
		uploadFile.sendKeys("C:\\Users\\Rajesh Bhukya\\OneDrive\\Desktop\\Camera");
	}
}
