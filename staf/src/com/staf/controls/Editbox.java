package com.staf.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.staf.common.Browser;
import com.staf.model.Actions;
import com.staf.model.UIObject;
import com.staf.reader.ReportReader;

public class Editbox extends Actions {

	public static void type(UIObject obj, String tdata) {
		WebElement element = action(obj);
		if(element!=null){
			element.clear();
			element.sendKeys(tdata);
			//ReportReader.report("info", "Entered " +tdata+" in "+obj.getObjectName());
			ReportReader.logInfo("Entered " +tdata+" in "+obj.getObjectName());
		}
	}
	public static void type(UIObject obj, String tdata, int delayInSeconds) {
		WebElement element = action(obj);
		if(element!=null){
			element.clear();
			   for (int i = 0; i < tdata.length(); i++){
			        char c = tdata.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        element.sendKeys(s);
			        ReportReader.logInfo("Entered " +tdata+" in "+obj.getObjectName());
			        try {
						Thread.sleep(delayInSeconds*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    } 

		}
	
	}
	
	public static void type(UIObject obj,  Keys key) {
		WebElement element = action(obj);
		if(element!=null){
			element.sendKeys(key);

		}
	
	}
}
