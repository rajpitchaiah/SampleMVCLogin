 
package com.centris.util.Helper;

import java.text.FieldPosition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.*;
 
public class JDate {
	
	private static SimpleDateFormat sdfNormal = new SimpleDateFormat("dd/MM/yyyy");
	 
	
	private static SimpleDateFormat sdfNormalUs = new SimpleDateFormat("MM/dd/yyyy");
	private static SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
	private static FieldPosition fpDate = new FieldPosition(SimpleDateFormat.DATE_FIELD);
	private static FieldPosition fpDate1 = new FieldPosition(SimpleDateFormat.YEAR_FIELD);
	private static SimpleDateFormat sdfTime = new SimpleDateFormat("S");
	
	static
	{
		sdfNormal.setLenient(false);
		sdfSQL.setLenient(false);
		sdfNormalUs.setLenient(false);
	}
	
	public static String toNormalDate(String str) throws ParseException
	{
		if(str==null)
		{
			str = "";
			return str;
		}
		StringBuffer sb = new StringBuffer();
		Date dt = sdfSQL.parse(str);
		sdfNormal.format(dt,sb,fpDate);
		return sb.toString();
	}
	
	public static String toSQLDate(String str) throws ParseException
	{
		if(str=="")
		{
			str = null;    
			return str;    
		}
		StringBuffer sb = new StringBuffer();
		Date dt = sdfNormal.parse(str);
		sdfSQL.format(dt,sb,fpDate);
		return sb.toString();
	}
	public static String parseSQLDateToUSDate(String str) throws ParseException
	{
		if(str=="")
		{
			str = null;    
			return str;    
		}
		StringBuffer sb = new StringBuffer();
		Date dt = sdfSQL.parse(str);
		sdfNormalUs.format(dt,sb,fpDate1);
		return sb.toString();
	}
	
	public static String getElapsedTime(Date date_start, Date date_end)
	{
		long start_ms = date_start.getTime();
		long end_ms = date_end.getTime();
		long total_ms = end_ms - start_ms;		    
	    long total_sec = (total_ms - (total_ms%1000))/1000;	    
	    long total_min = total_sec / 60;	    
	    long total_hr = total_min / 60;

		long rem_ms = total_ms % 1000;		
		long rem_sec = total_sec % 60;		
		long rem_min = (total_min) % 60;		
		long rem_hr = total_min / 60;

		String rem_time = ""+ rem_hr + "Hr:" + rem_min + "Min:" + rem_sec + "Sec:" + rem_ms +"Ms";
		return rem_time;		
	}
	
	public static String getTimeString(Date date_string)
	{
		String s_time = ""+ date_string.getHours();
		s_time = s_time +  "Hr:" + date_string.getMinutes();
		s_time = s_time +  "Min:" + date_string.getSeconds();
		s_time = s_time +  "Sec:" + (date_string.getTime() % 1000)+ "Ms";
		return s_time;
	}
	
	public static Date parseStringToDate(String s_date,String s_split){
	    int i_year=0,i_month=0,i_date=0;
	    
	    if(s_split.equals("-")){
	        String s_tokens[] = s_date.split("-");
	    
	        i_year = Integer.parseInt(s_tokens[0]);
	        i_month = Integer.parseInt(s_tokens[1]);
	        i_date = Integer.parseInt(s_tokens[2]);
	    }
	    if(s_split.equals("/")){
	        String s_tokens[] = s_date.split("/");
	    
	        i_year = Integer.parseInt(s_tokens[2]);
	        i_month = Integer.parseInt(s_tokens[1]);
	        i_date = Integer.parseInt(s_tokens[0]);
	    }    
	    
	    Date dt_parsed = new Date(i_year-1900, i_month-1, i_date);
	    return dt_parsed;
	}
	
	public static String parseUSDateToNormalDate(String s_date){
	     String s_tokens[] = s_date.split("/");
	    
	     String s_month = s_tokens[0];
	     String s_day = s_tokens[1];
	     String s_year = s_tokens[2];
	     
	     String s_normal_date = s_day+"/"+s_month + "/"+ s_year;
	     return s_normal_date;
	}

	
	public static void main(String[] args) throws Exception 
	{
		String strSQL = "1983-03-31";
		String strNormal = "21/11/1983";
		String prop_path = JLogger.getlog4JPropertyPath();
 	    
 	    PropertyConfigurator.configure(prop_path);
 	    
 	    //Logger log = Logger.getLogger(Constants.POPUPQUERY_CLASS); 
 		
        // log.setLevel(Level.DEBUG);
		
		try
		{
			
		}
		catch(Exception ex)
		{
			//JLogger.log(-1,ex.toString(),ex);
		//log.debug(MessageConstants.EXCEPTION_ROLLBACK);
		}
	}
	
	 public static String calcGMTTime()
	    {
	     	/*double d_offset=8; //Maleshiian offset later value will come from propertyu file.	
	     
	        Date date_current = new Date();
	        
	        long l_utc = date_current.getTime() + (date_current.getTimezoneOffset() * 60000);      
	        
	        Date date_sys = new Date(l_utc +Math.round(3600000*d_offset));
	        
	        //System.out.println("..."+date_sys.toLocaleString());
	        
	        return  date_sys.toLocaleString();*/
	     
	     	Date d = new Date();
	        
	     	//System.out.println("befor date is :" +d.toString());
	    	
	        //d.setHours(d.getHours()+12);
	        d.setHours(d.getHours()-2);
	        
	       	//String x=d.setHours(d.getHours()+12);   
	       	//String y=x.s
	        //System.out.println("after date is :" +d);
	        
	        return d.toLocaleString();

	    }
	
}