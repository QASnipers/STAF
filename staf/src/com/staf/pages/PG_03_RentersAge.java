package com.staf.pages;

import com.staf.common.constants.ObjectConstants;
import com.staf.controls.Radio;
import com.staf.model.Page;


public class PG_03_RentersAge extends Page {
	private String age;
	
	public PG_03_RentersAge() {
		super("PG_03_RentersAge");
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public void selectAge(){
		Radio.selectFromGroup(this.getPageObjectsMap().get(ObjectConstants.PG_03_AgeRadioGroup),this.getAge());
	}
	
	

}
