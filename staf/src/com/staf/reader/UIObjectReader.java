package com.staf.reader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import com.staf.model.UIObject;


public class UIObjectReader {
	
	public static Map<String, UIObject> parsePageUIObjects(String pageName) {
		String objectFile = ConfigReader.getInstance().getObjectsFile();
		Map<String, UIObject> pageUIObjectsMap = new HashMap<String, UIObject>();
		try {			
			File fXmlFile = new File(objectFile);		//TODO : read from class path	
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();			 
			Node pageNode = doc.getElementsByTagName(pageName) != null ? doc.getElementsByTagName(pageName).item(0) : null;
			NodeList nodesList = pageNode.getChildNodes();
			for (int i=0 ; i<nodesList.getLength(); i++) {
				Node currentNode = nodesList.item(i);				
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)currentNode;
					
					if (element != null) {
						pageUIObjectsMap.put(element.getNodeName(), new UIObject(element.getNodeName(), element.getAttribute("id"), 
								element.getAttribute("type"), element.getAttribute("name"), element.getAttribute("value"), element.getAttribute("identifier"), 
								element.getAttribute("xpath"), element.getAttribute("cssselector"), element.getAttribute("text"),
								element.getAttribute("classname"), element.getAttribute("index")));
					}
				}
			}				
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return pageUIObjectsMap;
	}

}
