
package com.crm.RAJESH.TestScripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.RAJESH.genericUtility.BaseClass;
import com.crm.RAJESH.objectRepository.CreateNewProductPage;
import com.crm.RAJESH.objectRepository.HomePage;
import com.crm.RAJESH.objectRepository.ProductInformationPage;
import com.crm.RAJESH.objectRepository.ProductPage;



@Listeners(com.crm.RAJESH.genericUtility.ListenersImplementationClass.class)
public class CreateProductTest extends BaseClass {
	@Test(groups = "smoke")
	public void createProduct() throws Throwable, IOException {
		
	    //fetching test data from excel
	    String expectedProduct=eLib.getDataFromExcel("ProductName", 1, 3);
		System.out.println(expectedProduct);
		

        //click on productLink
        HomePage homePage=new HomePage(driver);
        homePage.products();
        
        //click on new addIconImage 
        ProductPage productPage=new ProductPage(driver);
        productPage.clickAddImageIcon();
        
        //create product with mandatoryFields  
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		createNewProductPage.createNewOrganization(expectedProduct+jLib.getrandomNum());
	
		//verification for Products
		ProductInformationPage informationProduct=new ProductInformationPage(driver);
		String actualProduct=informationProduct.getInformationMsg();
		
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(actualProduct.contains(expectedProduct), true);
		sf.assertAll();
	}
}
