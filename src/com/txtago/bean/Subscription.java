package com.txtago.bean;


public class Subscription {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int messageLimit;
	
	public int getMessageLimit() {
		return messageLimit;
	}

	public void setMessageLimit(int messageLimit) {
		this.messageLimit = messageLimit;
	}

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String billingCode;

	public String getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(String billingCode) {
		this.billingCode = billingCode;
	}
}
