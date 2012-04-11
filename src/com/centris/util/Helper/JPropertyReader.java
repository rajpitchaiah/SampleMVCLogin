package com.centris.util.Helper;

import java.util.ResourceBundle;

import com.centris.util.constants.MessageConstants;
public class JPropertyReader {
	public static String readProperty(String key) {
		String PROPERTY_FILE=MessageConstants.prop_dir;
		ResourceBundle rb = ResourceBundle.getBundle("application");
		String propvalue=rb.getString(key);
		return propvalue;
	}
	public static String  readlog4JProperty(String strKey) 
	{	String PROPERTY_NAME="application";
		ResourceBundle rb=ResourceBundle.getBundle(PROPERTY_NAME);
		String strPropertyValue=rb.getString(strKey);
		return strPropertyValue;
	}
}
