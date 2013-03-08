package com.txtago.bean;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Campaign {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String shortcode;
	

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	private String keyword;
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private String status = "ACTIVE";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private String deliveryDate;

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH");
	
	private int deliveryHour;

	public int getDeliveryHour() {
		return deliveryHour;
	}

	public void setDeliveryHour(int deliveryHour) {
		this.deliveryHour = deliveryHour;
	}

	public Date getDeliveryDateObject()
	{
		Date d = null;
		try
		{
		if(deliveryDate!=null)
			d = sdf.parse(deliveryDate+":"+deliveryHour);
		}
		catch(Exception e)
		{
			
		}
		return d;
	}
	
}
