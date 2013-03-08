package com.txtago.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Report implements Serializable{

	private int campaignId;

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	
	private String destinationMdn;

	
	
	public String getDestinationMdn() {
		return destinationMdn;
	}

	public void setDestinationMdn(String destinationMdn) {
		this.destinationMdn = destinationMdn;
	}

	private String shortcode;
	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	private int daysBack = 7;

	public int getDaysBack() {
		return daysBack;
	}

	public void setDaysBack(int daysBack) {
		this.daysBack = daysBack;
	}
	
	List dataPoint = new ArrayList();

	public List getDataPoint() {
		return dataPoint;
	}

	public void setDataPoint(List dataPoint) {
		this.dataPoint = dataPoint;
	}
	
}
