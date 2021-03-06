package com.staf.controls;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.staf.model.Actions;
import com.staf.model.UIObject;

public class Radio extends Actions {
	static Logger log=Logger.getLogger(Actions.class.getClass());
	//clicking on a radio button if it is not clicked from Radio Group
	public static void selectFromGroup(UIObject obj, String value) {
		try{List<WebElement> elements = Actions.getElements(obj);
		if(elements.isEmpty()==false){
			for(WebElement element : elements){
				if(element.getAttribute("value").equalsIgnoreCase(value)){
					if(element.getAttribute("checked")== null){
						element.click();
					}
				}
			}
		}}catch (Exception ex){
			System.out.println("An error occured with the object " + obj.getObjectName() + " and error: " + ex.getMessage());
			log.error("An error occured with the object " + obj.getObjectName() + " and error: " + ex.getMessage());
		}
	}
	
	//returns selected radio button value from group
	public static String getSelectedRadioFromGroup(UIObject obj){
		String value="";
		List<WebElement> elements = Actions.getElements(obj);
		if(elements.isEmpty()==false){
			for(WebElement element : elements){
				if(element.getAttribute("checked")!=null){
					return element.getAttribute("value");
				}
			}
		}
		return value;
	}
	
	//selects a Radio button
	public static void selectRadio(UIObject obj){
		WebElement element = action(obj);
		if(element!=null){
			element.click();
		}
	 }
}
