package com.staf.model;

import java.util.Map;

import com.staf.reader.UIObjectReader;

public class Page {
	private Map<String, UIObject> pageObjectsMap;
	private String pageName;
	public Map<String, UIObject> getPageObjectsMap() {
		return pageObjectsMap;
	}

	public void setPageObjectsMap(Map<String, UIObject> pageObjectsMap) {
		this.pageObjectsMap = pageObjectsMap;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Page(String pageName) {
		super();
		this.pageName = pageName;
		this.pageObjectsMap = UIObjectReader.parsePageUIObjects(pageName);
	}
	

}
