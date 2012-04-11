package com.centris.VO;



public class LoginVO {


	private   String UserName;
	private   String PassWord;


	public   String getUserName() {
		System.out.println("inside LoginDAOPojo"+UserName);
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public   String getPassWord() {

		return PassWord;
	}
	public   void setPassWord(String passWord) {
		PassWord = passWord;
	} 

 


}
