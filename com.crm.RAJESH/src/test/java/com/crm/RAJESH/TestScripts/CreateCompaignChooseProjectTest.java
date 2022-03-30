package com.crm.RAJESH.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.RAJESH.genericUtility.BaseClass;
import com.crm.RAJESH.objectRepository.CampaiginsPage;
import com.crm.RAJESH.objectRepository.CampaignInformationPage;
import com.crm.RAJESH.objectRepository.CreateNewComapignPage;
import com.crm.RAJESH.objectRepository.CreateNewProductPage;
import com.crm.RAJESH.objectRepository.HomePage;
import com.crm.RAJESH.objectRepository.MoreOptionsPage;
import com.crm.RAJESH.objectRepository.ProductInformationPage;
import com.crm.RAJESH.objectRepository.ProductPage;
import com.crm.RAJESH.objectRepository.ProductwindowPage;



@Listeners(com.crm.RAJESH.genericUtility.ListenersImplementationClass.class)
public class CreateCompaignChooseProjectTest extends BaseClass {
	
	@Test(groups = {"smoke","IntegrationTest"})
	public void createCampaignChooseProduct() throws Throwable, IOException {
	    //fetching CompaignTestData from excelSheet
		String expectedCompaignName=eLib.getDataFromExcel("CreateCompaign", 1, 3);
		expectedCompaignName=expectedCompaignName+jLib.getrandomNum();
		System.out.println(expectedCompaignName);
		
		//fetching ProductNameTestData from excelSheet
		 String expectedProductName=eLib.getDataFromExcel("ProductName", 1, 3);
		 expectedProductName=expectedProductName+jLib.getrandomNum();
		 System.out.println(expectedProductName);

	        //click On productLinkText
	        HomePage homePage=new HomePage(driver);
	        homePage.products();
	        
	        //click On "+" AddImageIcon
	        ProductPage productPage=new ProductPage(driver);
	        productPage.clickAddImageIcon();
	        
	        //createNewProduct with mandatoryFields
			CreateNewProductPage newProductPage=new CreateNewProductPage(driver);
			newProductPage.createNewOrganization(expectedProductName);
		
			//verification for Product
			ProductInformationPage informationProduct=new ProductInformationPage(driver);
			String actualProduct=informationProduct.getInformationMsg();
			
			Assert.assertEquals(actualProduct.contains(expectedProductName), true);
	        
	    //mouseOver action to moreLinkText and Click On CamPaignLinkText
	    homePage.MoreOption(driver);
	    MoreOptionsPage moreOptions=new MoreOptionsPage(driver);
	    moreOptions.compaign();
	    
	    //click on "+" AddImaeIcon
	    CampaiginsPage compaignPage=new CampaiginsPage(driver);
	    compaignPage.clickOnCreateCompaignAddImaeIcon();
	
	    //create new campaign with MandatoryFields and Choose product
	    CreateNewComapignPage newCompaignName=new CreateNewComapignPage(driver);
	    newCompaignName.compaignName(expectedCompaignName, driver, actualProduct);
	   
	   //search for productName into productWindow
	    ProductwindowPage productWindow=new ProductwindowPage(driver);
	    productWindow.searchProduct(driver, expectedProductName);
	    newCompaignName.saveCompaign(driver, actualProduct);
	    
	    //verification for Campaign
	    CampaignInformationPage campaignInformation=new CampaignInformationPage(driver);
	    String ActualCampaignName = campaignInformation.campaignInformationText();
	    
		Assert.assertEquals(ActualCampaignName.contains(expectedCompaignName), true);

    	
	}
}
