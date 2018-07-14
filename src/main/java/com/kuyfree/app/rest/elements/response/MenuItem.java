package com.kuyfree.app.rest.elements.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


public class MenuItem {
	
	private int locationMenu_Id;
	private String ItemName;
	private String ItemDesciption;
	private String ItemDesciptionLong;
	private double price;
	private int partner_location_id;
	private String itemType;
	public int getLocationMenu_Id() {
		return locationMenu_Id;
	}
	public void setLocationMenu_Id(int locationMenu_Id) {
		this.locationMenu_Id = locationMenu_Id;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemDesciption() {
		return ItemDesciption;
	}
	public void setItemDesciption(String itemDesciption) {
		ItemDesciption = itemDesciption;
	}
	public String getItemDesciptionLong() {
		return ItemDesciptionLong;
	}
	public void setItemDesciptionLong(String itemDesciptionLong) {
		ItemDesciptionLong = itemDesciptionLong;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPartner_location_id() {
		return partner_location_id;
	}
	public void setPartner_location_id(int partner_location_id) {
		this.partner_location_id = partner_location_id;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
}
