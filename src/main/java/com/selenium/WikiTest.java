package com.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.driver.factory.DriverFactory;

public class WikiTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver=DriverFactory.getBrowser("chrome");
		
		driver.get("https://www.wikipedia.org/");
		WebElement text=driver.findElement(By.id("searchInput"));
		text.sendKeys("Automation");
		
		//Dropdown
		Select select=new Select(driver.findElement(By.id("searchLanguage")));
		//select.selectByIndex(7);
		//select.selectByValue("hi");
		select.selectByVisibleText("Dansk");
		
		driver.findElement(By.className("pure-button")).submit();
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("E:\\WebDrivers\\wiki.jpg"));

	}

}
