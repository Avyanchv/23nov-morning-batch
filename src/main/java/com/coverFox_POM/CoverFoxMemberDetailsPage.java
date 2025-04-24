package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {
	//variable
	
	//@FindBy(name="You") private WebElement ageDropDown;
	@FindBy(tagName="select") private WebElement ageDropDown;
	
	@FindBy(className="next-btn")private WebElement nextButton;
	
	//constructor
	public CoverFoxMemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//method
	public void handleDropDown(String age)
	{
		Reporter.log("handeling age drop down", true);
		Select selectAge=new Select(ageDropDown);
		selectAge.selectByVisibleText(age);
		//selectAge.selectByValue(age+"y");
	}
	public void clickOnnextButtonMemberDetailsPage()
	{
		Reporter.log("Clicking on next button of MemberDEtailPage", true);
		nextButton.click();
	}

}
