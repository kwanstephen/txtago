package com.txtago.service;

import com.txtago.bean.Subscription;
import com.txtago.util.ChargifyUtil;
import com.txtago.util.TxtagoProperties;

public class PaymentService extends com.txtago.util.ChargifyUtil
{
	public static PaymentService createInstance() {


		String apiKey    = TxtagoProperties.getInstance().getProperty("chargify.api.key");
		String sharedKey = TxtagoProperties.getInstance().getProperty("chargify.shared.key");
		String site      = TxtagoProperties.getInstance().getProperty("chargify.site");

		PaymentService util = new PaymentService();
		util.init( site, apiKey, sharedKey );
		return util;
	}
	
	public void processSubscriptions(Subscription sub)
	{
		
	}
}