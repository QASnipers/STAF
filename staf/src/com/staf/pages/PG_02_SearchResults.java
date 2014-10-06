package com.staf.pages;



import com.staf.common.constants.ObjectConstants;
import com.staf.controls.Link;
import com.staf.model.Page;


public class PG_02_SearchResults extends Page {

	public PG_02_SearchResults() {
		super("PG_02_SearchResults");
	}
	
	public void clickDateTimeChange(){
		Link.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_DateTimeChange));
	}
	
	public void clickRentersAgeChange(){
		Link.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_RentersChange));
	}
	
	public void clickSelect(){
		Link.click(this.getPageObjectsMap().get(ObjectConstants.PG_02_Select));
	}

}
