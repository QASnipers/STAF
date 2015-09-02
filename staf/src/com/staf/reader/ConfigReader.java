package com.staf.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private String browserType;
	private String url;
	private String environment;
	private String testDataFilesPath;
	private String objectsFile;
	private String externalData;
	private int dataRowsCount;
	private int dataCurrentRow;
	private String testCaseName;
	
	public String getTestDataFilesPath() {
		return testDataFilesPath;
	}
	public void setTestDataFilesPath(String testDataFilesPath) {
		this.testDataFilesPath = testDataFilesPath;
	}
	public String getObjectsFile() {
		return objectsFile;
	}
	public void setObjectsFile(String objectsFile) {
		this.objectsFile = objectsFile;
	}
	public String getExternalData() {
		return externalData;
	}
	public void setExternalData(String externalData) {
		this.externalData = externalData;
	}
	public int getDataRowsCount() {
		return dataRowsCount;
	}
	public void setDataRowsCount(int dataRowsCount) {
		this.dataRowsCount = dataRowsCount;
	}
	public int getDataCurrentRow() {
		return dataCurrentRow;
	}
	public void setDataCurrentRow(int dataCurrentRow) {
		this.dataCurrentRow = dataCurrentRow;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	private static ConfigReader instance = null;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBrowserType() {
		return browserType;
	}
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	//TODO : read from class path
	public void readConfiguration() throws IOException {
		Properties properties = new Properties();
		//InputStream configInputStream =  getClass().getClassLoader().getResourceAsStream("config.properties");		
		//FileInputStream configInputStream=new FileInputStream(new File("C:\\Users\\muralidharg\\git\\STAF\\staf\\src\\com\\staf\\properties\\config.properties"));
		FileInputStream configInputStream=new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\com\\staf\\properties\\config.properties"));
		properties.load(configInputStream);
		configInputStream.close();
		this.setBrowserType(properties.getProperty("BROWSER_TYPE"));
		this.setEnvironment(properties.getProperty("ENVIRONMENT"));
		if(properties.getProperty("ENVIRONMENT").equalsIgnoreCase("PRODUCTION")){
			this.setUrl(properties.getProperty("PRODUCTION_URL"));
		}else{
			this.setUrl(properties.getProperty("QA_URL"));
		}
		this.setTestDataFilesPath(properties.getProperty("TEST_DATA_FILE"));
		this.setObjectsFile(properties.getProperty("OBJECTS_FILE"));
		this.setExternalData(properties.getProperty("EXTERNAL_DATA"));
		this.setDataRowsCount(Integer.parseInt(properties.getProperty("DATA_ROWS_COUNT")));
		this.setDataCurrentRow(Integer.parseInt(properties.getProperty("DATA_CURRENT_ROW")));
		this.setTestCaseName(properties.getProperty("TEST_CASE_NAME"));
	}
	
	public static ConfigReader getInstance() {
		if(instance == null) {
			instance = new ConfigReader();
		}
		return instance;
	}
	private ConfigReader() {
	}
	
}
