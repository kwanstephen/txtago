package com.txtago.bean;

import java.util.Date;


public class UserSubscription {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int subscriptionId;
	
	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String status = "ACTIVE";
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String paidBillingId;
	
	public String getPaidBillingId() {
		return paidBillingId;
	}

	public void setPaidBillingId(String paidBillingId) {
		this.paidBillingId = paidBillingId;
	}

	private int usage;
	
	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	private Subscription subscription;

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	private String nextBillingDate;

	public String getNextBillingDate() {
		return nextBillingDate;
	}

	public void setNextBillingDate(String nextBillingDate) {
		this.nextBillingDate = nextBillingDate;
	} 
	
	/*
	public String getNextBillingDateString()
	{	
		String dString = "";
		if(nextBillingDate!=null)
		{
			Date d = new java.util.Date();
			d.setTime(Long.valueOf(nextBillingDate));
			dString = d.toString();
		}
		return dString;
	}
	*/
}
