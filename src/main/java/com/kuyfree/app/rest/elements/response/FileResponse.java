package com.kuyfree.app.rest.elements.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.kuyfree.app.model.File;

@XmlRootElement
public class FileResponse extends BaseResponse {
	private File item;

	public File getItem() {
		return item;
	}

	public void setItem(File item) {
		this.item = item;
	}

}
