package com.kuyfree.app.rest.elements.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class MenuResponse extends BaseResponse{
	
	private int totalPages;
	private List<MenuItem> items;
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<MenuItem> getItems() {
		return items;
	}
	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
}
