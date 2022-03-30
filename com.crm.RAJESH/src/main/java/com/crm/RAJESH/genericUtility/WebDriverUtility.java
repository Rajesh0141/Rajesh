package com.crm.RAJESH.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM[HTML-Document] 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait element to be clickAble in GUI & check for specific element for every 500 milliseconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver, WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used wait for element to be clickable in GUI, & check for every 500milliseconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable 
	 */
	
	public void waitForElementWithCustomOut(WebDriver driver,WebElement element ,int pollingTime) throws Throwable {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to any Window based on Window Title
	 * @param drivewr
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver , String partialWindowTitle) {
		Set<String> set=driver.getWindowHandles();
		
		Iterator<String> itr=set.iterator();
		while(itr.hasNext()) {
			String wID=itr.next();
			driver.switchTo().window(wID);
			String currentWindowTitle=driver.getTitle();
			
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}	
		}
	}
	/**
	 * 
	 * used to switch to alert window & click on ok button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to alert window & click on cancle button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to alert window & send keys on placeholder
	 * @param driver
	 * @param key
	 */
	public void switchToAlertWindowAndSendkeys(WebDriver driver , String key) {
		driver.switchTo().alert().sendKeys(key);
	}
	/**
	 * used to switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver , int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch to Frame Window based on id or name Attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switcToFrame(WebDriver driver , String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to select the value from the DropDown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * used to select the value from the DropDown Based on Visible Text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element , String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specific on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 */
	public void mouseOverRightClickOnElement(WebDriver driver , WebElement element) {
		
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * pass enter Key appertaining to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * used custom wait and click on element
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element ) throws InterruptedException {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			}catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * 
	 * @param driver 
	 * @param driver
	 * @param javaScript 
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript(javaScript);
	}
	/**
	 * used monitor testScript if any testScript failed it will takes screenshot and save it
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public String takesScreenshot(WebDriver driver, String screenshotName) throws IOException {
		JavaUtility jUtil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+jUtil.getsystemDateAndTime()+".PNG");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}

}
