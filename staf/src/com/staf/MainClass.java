package com.staf;

import com.staf.common.*;
import com.staf.reader.ConfigReader;

public class MainClass  {

	public static void main(String[] args) throws Exception{
		
		ConfigReader.getInstance().readConfiguration();
		ConfigReader.getInstance().setTestCaseName("MainClass");
		
		Application app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
		
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);
			app.PG_01_searchvehicle.enterCarSearchDetails();
			//app.PG_01_searchvehicle.clickSearch();
			//Browser.back();
		}
		Browser.quit();
	}
}


