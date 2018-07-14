package com.kuyfree.app.util;

public enum ErrorMapping {

	FILE_NOT_FOUND(1, "File not found."), INVALID_FILE_ID(2, "File id is not valid."), ERROR(90000,
			"We are unable to process your request. Please try after some time.");
	private final int errorCode;
	private final String description;

	public int getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}

	private ErrorMapping(int code, String desc) {
		this.errorCode = code;
		this.description = desc;
	}

}
