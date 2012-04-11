package com.centris.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm{

	private String userName;

	private String password;


	public LoginForm() {
		super();
	}


	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (userName == null || userName.length() < 1) {
			errors.add("userName", new ActionMessage("error.userName.required"));
		}
		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));
		}
		return errors;
	}


	public String getUserName() {
		System.out.println("Inside getter "+userName);
		return userName;
	}


	public void setUserName(String userName) {
		System.out.println("Inside setter "+userName);
		this.userName = userName;
	}

	public   String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.userName=null;
		this.password=null;
	}
}

