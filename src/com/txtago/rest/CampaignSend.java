package com.txtago.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.txtago.bean.Campaign;
import com.txtago.service.CampaignService;
import com.txtago.service.MessagingService;

@Path("/campaign.send")
public class CampaignSend extends AuthUser{
	
	private static Logger log = Logger.getLogger(CampaignSend.class);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String doRest(
			@QueryParam("auth.email") String email, 
			@QueryParam("auth.password") String password,
			@QueryParam("campaign.id") String id
			) {
		
		try
		{
			int userId = this.authUser(email, password);
			if(userId > -1)
			{
								
				CampaignService service = new CampaignService();
				int iid = 0;
				if(id!=null && !id.equals(""))
					iid = Integer.parseInt(id);
				
				Campaign c = service.getCampaign(iid);
				java.util.Date d = new java.util.Date();
				c.setDeliveryDate(d.getYear()+"-"+d.getMonth()+"-"+d.getDate());
				c.setDeliveryHour(0);
				
				service.updateCampaign(c);
				
				return this.successResponse();
			}
			else
			{
				return this.notAuthResponse();
			}
		}
		catch(Exception e)
		{
			log.error("",e);
			return errorResponse();
		}
	}
}    