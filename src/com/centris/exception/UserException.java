package com.centris.exception;
import org.apache.log4j.Logger;
public class UserException extends Exception{

	private static Logger log = Logger.getLogger(UserException.class);
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String errorDescription;

	public UserException(String errorCode) {
		this.errorCode = errorCode;
	}

	public UserException(String errorCode, String errorDescription) {

		this(errorCode, errorDescription, null);

	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public UserException(String errorCode, String errorDescription,
			Throwable rootCause) {

		super("<" + errorCode + "> " + errorDescription, rootCause);

		this.errorCode = errorCode;

		this.errorDescription = errorDescription;

	}

	public String getErrorCode() {

		return errorCode;

	}

	public String getErrorDescription() {

		return errorDescription;

	}

	public UserException() {
		super();
		printStackTrace();
		log.debug("Exception in samplelogin EXCEPTION" + super.getStackTrace());

	}

	public UserException(String classname, Exception ex) {

		super(ex);
		log.debug("Exception in " + classname + " : " + ex);
	}

	public static void main(String a[]) {
		try {
			int i = 1 / 0;

			throw new UserException();
		} catch (UserException ee1) {
			System.out.println("my ex" + ee1);
		}
	}

}
