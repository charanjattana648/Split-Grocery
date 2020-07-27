package com.user.jattana.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Item {
	
	private int id;
	private String itemName;
	private int qty;
	private double itemPrice;
	private Person[] forWhom;
	private String type;
	private String boughtBy;
	private LocalDate date;
	
	
	public Item() {
		super();
	}
	
	public Item(int id,String itemName, int qty, double itemPrice, Person[] forWhom, String type, String boughtBy,LocalDate date) {
		super();
		this.id=id;
		this.itemName = itemName;
		this.qty = qty;
		this.itemPrice = itemPrice;
		this.forWhom = forWhom;
		this.type = type;
		this.boughtBy = boughtBy;
		this.date=date;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Person[] getForWhom() {
		return forWhom;
	}
	public void setForWhom(Person[] forWhom) {
		this.forWhom = forWhom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBoughtBy() {
		return boughtBy;
	}
	public void setBoughtBy(String boughtBy) {
		this.boughtBy = boughtBy;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", qty=" + qty + ", itemPrice=" + itemPrice + ", forWhom="
				+ Arrays.toString(forWhom) + ", type=" + type + ", boughtBy=" + boughtBy + ", date=" + date + "]";
	}
	
	
	

}
