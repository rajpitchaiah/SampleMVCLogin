package com.centris.DAO;



import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import java.sql.Statement;
import java.util.Date;
 
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.centris.action.LoginAction;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

 

public class DBService extends AbstractConnectionFactory {

	private static Logger log = Logger.getLogger(DBService.class);
	 
	
	private Statement statement = null;
 
    private Statement getStatement() throws Exception{
    	statement = getConnection().createStatement();
        return statement;
    }
    
   
    
    public PreparedStatement getPreparedStatement(String sql) throws Exception{
    	 
        return (PreparedStatement) getConnection().prepareStatement(sql);
    }
    
    
    public ResultSet getData(String sql) throws Exception{
    	 
        return getStatement().executeQuery(sql);
    }
    
    
    public int updateData(String sql) throws Exception{
    	 
        return getStatement().executeUpdate(sql);
    }
    
    
    public boolean insertData(String sql) throws Exception{

    	 
        return getStatement().execute(sql);
    }
    
   
    public void closeAll(Statement stmt, ResultSet rs) throws Exception{
    	Connection connection = null;
        if(rs != null){
        	
            rs.close();
        }         
        if(stmt != null){
        	connection = stmt.getConnection();
            stmt.close();
            connection.close();
        }   
    }
    
    public void close( ResultSet rs) throws Exception{
    	Connection connection = null;
        if(rs != null){
            rs.close();
        }
        
        if(statement != null){
        	connection = statement.getConnection();
        	statement.close();
            connection.close();
        	statement.close();
        }   
    }
    
    public void closeAll(PreparedStatement ps, ResultSet rs) throws SQLException{
    	Connection connection = null;
    	 if(rs != null){
             rs.close();
         }
         
         if(ps != null){
        	 connection = ps.getConnection();
        	 ps.close();
             connection.close();
         } 
    	
    }
    
    
    

}
