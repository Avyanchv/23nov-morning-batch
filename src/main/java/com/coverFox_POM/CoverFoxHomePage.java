package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	//1.variable---->WebElements
	@FindBy(xpath="//div[text()='Male']") private WebElement gender;
	
	//2.constructor
	public CoverFoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3.methods
	
	public void clickOnGender()
	{
		Reporter.log("click on gender", true);
		gender.click();
	}
	
	

}
