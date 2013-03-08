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

@Path("/campaign.update")
public class CampaignUpdate extends AuthUser{
	
	private static Logger log = Logger.getLogger(CampaignUpdate.class);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String doRest(
			@QueryParam("auth.email") String email, 
			@QueryParam("auth.password") String password,
			@QueryParam("campaign.id") String id,
			@QueryParam("campaign.shortcode") String shortcode,
			@QueryParam("campaign.keyword") String keyword,
			@QueryParam("campaign.title") String title,
			@QueryParam("campaign.description") String description,
			@QueryParam("campaign.delivery_date") String delivery_date,
			@QueryParam("campaign.delivery_hour") String delivery_hour,
			@QueryParam("campaign.status") String status
			) {
		
		try
		{
			int userId = this.authUser(email, password);
			if(userId > -1)
			{
				Campaign c = new Campaign();
				c.setUserId(userId);
				int iid = 0;
				if(id!=null && !id.equals(""))
					iid = Integer.parseInt(id);
				c.setId(iid);
				c.setShortcode(shortcode);
				c.setKeyword(keyword);
				c.setTitle(title);
				c.setDescription(description);
				c.setStatus(status);
				c.setDeliveryDate(delivery_date);
				int ihr = 0;
				if(delivery_hour!=null && !delivery_hour.equals(""))
					ihr = Integer.parseInt(delivery_hour);
				c.setDeliveryHour(ihr);
				
				CampaignService service = new CampaignService();
				
				if(iid == 0)
					service.addCampaign(c);
				else
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