package com.staf.common;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.staf.model.UIObject;
import com.staf.reader.ConfigReader;
import com.staf.reader.ReportReader;

public class Browser {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	static Logger log=Logger.getLogger(Browser.class.getClass());

	public static void launchBrowser(String type, String appurl){
		String oss = System.getProperty("os.name");
		String drv;
		
		
		if (oss.equalsIgnoreCase("Mac OS X")){
			drv = "/drivers/mac/";
		}else{
			drv = "\\drivers\\";
		}
		
		
		if (type.equalsIgnoreCase("FF")){
			if (oss.equalsIgnoreCase("Mac OS X")){
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + drv+"geckodriver_mac" );
			}else{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + drv+"geckodriver.exe" );
			}
			driver = new FirefoxDriver();
			log.info("starting the firefox browser");
		}else if(type.equalsIgnoreCase("CHROME")){
			if (oss.equalsIgnoreCase("Mac OS X")){
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +drv+ "chromedriver" );
			}else{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +drv+ "chromedriver.exe" );
			}	 
				driver = new ChromeDriver();
				log.info("starting the Chrome browser");
		}else if(type.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + drv+"IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
			log.info("starting the IE browser");
		}else if(type.equalsIgnoreCase("SAFARI")){
			
			driver = new SafariDriver();
			log.info("starting the Safari browser");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appurl);
	}
	//Maximize
	public static void maximize(){
			driver.manage().window().maximize();
			ReportReader.logInfo("Browser maximized");
	}
	
	public static void quit(){
		driver.quit();
		ReportReader.logInfo("Browser is closed and session is quit");
	}
	
	public static void back(){
		driver.navigate().back();
		ReportReader.logInfo("Browser is navigated to back");
	}
	
	public static void forward(){
		driver.navigate().forward();
		ReportReader.logInfo("Browser is navigated to forward");
	}
	
	public static void clearCookies(){
		driver.manage().deleteAllCookies();
		ReportReader.logInfo("Deleted all the cookies");
	}
	
	public static void waitForElement(UIObject obj, int seconds) throws Exception{

		wait=new WebDriverWait(driver, seconds);
		ReportReader.logInfo("waiting for element " + obj.getObjectName());
		try{
			
		if(obj.getIdentifier().equalsIgnoreCase("Byid")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getId())));
		}
		
		else if(obj.getIdentifier().equalsIgnoreCase("Byname")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(obj.getName())));
		}
		
		
		else if(obj.getIdentifier().equalsIgnoreCase("Byxpath")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getXpath())));
			
		}
		
		else if(obj.getIdentifier().equalsIgnoreCase("BycssSelector")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(obj.getCssselector())));
		}
		
		
		else if(obj.getIdentifier().equalsIgnoreCase("Byclassname")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(obj.getClassname())));
		}
		
		}catch(Exception e){
	
			String str=e.getMessage();
			ReportReader.logInfo(str);
			throw new Exception(str);
		}
		
		}
		

	public static void waitForPage(String pageTitle,int seconds){
		WebDriverWait wait  =  new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	public static boolean isObjectExist(UIObject obj){
		WebElement element = null;
		try{
			if(obj.getIdentifier().equalsIgnoreCase("Byid")){
				element = Browser.driver.findElement(By.id(obj.getId()));
			}else if(obj.getIdentifier().equalsIgnoreCase("Byname")){
				element = Browser.driver.findElement(By.name(obj.getName()));
			}else if(obj.getIdentifier().equalsIgnoreCase("Byxpath")){
				element = Browser.driver.findElement(By.xpath(obj.getXpath()));
			}else if(obj.getIdentifier().equalsIgnoreCase("BycssSelector")){
				element = Browser.driver.findElement(By.cssSelector(obj.getCssselector()));
			}else if(obj.getIdentifier().equalsIgnoreCase("Bypartiallinktext")){
				element = Browser.driver.findElement(By.partialLinkText(obj.getText()));
			}else if(obj.getIdentifier().equalsIgnoreCase("Bylinktext")){
				element = Browser.driver.findElement(By.linkText(obj.getText()));
			}else if(obj.getIdentifier().equalsIgnoreCase("Bytagname")){
				if(obj.getType().equalsIgnoreCase("radio") || obj.getType().equalsIgnoreCase("checkbox")){
						element = Browser.driver.findElement(By.xpath("//input[@type=" + obj.getType() + "']"));
				}else{
					element = Browser.driver.findElement(By.tagName(obj.getType()));
				}
			}}
			catch(Exception ex){
				return false;
			}
			
		return true;
	}
	
	public static boolean isPageVisible(String pageTitle){
		boolean visible = false;
			if (driver.getTitle().equals(pageTitle)){
				visible = true;
			}
		return visible;
	}
	
	public static boolean isTextVisible(String s){
		boolean visible = false;
		try{
			visible = driver.findElement(By.cssSelector("body")).getText().contains(s);
			
		} catch (NoSuchElementException e){
			visible = false;
		}
		return visible;
	}
	
	
	public static String captureScreen() throws IOException, InterruptedException{
		Thread.sleep(1000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\test-output\\"+ConfigReader.getInstance().getTestCaseName()+"\\" +ConfigReader.getInstance().getTestCaseName()+"_"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(src, new File(path));
		return path;
		
	}

}


