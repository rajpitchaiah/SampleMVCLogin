package com.centris.util.constants;

public class MessageConstants {
	 
	public static String prop_dir="com/centris/properties/application.properties";
	public static final String START_POINT = " :Start Point Of The Method.";
	public static final String END_POINT = " :End Point Of The Method.";
	   
    public static String displayMessage(String s_message, String s_msg_type){
    	String msg = "<head><script>window.showModalDialog('servermessagepopup.jsp?param=";
    	msg = msg + s_message;
    	msg = msg + "&type=" + s_msg_type;
    	msg = msg + "','','dialogHeight:220px;dialogWidth:400px;resizable:yes;');</script></head>";
    	return msg;
    }
	
}
