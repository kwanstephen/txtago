package com.txtago;


import java.io.Serializable;
import com.txtago.controller.*;

import org.apache.log4j.Logger;



public class TxtagoService implements Serializable{
		
	private static Logger log = Logger.getLogger(TxtagoService.class);
		
	public CampaignController getCampaignController()
	{
		return new CampaignController();
	}
	
	public LoginController getLoginController()
	{
		return new LoginController();
	}
	
	public ReportController getReportController()
	{
		return new ReportController();
	}
	
	public SubscriptionController getSubscriptionController()
	{
		return new SubscriptionController();
	}
	
	public UserController getUserController()
	{
		return new UserController();
	}

}
