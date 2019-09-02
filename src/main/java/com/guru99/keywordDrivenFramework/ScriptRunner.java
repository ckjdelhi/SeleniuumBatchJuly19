package com.guru99.keywordDrivenFramework;

public class ScriptRunner {

	public static void main(String[] args) {
		ReusableFuction utils=new ReusableFuction();
		String [][] data=utils.readDataFromExcelSheet();
		
		for(int i=1;i<data.length;i++) {
			String action=data[i][3];
			String locator=data[i][4];
			String locatorValue=data[i][5];
			String inputData=data[i][6];
			System.out.println(action +"\t"+locator+"\t"+locatorValue+"\t"+inputData);
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

}
