package com.centris.DAO;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.centris.action.LoginAction;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
 
 
import com.centris.util.constants.MessageConstants;
  
public abstract class AbstractConnectionFactory {
	
		public static Connection getConnection() throws Exception {
			String prop_path = JLogger.getlog4JPropertyPath();	    
		    PropertyConfigurator.configure(prop_path);
		    Logger log = Logger.getLogger(LoginAction.class);	
		    log.setLevel(Level.DEBUG);
		    Date date_start = new Date();
		    JLogger.log(0, JDate.getTimeString(date_start)
					+ MessageConstants.START_POINT);
		    log.info(JDate.getTimeString(date_start)
					+ MessageConstants.START_POINT);
			
			 
			Connection conn = null;
			try {
				 

				/* String driverName = JPropertyReader.readProperty("DATABASE_DRIVERNAME");
				String hostName = JPropertyReader.readProperty("HOST_NAME"); 
				String dbName = JPropertyReader.readProperty("DATABASE_NAME"); 
				String dbuserName = JPropertyReader.readProperty("USER_NAME"); 
				String dbpassword = JPropertyReader.readProperty("USER_PASSWORD"); 
				  */
				  String driverName ="com.mysql.jdbc.Driver";
				String hostName ="jdbc:mysql://192.168.1.101:3306/"; 
				String dbName = "test"; 
				String dbuserName = "test"; 
				String dbpassword = "test";   
 
				Class.forName(driverName).newInstance();
				conn = DriverManager.getConnection(hostName+dbName, dbuserName,
						dbpassword);
 

			} catch (SQLException e) {
				// TODO: handle exception
				 e.printStackTrace();
				throw e;
			}

			catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
				throw e;
			}
			
			 Date date_end = new Date();
	         JLogger.log(0, JDate.getTimeString(date_end)
	     			+ MessageConstants.END_POINT);
	         log.info(JDate.getTimeString(date_end)
	     			+ MessageConstants.END_POINT);
		    
			return conn;
			
		}
		
	}
