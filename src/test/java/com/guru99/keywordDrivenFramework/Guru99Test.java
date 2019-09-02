package com.guru99.keywordDrivenFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Guru99Test {
	ReusableFuction utils=null;
	
	@BeforeTest
	public void setUp() {
		utils=new ReusableFuction();
	}
	@DataProvider(name = "GURU99DATA")
	public Object[][] getDataFromExcel(){
		return utils.readDataFromExcelSheet();
	}
	@Test(dataProvider = "GURU99DATA")
	public void testCasesForGuru99(String s1,String s2,String s3,String s4,String s5,String s6,String s7) {
		if(s4!=null) {
			String action=s4;
			String locator=s5;
			String locatorValue=s6;
			String inputData=s7;
			switch(action) {
				case "launchApp":
					utils.launchApp();
					break;
				case "fillText":
					utils.fillText(locator,locatorValue,inputData);
					break;
				case "click":
					utils.click(locator,locatorValue);
					break;
			}
		}
	}
	@AfterTest
	public void closeBrowser() {
		utils.closeBrowser();
	}
}
