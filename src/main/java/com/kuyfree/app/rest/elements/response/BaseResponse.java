package com.kuyfree.app.rest.elements.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseResponse {

	protected int errorCode;
	protected String failureMessage;
	protected boolean isSucess;

	public int getErrorCode() {
		return errorCode;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public boolean isSucess() {
		return isSucess;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public void setSucess(boolean isSucess) {
		this.isSucess = isSucess;
	}

}
