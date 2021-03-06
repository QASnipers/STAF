package com.staf.controls;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.staf.common.Browser;
import com.staf.model.Actions;
import com.staf.model.UIObject;
import com.staf.reader.ReportReader;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.collections.CollectionUtils;

public class Dropdown extends Actions {
	static Logger log = Logger.getLogger(Browser.class.getClass());
	 
	//Selecting an item
	public static void selectIitem(UIObject obj, String tdata){
		WebElement element = action(obj);
		boolean optnChk = false;
		try{
			List<WebElement> options = element.findElements(By.tagName("option"));
		    if(CollectionUtils.hasElements(options)){
			    for(WebElement option : options){
			        if(option.getText().equals(tdata)) {
			            option.click();
			            //log.info("Selected item "+tdata+" in "+ obj.getObjectName());
			            ReportReader.logInfo("Selected item "+tdata+" in "+ obj.getObjectName());
			            optnChk = true;
			            break;
			        }
			    }
			    if(optnChk = false){
			    	ReportReader.report("fail","item " + tdata + " not found in "+obj.getObjectName());
			    	System.out.println("item " + tdata + " not found in "+obj.getObjectName());
			    	Assert.fail("item " + tdata + " not found in "+obj.getObjectName());
			    }
			    }else{
			    	ReportReader.report("fail", obj.getObjectName()+ " not found ");
			    	Assert.fail(obj.getObjectName()+ " not found ");
			    }
			}catch (Exception ex){
				ReportReader.report("fail"," No values found in the drop down " + obj.getObjectName());
				System.out.println(" No values found in the drop down " + obj.getObjectName());
				Assert.fail("No values found in the drop down " + obj.getObjectName());
			}
		

	}
	
	//Selecting an item
		public static void selectAutoCompleteItem(UIObject obj, String tdata){
			String xPathtxt = obj.getXpath();
			boolean optnChk = false;
			List <WebElement> listItems = Browser.driver.findElements(By.xpath(xPathtxt));
			if (listItems.size() ==  0 ){
				ReportReader.report("fail"," No values found in the drop down " + obj.getObjectName());
				System.out.println(" No values found in the drop down " + obj.getObjectName());
				Assert.fail("No values found in the drop down " + obj.getObjectName());
			}
		    for (WebElement element : listItems){
		    	if (element.getText().contains(tdata)){
		    		optnChk = true;
		    		element.click();
		    	}
		    }
		    if(optnChk ==false){
				ReportReader.report("fail",tdata+" not found in drop down " + obj.getObjectName());
				System.out.println(tdata+" not found in drop down " + obj.getObjectName());
				Assert.fail(tdata+" not found in drop down " + obj.getObjectName());
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
