package com.staf.controls;

import org.openqa.selenium.WebElement;

import com.staf.model.Actions;
import com.staf.model.UIObject;

public class Editbox extends Actions {
	
	public static void type(UIObject obj, String tdata) {
		WebElement element = action(obj);
		if(element!=null){
			element.clear();
			element.sendKeys(tdata);	
		}
	}
}
