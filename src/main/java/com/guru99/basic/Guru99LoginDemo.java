package com.guru99.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.driver.factory.DriverFactory;

public class Guru99LoginDemo {

	public static void main(String[] args) {
		WebDriver driver=DriverFactory.getBrowser("chrome");
		driver.get("http://www.demo.guru99.com/V4/index.php");
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			//Test case-1: invalid login case
			driver.findElement(By.name("uid")).sendKeys("abc");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("123");
			driver.findElement(By.name("btnLogin")).click();
			Alert alert=driver.switchTo().alert();
			if(alert.getText().equals("User or Password is not valid")) {
				alert.accept();
			}
			//Test case-2: valid login case
			driver.findElement(By.name("uid")).sendKeys("mgr123");
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("mgr!23");
			driver.findElement(By.name("btnLogin")).click();
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				//Test case-3: Customer page link
				System.out.println("Manager home page");
				driver.findElement(By.linkText("New Customer")).click();
				if(driver.getTitle().equals("Guru99 Bank New Customer Entry Page")) {
					//Test case-4: new customer form
					System.out.println("New Customer page");
					driver.findElement(By.name("name")).sendKeys("Chandan kumar");
					driver.findElements(By.name("rad1")).get(1).click();
					driver.findElement(By.id("dob")).sendKeys("04122000");//mmddyyyy
				}
			}
		}else {
			System.out.println("Not a valid url");
		}
		
		
	}

}
