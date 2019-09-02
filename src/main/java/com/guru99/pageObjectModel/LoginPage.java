package com.guru99.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "uid")
	private WebElement txtUserId;
	
	@FindBy(xpath = "/html/body/form/table/tbody/tr[2]/td[2]/input")
	private WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	private WebElement buttonLogin;
	
	@FindBy(name = "btnReset")
	private WebElement buttonReset;

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserId(String userId) {
		this.txtUserId.sendKeys(userId);
	}
	public void setPasswrod(String password) {
		this.txtPassword.sendKeys(password);
	}
	public void clickOnLoginButton() {
		this.buttonLogin.click();
	}
	public void clickOnResetButton() {
		this.buttonReset.click();
	}
	

}
