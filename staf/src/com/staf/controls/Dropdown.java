package com.staf.controls;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.staf.common.Browser;
import com.staf.model.Actions;
import com.staf.model.UIObject;

import org.openqa.selenium.support.ui.Select;

public class Dropdown extends Actions {
	static Logger log = Logger.getLogger(Browser.class.getClass());
	//Selecting an item
	public static void selectIitem(UIObject obj, String tdata){
		WebElement element = action(obj);
	    List<WebElement> options = element.findElements(By.tagName("option"));
	    for(WebElement option : options){
	        if(option.getText().equals(tdata)) {
	            option.click();
	            log.info("Selected item "+tdata+" in "+ element.getText());
	            break;
	        }
	    }
	}
	
	// returns item name already selected
	public static String getSelectedItem(UIObject obj){
		String selectedItem = "";
		WebElement element = action(obj);
		Select allOptions = new Select(element);
		selectedItem = allOptions.getFirstSelectedOption().getText();
		log.info("Selected item is "+selectedItem);
		return selectedItem;
	}
	
	//return all options in the Selection box
	public static List<WebElement> getAllOptions(UIObject obj){
		WebElement element = action(obj);
		Select allOptions = new Select(element);
		List<WebElement> allOption = new ArrayList<WebElement>();
		allOption = allOptions.getOptions();
		log.info(element.getText()+" items are " + allOptions);
		return allOption;
	}

}
