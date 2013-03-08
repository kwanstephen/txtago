package com.txtago.scheduler;

import org.apache.log4j.Logger;

import com.txtago.bean.Campaign;
import com.txtago.service.CampaignService;
import com.txtago.service.MessagingService;

import java.util.*;


public class CampaignTask extends TimerTask{
	
	private static Logger log = Logger.getLogger(CampaignTask.class);
	
	public void processCampaign()
	{
		try
		{
			log.debug("campaign task running...");
			MessagingService msgService = new MessagingService();
			CampaignService service = new CampaignService();
			List<Campaign> campaigns = service.getCampaignsByStatus("ACTIVE");
			if(campaigns!=null)
			{
				for(int i = 0;i < campaigns.size(); i++)
				{
					Campaign c = (Campaign)campaigns.get(i);
					msgService.processCampaign(c);
				}
			}
		}
		catch(Exception e)
		{
			log.error("",e);
		}
		
	}
	
	public void run()
	{
		processCampaign();
	}
}    