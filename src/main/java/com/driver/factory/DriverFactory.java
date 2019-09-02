package com.driver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static WebDriver getBrowser(String browserType) {
		WebDriver driver=null;
		if(browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\WebDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\WebDrivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.edge.driver", "E:\\WebDrivers\\MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		if (driver !=null) {
			driver.manage().window().maximize();
		}
		return driver;
	}
}
