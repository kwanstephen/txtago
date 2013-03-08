package com.txtago.scheduler;

import org.apache.log4j.Logger;

import com.txtago.util.TxtagoProperties;

import java.util.*;


public class TaskScheduler {
	
	private static Logger log = Logger.getLogger(TaskScheduler.class);
	
	static {
		
		log.debug("initializing scheduler");
		TxtagoProperties properties = TxtagoProperties.getInstance();
		String ctask = properties.getProperty("campaign.task.interval");
		String stask = properties.getProperty("subscription.task.interval");
		int ci = Integer.parseInt(ctask);
		int si = Integer.parseInt(stask);
		//run hourly
		Timer campaignTimer = new Timer();
		campaignTimer.schedule(new CampaignTask(),10000,ci);
		//run hourly
		Timer subscriptionTimer = new Timer();
		subscriptionTimer.schedule(new SubscriptionTask(),si);
	}
}    