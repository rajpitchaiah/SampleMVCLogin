package com.centris.DAO.DAOIMPL;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.w3c.dom.views.AbstractView;
import com.centris.DAO.AbstractConnectionFactory;
import com.centris.DAO.DBService;
import com.centris.DAO.LoginDAO;

import com.centris.VO.LoginVO;
import com.centris.exception.UserException;
import com.centris.service.serviceIMPL.LoginServiceIMPL;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;





public class LoginDAOIMPL extends DBService  implements LoginDAO{
	HttpServletRequest request;
	public LoginVO lvo;

	@Override
	public String userValid(String username, String password) throws UserException,Exception {

		String prop_path = JLogger.getlog4JPropertyPath();	    
		PropertyConfigurator.configure(prop_path);
		Logger log = Logger.getLogger(LoginDAOIMPL.class);	
		log.setLevel(Level.DEBUG);
		Date date_start = new Date();
		JLogger.log(0, JDate.getTimeString(date_start)
				+ MessageConstants.START_POINT);
		log.info(JDate.getTimeString(date_start)
				+ MessageConstants.START_POINT);

		lvo=new LoginVO();
		String userexist = null;
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = SQLutilConstants.LOGINCHECK;

		try{


			con= getConnection();
			pstmt =  con.prepareStatement(query); 
			pstmt.setString(1, username); 
			rs = pstmt.executeQuery();

			if (rs.next())
			{

				lvo.setUserName(rs.getString("UserName"));
				lvo.setPassWord(rs.getString("Password"));
				userexist = "true";
			} else {
				userexist = "false";
			}

		}catch(SQLException se)
		{
			se.printStackTrace();
		}finally{
			try {
				closeAll(pstmt, null);
			} catch (SQLException e) {

				e.printStackTrace();
				log.info("In LoginDAOIMPL connection catch block $$$$"+e);
			}
		}

		return userexist;
	}






}
