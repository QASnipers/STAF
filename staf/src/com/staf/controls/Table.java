package com.staf.controls;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.staf.model.Actions;
import com.staf.model.UIObject;

public class Table extends Actions {
	static Logger log=Logger.getLogger(Actions.class.getClass());
	//returns row count of the given table
	public static int getRowCount(UIObject obj){
		int count = 0;
		WebElement element = action(obj);
		try{count = element.findElements(By.tagName("tr")).size();}catch(Exception ex){
			System.out.println("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
			log.error("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
		}
		return count;
	}
	
	//returns column count of the given table
	public static int getColumnCount(UIObject obj){
		int count = 0;
		WebElement element = action(obj);
		try{count = element.findElements(By.tagName("td")).size();}catch(Exception ex){
			System.out.println("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
			log.error("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
		}
		return count;
	}
	
	//Verify content for given row and column index
	public static boolean verifyCellContent(UIObject obj, int rowIndex, int columnIndex, String content){
		boolean contentPresent = false;
		WebElement element = action(obj);
		try{List<WebElement> rows = element.findElements(By.tagName("tr"));
		for(int r=0;r<rows.size();r++){
			if(r==rowIndex){
				List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
				for(int c =0;c<columns.size();c++){
					if(c==columnIndex){
						WebElement column = columns.get(c);
						if(content.equalsIgnoreCase(column.getText())){
							contentPresent = true;	
						}
					}
				}
				
			}
			
		}}catch(Exception ex){			
			System.out.println("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
			log.error("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
		}
		return contentPresent;
	}
	//return content for given row and column index
	public static String getCellContent(UIObject obj, int rowIndex, int columnIndex){
		WebElement element = action(obj);
		String content = "";
		try{List<WebElement> rows = element.findElements(By.tagName("tr"));
		for(int r=0;r<rows.size();r++){
			if(r==rowIndex){
				List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
				for(int c =0;c<columns.size();c++){
					if(c==columnIndex){
						WebElement column = columns.get(c);
						content = column.getText();
					}
				}
				
			}
			
		}}catch(Exception ex){
			System.out.println("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
			log.error("Error occure with "+obj.getObjectName()+" and the error: "+ex.getMessage());
			
		}
		return content;
	}

	//return cell element for a given row and column index
	public static WebElement getCellElement(UIObject obj, int rowIndex, int columnIndex){
		WebElement element = action(obj);
		WebElement cellElement = null;
		try{List<WebElement> rows = element.findElements(By.tagName("tr"));
		for(int r=0;r<rows.size();r++){
			if(r==rowIndex){
				List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));
				for(int c =0;c<columns.size();c++){
					if(c==columnIndex){
						cellElement = columns.get(c);
					}
				}
				
			}
			
		}}catch(Exception ex){
			System.out.println("Error message occured with the object " + obj.getObjectName() + " and the error: "+ex.getLocalizedMessage());
			log.error("Error message occured with the object " + obj.getObjectName() + " and the error: "+ex.getLocalizedMessage());
		}
		return cellElement;
	}
	
	
}	