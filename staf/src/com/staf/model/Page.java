package com.staf.model;

import java.io.File;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.staf.reader.UIObjectReader;

public class Page {
	private Map<String, UIObject> pageObjectsMap;
	private String pageName;
	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReporter;
	public Map<String, UIObject> getPageObjectsMap() {
		return pageObjectsMap;
	}

	public void setPageObjectsMap(Map<String, UIObject> pageObjectsMap) {
		this.pageObjectsMap = pageObjectsMap;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Page(String pageName) {
		super();
		this.pageName = pageName;
		this.pageObjectsMap = UIObjectReader.parsePageUIObjects(pageName);
	}
	
/*	@BeforeSuite
	public void setup() {
		System.out.println("Came to before suite");
		htmlReporter = new ExtentHtmlReporter("C://MyFramework//automationreport.html");
		htmlReporter.loadXMLConfig(new File("C://Users//muralik//git//STAF//staf//STAF//staf//src//com//staf//properties//extent-config.xml"));
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	
	}
	
	@AfterSuite
	public void tearDown(){
		reports.flush();
	}
*/

}
