package com.staf.reader;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.staf.common.Browser;

public class ReportReader {
	
	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest logger;
	static Logger log = Logger.getLogger(Browser.class.getClass());
    @BeforeSuite
    public static void runBeforeSuite() throws IOException
    {
    	ConfigReader.getInstance().readConfiguration();
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"//test-output//MyOwnReport.html");
        
        //htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"//src//com//staf//properties//extent-config.xml");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("User Name", "MuraliKunda");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Demo Report");
        htmlReporter.config().setReportName("Demo Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
    
    
    public static void registerTest(String tstName)
    {
    	logger = reports.createTest(tstName);
    }
    
    public static void report(String status,String comments){
    	if(status.equalsIgnoreCase("pass") ){
    		logger.log(Status.PASS, comments);
    		logInfo(comments);
    	}else if(status.equalsIgnoreCase("fail")){
    		logger.log(Status.FAIL, comments);
    		logError(comments);
    	}else if(status.equalsIgnoreCase("info")){
    		logger.log(Status.INFO, comments);
    		logInfo(comments);
    	}
    }
    
    public static void report(String status, String comments, boolean screenshot) {
    	String scrnshtPath="";
    	
    	if(screenshot==true){
    		try {
    			scrnshtPath =Browser.captureScreen();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	try{
    		MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(scrnshtPath).build();
    	if(status.equalsIgnoreCase("pass") ){
    		logger.pass(comments,mediaModel);
    		logInfo(comments);
    	}else if(status.equalsIgnoreCase("fail")){
    		logger.fail(comments,mediaModel);
    		logError(comments);
    	}else if(status.equalsIgnoreCase("info")){
    		logger.info(comments,mediaModel);
    		logInfo(comments);
    	}}catch (Exception ex){
    		logger.log(Status.FAIL, comments+" - Screenshot file path not found Unable to take screenshot");
    		logError(comments+" - Screenshot file path not found Unable to take screenshot");
    	}
    
    }
    
    public static void logInfo(String logOnlyMessage ){
    	log.info(logOnlyMessage);
    }
    
    public static void logError(String logOnlyMessage ){
    	log.error(logOnlyMessage);
    }
    
	@AfterTest
	public void runAfterTest(){
		//Browser.quit();
	}
	
    @AfterSuite
    public static void tearDown()
    {
        reports.flush();
    }
    


}
