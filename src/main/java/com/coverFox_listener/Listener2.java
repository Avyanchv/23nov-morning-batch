package com.coverFox_listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.coverFox_Base.Base;
import com.coverFox_Utility.Utility;

public class Listener2 extends Base implements ITestListener {
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		Reporter.log("Congrats test "+testName+" is success", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("sorry, test "+result.getName()+" failed", true);
		
		try {
			Utility.takeScreenshot(driver, result.getName()+"_failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
	
	
	
	

}
