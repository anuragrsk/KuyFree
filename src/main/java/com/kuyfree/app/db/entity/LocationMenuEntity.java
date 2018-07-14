package com.kuyfree.app.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION_MENU")
public class LocationMenuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCATION_MENU_ID")
	private int locationMenu_Id;
	@Column(name = "ITEM_NAME")
	private String ItemName;
	@Column(name = "ITEM_SHOT_DESC")
	private String ItemDesciption;
	@Column(name = "ITEM_LONG_DESC")

	private String ItemDesciptionLong;
	@Column(name = "ITEM_PRICE")

	private double price;
	@Column(name = "PARTNER_LOCATION_ID")

	private int partner_location_id;
	@Column(name = "ITEM_TYPE")

	private String itemType;
	@Column(name = "ACTIVE")
	private String active;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
}
