package com.staf.common;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

public class Reporter {

	private static Logger log = Logger.getLogger(Reporter.class.getName());
	
	public void reporter(){
		DOMConfigurator.configure("log4j.xml");
	}
	
	public static void info(String msg){
		log.info(msg);
		System.out.println("reporter log");
	}

}
