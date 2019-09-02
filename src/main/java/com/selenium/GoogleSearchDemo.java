package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.driver.factory.DriverFactory;

public class GoogleSearchDemo {

	public static void main(String[] args) {
		WebDriver driver=DriverFactory.getBrowser("safari");
		driver.get("https://www.google.com/");
		WebElement  text=driver.findElement(By.name("q"));
		text.sendKeys("Selenium hq");
		
		WebElement button=driver.findElement(By.className("gNO89b"));
		button.submit();
		
		WebElement link=driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3/div"));
		link.click();
	}

}
