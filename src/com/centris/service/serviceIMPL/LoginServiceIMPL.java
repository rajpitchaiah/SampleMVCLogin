package com.centris.service.serviceIMPL;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.centris.DAO.LoginDAO;
import com.centris.DAO.DAOIMPL.LoginDAOIMPL;
import com.centris.action.LoginAction;
import com.centris.exception.UserException;
import com.centris.service.LoginService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class LoginServiceIMPL implements LoginService {

	@Override
	public String isValidUser(String user, String pwd) throws UserException,Exception {

		String prop_path = JLogger.getlog4JPropertyPath();	    
		PropertyConfigurator.configure(prop_path);
		Logger log = Logger.getLogger(LoginServiceIMPL.class);	
		log.setLevel(Level.DEBUG);
		Date date_start = new Date();
		JLogger.log(0, JDate.getTimeString(date_start)
				+ MessageConstants.START_POINT);
		log.info(JDate.getTimeString(date_start)
				+ MessageConstants.START_POINT);


		LoginDAO loginDAO=new LoginDAOIMPL(); 
		String result=loginDAO.userValid(user, pwd);

		if(result!=null && result.equals("true")  ){
			Date date_end = new Date();
			JLogger.log(0, JDate.getTimeString(date_end)
					+ MessageConstants.START_POINT);
			log.info(JDate.getTimeString(date_end)
					+ MessageConstants.START_POINT);
			return "true";



		}else
		{
			return "false";
		}



	}


}
