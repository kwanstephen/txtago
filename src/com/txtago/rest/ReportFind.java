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
import com.txtago.bean.Message;
import com.txtago.bean.Report;
import com.txtago.service.CampaignService;
import com.txtago.service.ReportService;

@Path("/report.find")
public class ReportFind extends AuthUser{
	
	private static Logger log = Logger.getLogger(ReportFind.class);
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String doRest(
			@QueryParam("auth.email") String email, 
			@QueryParam("auth.password") String password,
			@QueryParam("campaign.id") String id,
			@QueryParam("report.shortcode") String shortcode,
			@QueryParam("report.destination_mdn") String destination_mdn,
			@QueryParam("report.days_back") String days_back
			
			) {
		
		try
		{
			log.debug("days_back = "+days_back);
			log.debug("shortcode = "+shortcode);
			log.debug("destination_mdn = "+destination_mdn);
			log.debug("campaign.id = "+id);
			
			int userId = this.authUser(email, password);
			if(userId > -1)
			{
				int iid = 0;
				if(id!=null && !id.equals(""))
					iid = Integer.parseInt(id);
				
				int idb = 0;
				if(days_back!=null && !days_back.equals(""))
					idb = Integer.parseInt(days_back);
				
				Report r = new Report();
				r.setCampaignId(iid);
				r.setDaysBack(idb);
				r.setShortcode(shortcode);
				r.setDestinationMdn(destination_mdn);
				
				ReportService service = new ReportService();
				List<Message> msgs = service.getMessages(userId, r);
				String m = "\"reports\": {";
				if(msgs!=null)
				{
					
					for(int i=0;i<msgs.size();i++)
					{
						
						Message mm = (Message)msgs.get(i);
						
						m = m +
						"\"report\": {"+
						"\"message.id\": \""+mm.getId()+"\","+
						"\"message.shortcode\": \""+mm.getShortcode()+"\","+
						"\"message.destination_mdn\": \""+mm.getDestinationMdn()+"\","+
						"\"message.delivery_date\": \""+mm.getDeliveryDate()+"\","+
						"\"message.status\": \""+mm.getStatus()+"\"},";
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