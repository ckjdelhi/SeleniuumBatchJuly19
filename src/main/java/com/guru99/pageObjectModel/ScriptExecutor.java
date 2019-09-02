package com.guru99.pageObjectModel;

import org.openqa.selenium.WebDriver;

import com.driver.factory.DriverFactory;

public class ScriptExecutor {

	public static void main(String[] args) {
		WebDriver driver=DriverFactory.getBrowser("chrome");
		driver.get("http://www.demo.guru99.com/V4/index.php");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserId("mgr123");
		loginPage.setPasswrod("mgr!23");
		loginPage.clickOnLoginButton();
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnNewCustomerLink();
		
		NewCustomerPage newCustomerPage=new NewCustomerPage(driver);
		newCustomerPage.setCustomerName("Chandan kumar");
		newCustomerPage.setGender("m");
		
		homePage.clickOnNewAccountLink();
		NewAccountPage newAccountPage=new NewAccountPage(driver);
		newAccountPage.setCustomerId("1234");
		
		

	}

}
