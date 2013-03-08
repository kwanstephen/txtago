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
import com.txtago.bean.Content;
import com.txtago.service.CampaignService;

@Path("/content.update")
public class ContentUpdate extends AuthUser{
	
	private static Logger log = Logger.getLogger(ContentUpdate.class);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String doRest(
			@QueryParam("auth.email") String email, 
			@QueryParam("auth.password") String password,
			@QueryParam("content.id") String id,
			@QueryParam("campaign.id") String campaign_id,
			@QueryParam("content.name") String name,
			@QueryParam("content.content_url") String content_url,
			@QueryParam("content.content_type") String content_type,
			@QueryParam("content.content_text") String content_text
			) {
		
		try
		{
			log.debug("content.id = "+id);
			log.debug("campaign.id = "+campaign_id);
			int userId = this.authUser(email, password);
			if(userId > -1)
			{
				CampaignService service = new CampaignService();
				int iid = 0;
				if(id!=null && !id.equals(""))
					iid = Integer.parseInt(id);
				
				Content c = null;
				if(iid == 0)
				{
					c = new Content();
				
					int cid = 0;
					if(campaign_id!=null && !campaign_id.equals(""))
						cid = Integer.parseInt(campaign_id);
					c.setCampaignId(cid);
				}
				else
				{
					c = service.getContent(iid);
				}
				c.setName(name);
				c.setContentText(content_text);
				c.setContentType(content_type);
				c.setContentUrl(content_url);
				
				if(iid == 0)
					service.addContent(c);
				else
					service.updateContent(c);
				
				
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