package com.coverFox_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.coverFox_Base.Base;
import com.coverFox_POM.CoverFoxAddressDetailsPage;
import com.coverFox_POM.CoverFoxHealthPlanPage;
import com.coverFox_POM.CoverFoxHomePage;
import com.coverFox_POM.CoverFoxMemberDetailsPage;
import com.coverFox_POM.CoverFoxResultPage;
import com.coverFox_Utility.Utility;



public class CoverFoxTestUsingTestNGclass extends Base {
	
	public static Logger logger;

	CoverFoxHomePage coverfoxhomepage;
	CoverFoxMemberDetailsPage coverfoxmemberdetailspage;
	CoverFoxAddressDetailsPage coverfoxaddressdetailspage;
	CoverFoxHealthPlanPage coverfoxhealthplanpage;
	CoverFoxResultPage coverfoxresultpage;
	
	@BeforeClass
	public void launchBrowser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
	  logger= Logger.getLogger("23nov_coverfox");
	  PropertyConfigurator.configure("log4j.properties");
		  logger.info("Hello");
		
		openBrowser();
		coverfoxhomepage = new CoverFoxHomePage(driver);
		coverfoxmemberdetailspage = new CoverFoxMemberDetailsPage(driver);
		coverfoxaddressdetailspage = new CoverFoxAddressDetailsPage(driver);
		coverfoxhealthplanpage=new CoverFoxHealthPlanPage(driver);
		coverfoxresultpage =new CoverFoxResultPage(driver);
		
	}
	
	@BeforeMethod
	public void coverFoxPrecondition() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		
		coverfoxhomepage.clickOnGender();
		logger.info("clicking on gender");
		
		coverfoxhealthplanpage.clickOnNextButtonHealthPlanPage();
		logger.info("click on next button of health plan page");

		coverfoxmemberdetailspage.handleDropDown(Utility.readDataFromExcel("Sheet1", 0, 0));
		logger.info("handle drop down");

		coverfoxmemberdetailspage.clickOnnextButtonMemberDetailsPage();
		logger.info("click on next button on member details page");

		coverfoxaddressdetailspage.enterPinCode(Utility.readDataFromExcel("Sheet1", 0, 1));
		logger.info("enter pin-code");

		coverfoxaddressdetailspage.enterMobileNumber(Utility.readDataFromExcel("Sheet1", 0, 2));
		logger.info("enter mobile number");

		coverfoxaddressdetailspage.clickOnContinueButton();
		logger.info("click on continue button");

		
        Thread.sleep(4000);
		
		
		
		//coverfoxmemberdetailspage.handleDropDown(mySheet.getRow(0).getCell(0).getStringCellValue());
		//coverfoxmemberdetailspage.clickOnnextButtonMemberDetailsPage();
		//coverfoxaddressdetailspage.enterPinCode(mySheet.getRow(0).getCell(1).getStringCellValue());
		//coverfoxaddressdetailspage.enterMobileNumber(mySheet.getRow(0).getCell(2).getStringCellValue());
		
		
		//or
		
		//String age = String.valueOf((int) mySheet.getRow(0).getCell(0).getNumericCellValue());
      //  String pinCode = String.valueOf((int) mySheet.getRow(0).getCell(1).getNumericCellValue());
      //  String mobileNumber = String.valueOf((long) mySheet.getRow(0).getCell(2).getNumericCellValue());
       // coverfoxmemberdetailspage.handleDropDown(age);
        

       // coverfoxaddressdetailspage.enterPinCode(pinCode);
      //   coverfoxaddressdetailspage.enterMobileNumber(mobileNumber);
      //  coverfoxaddressdetailspage.clickOnContinueButton();
		
		
			
	}
	
  @Test
  public void validateCoverFoxPlans() throws IOException {
	  
	// Assert.fail();
   	int planNumberFromText = coverfoxresultpage.getplaneNumberFromText();
   	int planNumberFromCards = coverfoxresultpage.getPlanNumberFromPlanCards();
   	
    Assert.assertEquals(planNumberFromText, planNumberFromCards,"Test case failed, number are not matching");
   	Reporter.log("Plan number are matching TC is passed", true);
   	
	Utility.takeScreenshot(driver, "validateCoverFoxPlans");
   
   	
   	
  }
  
  
	@AfterClass
	public void closeBrowser()
	{
		logger.info("closing Browser");

              // 	Reporter.log("closing browser", true);
             	closeBrowserWindow();
	}
	
	
}
