package com.crm.RAJESH.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.RAJESH.objectRepository.HomePage;
import com.crm.RAJESH.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public static WebDriver sDriver;
	   
	@BeforeSuite(groups={"smoke","IntegrationTest"})
	public void beforeSiute() {
		System.out.println("Data base connection");
	}
	
	@BeforeTest(groups={"smoke","IntegrationTest"})
	public void beforeTest() {
		System.out.println("executescript in parallel execution");
	}
	//@Parameters("browser")//String browserName
	
	@BeforeClass(groups={"smoke","IntegrationTest"})
	public void launchBrowser() throws IOException {
 		String browser=fLib.getPropertiesData("browser");
		String url=fLib.getPropertiesData("url"); 
		//polyMorphism
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Launched Browser is : "+ browser);
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("Launched Browser is : "+ browser);
		}else {
			System.err.println("Browser launched failed");
		}
		//launching browesr
		driver.get(url);
		
		//wait statement for pageTo beLoaded GUI
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();	
		sDriver=driver;
	}
	@BeforeMethod(groups={"smoke","IntegrationTest"})
	public void loginIntoApplication() throws Throwable {
		           
		String un=fLib.getPropertiesData("username");          
		String pwd=fLib.getPropertiesData("password");  
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(un, pwd);
	}
	@AfterMethod(groups={"smoke","IntegrationTest"})
	public void logoutFromApplication() {
		//logout from the application
		HomePage homePage=new HomePage(driver);
	    homePage.signOut(driver);
	}
	
	@AfterClass(groups={"smoke","IntegrationTest"})
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterTest(groups={"smoke","IntegrationTest"})
	public void afterTest() {
		System.out.println("executescript in parallel execution");
	}
	
	@AfterSuite(groups={"smoke","IntegrationTest"})
	public void AfterSiute() {
		System.out.println("Data base connection");
	}
}

