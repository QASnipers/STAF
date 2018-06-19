package com.staf.common;

import java.io.File;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.staf.pages.*;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;

public class Application {
	public Browser browser = new Browser();
	public Navigate Navigate  = new Navigate() ;
	public Login Login = new Login();
	
	public Application() throws Exception {		
		//ConfigReader.getInstance().readConfiguration();
		//String testDataFile = ConfigReader.getInstance().getTestDataFilesPath() +
		String testDataFile = System.getProperty("user.dir") +"//TestData//"+ 							  
							    ConfigReader.getInstance().getTestCaseName()+".xls";
		String sheetName = ConfigReader.getInstance().getEnvironment();
		
		int rowCount = ExcelReader.getDataRowCount(testDataFile, sheetName);
		  if(rowCount <= 0){

			  System.out.println("No column names or data found in the data file. File Name: "+ testDataFile 
					  			 + " Sheet Name: "+sheetName);
		  }else if(rowCount == 1){
			  rowCount = 0;
		  }
		  else {
			  ConfigReader.getInstance().setDataRowsCount(rowCount-2);
		  }
	}
	
	
	

}
