package com.staf.controls;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.staf.common.Browser;
import com.staf.model.Actions;
import com.staf.model.UIObject;

public class Editbox extends Actions {
	static Logger log = Logger.getLogger(Browser.class.getClass());
	public static void type(UIObject obj, String tdata) {
		WebElement element = action(obj);
		if(element!=null){
			element.clear();
			element.sendKeys(tdata);
			log.info("Entered " +tdata+" in "+element.getText());
			
		}
	}
	public static void type(UIObject obj, String tdata, int delayInMilliSec) {
		WebElement element = action(obj);
		if(element!=null){
			element.clear();
			   for (int i = 0; i < tdata.length(); i++){
			        char c = tdata.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        element.sendKeys(s);
			        try {
						Thread.sleep(delayInMilliSec);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    } 
			log.info("Entered " +tdata+" in "+element.getText());
			
		}
	
	}
}
