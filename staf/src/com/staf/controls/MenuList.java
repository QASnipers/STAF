package com.staf.controls;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.staf.common.Browser;
import com.staf.model.Actions;
import com.staf.model.UIObject;
import com.staf.reader.ReportReader;

public class MenuList extends Actions {
	
	public static void SelectItem(UIObject obj,String testdata) {
		WebElement element = action(obj);
		WebElement localSearchBox;
		WebElement loclalSelectedOption;
		try{
			element.click();
			Thread.sleep(1000);
			localSearchBox = Browser.driver.findElement(By.xpath("//*[@data-automation-id='searchBox']"));
			localSearchBox.sendKeys(testdata);
			localSearchBox.sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			loclalSelectedOption =Browser.driver.findElement(By.xpath("//*[@data-automation-label='"+testdata+"']"));
			loclalSelectedOption.click();
		}catch( Exception ex){
			ReportReader.report("fail", obj.getObjectName()+"Object not found " +ex.getMessage());
			Assert.fail();
		}	
	}
	
}