package com.guru99.pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	@FindBy(name = "name")
	private WebElement txtCustomerName;
	
	@FindBys(@FindBy(name="rad1"))
	private List<WebElement> radioBtnGender;
	
	public NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setCustomerName(String name) {
		this.txtCustomerName.sendKeys(name);
	}
	
	public void setGender(String gender) {
		//Way-1
		/*if(gender.equals("male")) {
			this.radioBtnGender.get(0).click();
		}else {
			this.radioBtnGender.get(1).click();
		}*/
		for(WebElement gen:radioBtnGender) {
			if(gender.equals(gen.getAttribute("value"))) {
				gen.click();
			}
		}
		
	}
	
}
