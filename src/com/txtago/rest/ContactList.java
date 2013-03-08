package com.txtago.rest;

import java.util.ArrayList;
import java.util.List;

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
import com.txtago.bean.Message;
import com.txtago.bean.Report;
import com.txtago.service.CampaignService;
import com.txtago.service.ReportService;

@Path("/contact.list")
public class ContactList extends AuthUser{
	
	private static Logger log = Logger.getLogger(ContactList.class);
	
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
				int iid = 0;
				if(id!=null && !id.equals(""))
					iid = Integer.parseInt(id);
												
				CampaignService service = new CampaignService();
				List msgs = service.getContacts(iid);
				String m = "\"contacts\": {";
				if(msgs!=null)
				{
					
					for(int i=0;i<msgs.size();i++)
					{
						
						Contact mm = (Contact)msgs.get(i);
						
						m = m +
						"\"contact\": {"+
						"\"contact.id\": \""+mm.getId()+"\","+
						"\"contact.phone\": \""+mm.getPhone()+"\"},";
					}
					
				}
				m = m + "}";
				return m;
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