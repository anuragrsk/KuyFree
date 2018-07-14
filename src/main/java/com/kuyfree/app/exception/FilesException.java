package com.kuyfree.app.exception;

public class FilesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7251780178841283991L;
	private int errorCode;
	private String message;

	public FilesException() {
		super();
	}

	public FilesException(String message) {
		super(message);
	}

	public FilesException(String message, Throwable cause) {
		super(message, cause);
	}

	public FilesException(String message, int code) {
		super(message);
		this.errorCode = code;
		this.message = message;

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
