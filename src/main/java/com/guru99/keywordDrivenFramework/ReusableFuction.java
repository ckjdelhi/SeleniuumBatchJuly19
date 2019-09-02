package com.guru99.keywordDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.driver.factory.DriverFactory;

public class ReusableFuction {
	WebDriver driver=null;
	public ReusableFuction() {
		driver=DriverFactory.getBrowser("chrome");
	}
	
	public void launchApp() {
		driver.get(fetchProp("URL"));
	}
	public void fillText(String locator, String locatorValue, String inputData) {
		locatorValue=fetchProp(locatorValue);
		switch(locator){
			case "id":
				driver.findElement(By.id(locatorValue)).sendKeys(inputData);
				break;
			case "name":
				driver.findElement(By.name(locatorValue)).sendKeys(inputData);
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).sendKeys(inputData);
				break;
		}
	}
	public void click(String locator, String locatorValue) {
		locatorValue=fetchProp(locatorValue);
		switch(locator){
			case "id":
				driver.findElement(By.id(locatorValue)).click();
				break;
			case "name":
				driver.findElement(By.name(locatorValue)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).click();
				break;
			case "linkText":
				driver.findElement(By.linkText(locatorValue)).click();
				break;
		}
	}
	public void closeBrowser() {
		driver.quit();
	}
	public String[][] readDataFromExcelSheet() {
		String filePath= System.getProperty("user.dir")+"//"+fetchProp("execesheet_name");
		File file=new File(filePath);
		Workbook wb=null;
		String[][] data=null;
		try {
			FileInputStream fs=new FileInputStream(file);
			String fileExtension=filePath.substring(filePath.indexOf(".")+1);
			if(fileExtension.equals("xlsx")) {
				wb=new XSSFWorkbook(fs);//xlsx
			}else {
				wb=new HSSFWorkbook(fs);//xls
			}
			Sheet sheet=wb.getSheet("Sheet1");
			int rowNum=sheet.getLastRowNum()+1;
			int column=sheet.getRow(0).getLastCellNum();
			System.out.println("Total Row: "+rowNum+"\tColumn: "+column);
			data=new String[rowNum][column];
			
			for(int i=1;i<rowNum;i++) {//row
				Row row=sheet.getRow(i);
				for(int j=0;j<column;j++) {//column
					Cell cell=row.getCell(j);
					String value=cell.toString();
					data[i][j]=value;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	private static String fetchProp(String key) {
		Properties pro=new Properties();
		FileInputStream input=null;
		try {
			input=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Object.properties");
			pro.load(input);
		}catch(Exception ex) {}
		return pro.getProperty(key);
	}

	

	
	
}
