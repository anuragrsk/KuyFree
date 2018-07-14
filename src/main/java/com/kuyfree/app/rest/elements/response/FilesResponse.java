package com.kuyfree.app.rest.elements.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.kuyfree.app.model.File;

@XmlRootElement
public class FilesResponse extends BaseResponse {
	private int totalPages;
	private List<File> items;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<File> getItems() {
		return items;
	}

	public void setItems(List<File> items) {
		this.items = items;
	}

}
