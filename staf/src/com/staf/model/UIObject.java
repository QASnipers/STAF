package com.staf.model;

public class UIObject {
	
	private String objectName;
	private String id;
	private String type;
	private String name;
	private Object value;
	private String identifier;
	private String xpath;
	private String cssselector;
	private String text;
	private String classname;
	private String index;
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getCssselector() {
		return cssselector;
	}
	public void setCssselector(String cssselector) {
		this.cssselector = cssselector;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getXpath() {
		return xpath;
	}
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public UIObject(String objectName, String id, String type, String name, Object value,
			String identifier, String xpath, String cssselector, String text, String classname, 
			String index) {
		super();
		this.objectName = objectName;
		this.id = id;
		this.type = type;
		this.name = name;
		this.value = value;
		this.identifier = identifier;
		this.xpath = xpath;
		this.cssselector = cssselector;
		this.text = text;
		this.classname = classname;
		this.index = index;
	}
	@Override
	public String toString() {
		return "UIObject [objectName=" + objectName + ", id=" + id + ", type=" + type + ", name=" + name
				+ ", value=" + value + ", identifier=" + identifier + ", xpath=" + xpath + ", cssselector=" + cssselector 
				+ ", text=" + text + ", classname=" + classname + ",index=" + index + "]";
	}
	
	
	
}
