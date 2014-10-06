package com.staf.common;

import org.openqa.selenium.WebElement;

public class Utilities {
	
/*	Author: Murali Kunda
*/	
	public static void waitForElement(WebElement element, int seconds) {
		long end = System.currentTimeMillis() + (seconds * 1000);
		while (System.currentTimeMillis() < end) {
			if ( element.isDisplayed() ) {
				break;
			}
		} 
	}
	
	

}
