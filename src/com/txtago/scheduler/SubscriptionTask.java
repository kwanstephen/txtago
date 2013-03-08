package com.txtago.scheduler;

import org.apache.log4j.Logger;

import com.txtago.bean.Campaign;
import com.txtago.bean.Subscription;
import com.txtago.bean.UserSubscription;
import com.txtago.service.CampaignService;
import com.txtago.service.MessagingService;
import com.txtago.service.SubscriptionService;
import com.txtago.util.ChargifySubscription;
import com.txtago.util.ChargifyUtil;

import java.util.*;


public class SubscriptionTask extends TimerTask{
	
	private static Logger log = Logger.getLogger(SubscriptionTask.class);
	
	public void processSubscription()
	{
		log.debug("subscription task running...");
		try
		{
			ChargifyUtil chargify = ChargifyUtil.createInstance();
			SubscriptionService service = new SubscriptionService();
			List<UserSubscription> subscriptions = service.getAllUserSubscriptions();
			if(subscriptions!=null)
			{
				for(int i = 0;i < subscriptions.size(); i++)
				{
					UserSubscription s = (UserSubscription)subscriptions.get(i);
					String paid_id = s.getPaidBillingId();
					ChargifySubscription ch = chargify.getSubscription(paid_id);
					Date expire = ch.getCurrent_period_ends_at();
					//active
					String state = ch.getState();
					s.setStatus(state.toUpperCase());
					s.setNextBillingDate(expire.toString());
					service.updateUserSubscription(s);
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
		processSubscription();
	}
}  