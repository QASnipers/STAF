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
}
