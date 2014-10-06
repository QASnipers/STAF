package com.staf.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
	
	public static void launchBrowser(String type, String appurl){
		if (type.equalsIgnoreCase("FF")){
			driver = new FirefoxDriver();
		}else if(type.equalsIgnoreCase("CHROME")){
			//download chrome driver and keep it under drivers of the current project
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe" );
			driver = new ChromeDriver();
		}else if(type.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
		}
		driver.get(appurl);
		
	}

	public static void maximize(){
			driver.manage().window().maximize();
	}
	
	public static void quit(){
		driver.quit();
	}
	
	public static void back(){
		driver.navigate().back();
	}
	
	public static void forward(){
		driver.navigate().forward();
	}
	
	public static void clearCookies(){
		driver.manage().deleteAllCookies();
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

}
