package com.staf;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.staf.common.*;
import com.staf.reader.ConfigReader;
import com.staf.reader.ReportReader;

public class MainClass extends ReportReader  {

	Application app ;
	@Test
	public void test1() throws Exception{
		String tstName;
		tstName = Thread.currentThread().getStackTrace()[1].getMethodName();
		ConfigReader.getInstance().setTestCaseName(tstName);
		ReportReader.registerTest(tstName);
		app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
	
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);
			ReportReader.report("info",tstName+" Started");
			app.PG_01_searchvehicle.enterCarSearchDetails();
			app.PG_01_searchvehicle.clickSearch();
			
			//Browser.back();
			
		}
	}
	@Test
	public void test2(){
		String tstName;
		tstName = Thread.currentThread().getStackTrace()[1].getMethodName();
		ConfigReader.getInstance().setTestCaseName(tstName);
		ReportReader.registerTest(tstName);
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
		ReportReader.report("info",tstName+" Started");
		app.PG_01_searchvehicle.clickSearch();
	}
	

	
}


