package com.staf.common;


import com.staf.pages.*;

public class Application {
	//Register new pages here
	public Browser browser = new Browser();
	public Login Login = new Login();
	public NavigateTo NavigateTo  = new NavigateTo() ;
	public OrgandHiringType OrgandHiringType = new OrgandHiringType();

	
	
	public Application() throws Exception {		
		
	}
}
