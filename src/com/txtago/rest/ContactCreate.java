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
import com.txtago.bean.Contact;
import com.txtago.service.CampaignService;

@Path("/contact.create")
public class ContactCreate extends AuthUser{
	
	private static Logger log = Logger.getLogger(ContactCreate.class);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String doRest(
			@QueryParam("auth.email") String email, 
			@QueryParam("auth.password") String password,
			@QueryParam("campaign.id") String id,
			@QueryParam("contact.phone") String phone
			
			) {
		
		try
		{
			int userId = this.authUser(email, password);
			if(userId > -1)
			{
				
				Contact c = new Contact();
				int iid = 0;
				if(id!=null && !id.equals(""))
					iid = Integer.parseInt(id);
				c.setCampaignId(iid);
				c.setPhone(phone);				
				CampaignService service = new CampaignService();
				
				if(iid == 0)
					service.addContact(c);
				else
					service.updateContact(c);
				
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