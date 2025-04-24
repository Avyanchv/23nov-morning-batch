package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
	//variable
	@FindBy(className="mp-input-text") private WebElement pinCodeFiled;
	@FindBy(id="want-expert") private WebElement mobileNumberField;
	@FindBy(xpath="//div[text()='Continue']") private WebElement continueButton;
	
	public CoverFoxAddressDetailsPage(WebDriver diver)
	{
		PageFactory.initElements(diver, this);
	}
	
	public void enterPinCode(String pinCode)
	{
		Reporter.log("entering pin code", true);
		pinCodeFiled.sendKeys(pinCode);
	}
	public void enterMobileNumber(String mobileNumber)
	{
		Reporter.log("entering mobile number", true);

		mobileNumberField.sendKeys(mobileNumber);
	}
	public void clickOnContinueButton()
	{
		Reporter.log("click on continue button on address details page", true);

		continueButton.click();
	}

}
