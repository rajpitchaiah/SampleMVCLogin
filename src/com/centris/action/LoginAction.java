package com.centris.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.exception.UserException;
import com.centris.form.LoginForm;
import com.centris.service.LoginService;
import com.centris.service.serviceIMPL.LoginServiceIMPL;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;
 


public class LoginAction extends org.apache.struts.action.Action {
	//private static Logger log = Logger.getLogger(LoginAction.class);
	private static final long serialVersionUID = 1L;
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws UserException,Exception{
    	
    	 
    	String prop_path = JLogger.getlog4JPropertyPath();	    
        PropertyConfigurator.configure(prop_path);
        Logger log = Logger.getLogger(LoginAction.class);	
        log.setLevel(Level.DEBUG);
        Date date_start = new Date();
        JLogger.log(0, JDate.getTimeString(date_start)
    			+ MessageConstants.START_POINT);
        log.info(JDate.getTimeString(date_start)
    			+ MessageConstants.START_POINT);
    	
    	
        LoginForm loginForm = (LoginForm) form; 
        try{
    	LoginService loginservice=new LoginServiceIMPL();
    	  
         if (loginservice.isValidUser(loginForm.getUserName(), loginForm.getPassword()).equals("true"))
        {
            return mapping.findForward(ApplicationConstants.SUCCESS);
           
             
        }   
        }catch (UserException aie) {
			// TODO: handle exception
        	aie.printStackTrace();
        	 log.info("LoginAction $$$$$$$$"+date_start +"$$$$$$"+aie);
		}
         Date date_end = new Date();
         JLogger.log(0, JDate.getTimeString(date_end)
     			+ MessageConstants.END_POINT);
         log.info(JDate.getTimeString(date_end)
     			+ MessageConstants.END_POINT);
            return mapping.findForward(ApplicationConstants.FAILURE);
            
    }
}
