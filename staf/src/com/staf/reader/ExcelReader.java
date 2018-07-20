package com.staf.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;



public class ExcelReader {
	static Map<String, List<String>> columnNames;
	public static void loadData(String testDataFile, String sheetName){
		columnNames  = new HashMap<String, List<String>>();
		DataFormatter dataFormatter = new DataFormatter();
		String oss = System.getProperty("os.name");
		
		
		if (oss.equalsIgnoreCase("Mac OS X")){
			testDataFile.replace("//", "/");
		}
		int colIterator,colCount, rowCount,ro;
		try {
			
			FileInputStream fileInputStream = new FileInputStream(testDataFile);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			XSSFRow row = null;
			XSSFCell cell = null;
			row = worksheet.getRow(0);
			colCount = row.getLastCellNum();
			rowCount = worksheet.getLastRowNum();
			if(colCount == 0){
				ReportReader.report("fail", "Cannot continue. File is empty or First row is empty in data file "+testDataFile);
				Assert.fail();
			}
			if(rowCount<1){
				ReportReader.report("fail", "Cannot continue. File is empty or No data found in the data file "+testDataFile);
				Assert.fail();
			}
			for(colIterator = 0; colIterator<=colCount-1; colIterator++){
				List<String> rowValues = new ArrayList<>();
				for(ro =1; ro<=rowCount; ro++){
					cell = worksheet.getRow(ro).getCell(colIterator);
					String cellData = dataFormatter.formatCellValue(cell);
					//String cellData = (worksheet.getRow(ro).getCell(colIterator).getRawValue());
					rowValues.add(cellData);
				}
				String colName = row.getCell(colIterator).getStringCellValue();
				columnNames.put(colName, rowValues);
			}
			String anyColumn = columnNames.keySet().toArray()[0].toString();
			int rowsCount = columnNames.get(anyColumn).size();
			ConfigReader.getInstance().setDataRowsCount(rowsCount-1);
		} catch (FileNotFoundException e) {
			ReportReader.report("fail", "Test data file not found : "+testDataFile);
			Assert.fail();
		} catch (IOException e) {
			ReportReader.report("fail", "Unknown Error found while reading the test data file "+testDataFile+" "+e.getMessage());
			Assert.fail();
		}
	}
	
	
	public static Map<String, String[]> readTestData(String[] pageDataFields) throws Exception{
		
		String testDataFile = System.getProperty("user.dir") +"//TestData//"+ 							  
			    ConfigReader.getInstance().getTestCaseName()+".xlsx";
		String sheetName = ConfigReader.getInstance().getEnvironment();
		if (columnNames==null){
			loadData(testDataFile,sheetName);
		}
		
		Map<String, String[]> dataSet = new HashMap<String, String[]>();
		boolean valCheck;
		int rowCount = ConfigReader.getInstance().getDataRowsCount();
		
		for(int i=0; i<pageDataFields.length;i++){
				valCheck = false;
				if(columnNames.containsKey(pageDataFields[i]) == false){
					ReportReader.logInfo( "Column " + pageDataFields[i]+ " not found in test data file " );
					valCheck = true;
				}
				String[] colValues = new String[rowCount+1];
				for(int rows = 0; rows<=rowCount; rows++){
					if(valCheck == true){
						 colValues[rows]="";
					}else{
						colValues[rows]=columnNames.get(pageDataFields[i]).get(rows);
					}
				}
				dataSet.put(pageDataFields[i], colValues);
		}
		return dataSet;
	}
}
