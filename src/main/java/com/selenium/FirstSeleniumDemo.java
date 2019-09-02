package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.driver.factory.DriverFactory;

public class FirstSeleniumDemo {

	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "E:\\WebDrivers\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", "E:\\WebDrivers\\chromedriver.exe");
		//WebDriver driver =new ChromeDriver();
		
		//System.setProperty("webdriver.edge.driver", "E:\\WebDrivers\\MicrosoftWebDriver.exe");
		//WebDriver driver=new EdgeDriver();
		
		String browserType="ie";
		WebDriver driver=DriverFactory.getBrowser(browserType);
		
		driver.get("file:///C:/Users/Chandan/Desktop/firstwebpage.html");
		WebElement textBoxName=driver.findElement(By.id("name"));
		textBoxName.sendKeys("chandan kumar");
		
		List<WebElement> el=driver.findElements(By.tagName("input"));
		System.out.println("How many input tags available : "+el.size());
	}

}
