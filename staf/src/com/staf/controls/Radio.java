package com.staf.controls;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.staf.model.Actions;
import com.staf.model.UIObject;

public class Radio extends Actions {
	
	//clicking on a radio button if it is not clicked from Radio Group
	public static void selectFromGroup(UIObject obj, String value) {
		List<WebElement> elements = Actions.getElements(obj);
		if(elements.isEmpty()==false){
			for(WebElement element : elements){
				if(element.getAttribute("value").equalsIgnoreCase(value)){
					if(element.getAttribute("checked")== null){
						element.click();
					}
				}
			}
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
