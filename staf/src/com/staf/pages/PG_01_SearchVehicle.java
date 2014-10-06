package com.staf.pages;

import java.util.HashMap;
import java.util.Map;

import com.staf.common.Reporter;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.*;
import com.staf.model.Page;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;

public class PG_01_SearchVehicle extends Page{
	
	private Map<String, String[]> data = new HashMap<String, String[]>(); 
	//private int index =  ConfigReader.getInstance().getDataCurrentRow();
	public Map<String, String[]> getData() {
		return data;
	}


	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	public PG_01_SearchVehicle() throws Exception  {
		super("PG_01_SearchVehicle");
		String [] dataFields = new String[]{"PickupLocation","PickupMonth","PickupDay","PickupTime",
											"DropOffMonth","DropOffDay","DropOffTime"};
		this.setData(ExcelReader.readTestData(dataFields));  
	}

	public void enterCarSearchDetails(){
		Editbox.type(this.getPageObjectsMap().get(ObjectConstants.PG_01_PickUPLocation), this.getData().get(DataConstants.PG_01_PickUPLocation)[ConfigReader.getInstance().getDataCurrentRow()]);
		Dropdown.selectIitem(this.getPageObjectsMap().get(ObjectConstants.PG_01_PickupMonth), this.getData().get(DataConstants.PG_01_PickupMonth)[ConfigReader.getInstance().getDataCurrentRow()]);
		Editbox.type(this.getPageObjectsMap().get(ObjectConstants.PG_01_PickupDay), this.getData().get(DataConstants.PG_01_PickupDay)[ConfigReader.getInstance().getDataCurrentRow()]);
		Dropdown.selectIitem(this.getPageObjectsMap().get(ObjectConstants.PG_01_PickupTime),this.getData().get(DataConstants.PG_01_PickupTime)[ConfigReader.getInstance().getDataCurrentRow()]);
		Dropdown.selectIitem(this.getPageObjectsMap().get(ObjectConstants.PG_01_DropOffMonth), this.getData().get(DataConstants.PG_01_DropOffMonth)[ConfigReader.getInstance().getDataCurrentRow()]);
		Editbox.type(this.getPageObjectsMap().get(ObjectConstants.PG_01_DropOffDay), this.getData().get(DataConstants.PG_01_DropOffDay)[ConfigReader.getInstance().getDataCurrentRow()]);
		Dropdown.selectIitem(this.getPageObjectsMap().get(ObjectConstants.PG_01_DropOffTime), this.getData().get(DataConstants.PG_01_DropOffTime)[ConfigReader.getInstance().getDataCurrentRow()]);
		Reporter.info("Serach details entered");
		System.out.println("Entered search criteria");
	}
	
	public void clickSearch(){
		Button.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Search));
	}
	
	public void clickModifyExistingReservation(){
		Link.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_ModifyExistingReservation));
	}

}
