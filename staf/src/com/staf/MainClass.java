package com.staf;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.staf.common.*;
import com.staf.reader.ConfigReader;

public class MainClass  {

	Application app;
	@Test
	public void test1() throws Exception{
		String tstName;
		ConfigReader.getInstance().readConfiguration();
		tstName = Thread.currentThread().getStackTrace()[1].getMethodName();
		ConfigReader.getInstance().setTestCaseName(tstName);
		Application app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
	
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);
			
			app.PG_01_searchvehicle.enterCarSearchDetails();
			app.PG_01_searchvehicle.clickSearch();
			//Browser.back();
			
		}
	}
	@Test
	public void test2(){
		
	}
	
	@AfterTest
	public void runAfterTest(){
		//Browser.quit();

	}
	
}


