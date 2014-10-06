package com.staf.common;

import com.staf.pages.*;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;

public class Application {
	public Browser browser = new Browser();
	public PG_01_SearchVehicle PG_01_searchvehicle = new PG_01_SearchVehicle();
	public PG_02_SearchResults PG_02_searchresults = new PG_02_SearchResults();
	public PG_03_RentersAge PG_03_rentersage  = new PG_03_RentersAge() ;
	
	public Application() throws Exception {		
		//ConfigReader.getInstance().readConfiguration();
		String testDataFile = ConfigReader.getInstance().getTestDataFilesPath() +
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
