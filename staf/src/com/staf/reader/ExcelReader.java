package com.staf.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Reporter;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {
	
	// get Rows count from the sheet. Returns only when data found.
	public static int getDataRowCount(String testDataFile, String sheetName) throws Exception{
		int rowCount = 0;
		Sheet sheet = null;
		try{
		      Workbook workbook = Workbook.getWorkbook(new File(testDataFile));
		      sheet = workbook.getSheet(sheetName);
				if(sheet != null){
					rowCount = sheet.getRows();
				}else{
					rowCount = -1;	
				}
				workbook.close();
		}catch(FileNotFoundException e){
			System.out.println("Specified Test data file " + testDataFile + " not found");
			throw new FileNotFoundException();
		}catch(Exception e){
			System.out.println("Unknown error. Please check Test Data file");
			throw new Exception();
		}		
		return rowCount;
	}
	
	// get Columns count from the sheet. Returns only when data found.
	public static int getDatColumnsCount(String testDataFile, String sheetName) throws Exception{
		int colCount = 0;
		Sheet sheet = null;
		try{
		      Workbook workbook = Workbook.getWorkbook(new File(testDataFile));
		      sheet = workbook.getSheet(sheetName);
				if(sheet != null){
					colCount = sheet.getColumns();
				}else{
					colCount = -1;	
				}
				workbook.close();
		}catch(FileNotFoundException e){
			ReportReader.report("fail","Specified Test data file " + testDataFile + " not found");
			throw new FileNotFoundException();
		}catch(Exception e){
			ReportReader.report("fail","Unknown error. Please check Test Data file");
			throw new Exception();
		}		
		return colCount;
	}
	
	//Read Data from Test Data file as per the page properties.
	public static Map<String, String[]> readTestData(String[] dataFields) throws Exception{
		  int rowCount = 0;
		  int colCount = 0;
		  int i =0;
		  String testDataFile = ConfigReader.getInstance().getTestDataFilesPath()+ConfigReader.getInstance().getTestCaseName()+".xls";
		  String environment = ConfigReader.getInstance().getEnvironment();	
		  //This object is returned
		  Map<String, String[]> dataSet = new HashMap<String, String[]>();
		  
		  //List of fields returned back
		  List<String> headers = new ArrayList<String>();
		  
		  try{
			  //get all fields from page and store it in a List. If no fields specified then do nothing
			  //and return empty Map
			  if(dataFields.length>=1){
				  List <String> dataField = new ArrayList<String>();
					 //Assigning it to a List. To make it easy to move on.
					  for(int loop =0;loop<dataFields.length;loop++){
						  dataField.add(dataFields[loop]);
					  }
					  //read data from Excel file when External data is YES. so mark ExternalData in Properties as YES;
					  //if NO or any other value then return empty fields. So I can specify my data at test level. 
					  if(ConfigReader.getInstance().getExternalData().equalsIgnoreCase("yes")){
						  rowCount = getDataRowCount(testDataFile, environment);
					      colCount = getDatColumnsCount(testDataFile,environment);

						  //check whether any data is in the excel
						  if(rowCount <= 0){
							  System.out.println("No column names or data found in the data file. File Name: "+ testDataFile 
									  			 + " Sheet Name: "+environment);
						  }else if(rowCount == 1){ // No data found except columns
							  dataSet = loadDataSetMap(headers, dataFields);
							  return dataSet;
						  }else{
						      Workbook workbook = Workbook.getWorkbook(new File(testDataFile));
						      Sheet sheet = workbook.getSheet(environment);
							  for(i=0; i<colCount; i++){
						    	  Cell col = sheet.getCell(i, 0);
						    	  if(dataField.contains(col.getContents())){
						    		  headers.add(col.getContents());
							    	   String[] colValues = new String[rowCount-1];
							    	   for(int j=1;j<rowCount;j++){
							    		   Cell data = sheet.getCell(i, j);
							    		   colValues[j-1]= data.getContents(); 
							    	   }
							    	   dataSet.put(headers.get(i), colValues);
							    	   
						    	  }else{// To do stop execution
									  System.out.println("No matching names found in the data file. File Name: "+ testDataFile 
									  			 + " Sheet Name: "+environment);
						    	  }
						      }							  
							  workbook.close();
						  }
						  
					  }else{  // returns only page fields when NO specified in external data 
						  dataSet = loadDataSetMap(headers, dataFields);
				    	  return dataSet;
					  }
			  }
			  
		  }catch(Exception e){
			  System.out.println("Unknown exception found");
			  throw new Exception();
		  }
		  return dataSet;
	}	  
	
	//Loading dataSet with empty data 
	private static Map<String, String[]> loadDataSetMap(List<String> headers, String[] dataFields){
		 Map<String, String[]> dataSet = new HashMap<String, String[]>();
		 String[] colValues = new String[]{" "};
			for(int i=0;i<dataFields.length;i++){
				  headers.add(dataFields[i]);
			  }
			  for(int i=0;i<colValues.length;i++){
				  dataSet.put(headers.get(i), colValues);
			  }
		return dataSet;
	}
}
