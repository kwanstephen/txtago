package com.txtago.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.txtago.bean.Campaign;
import com.txtago.bean.Contact;
import com.txtago.bean.Content;
import com.txtago.bean.Message;
import com.txtago.bean.Subscription;
import com.txtago.bean.UserSubscription;
import com.txtago.util.HibernateUtil;
import com.txtago.util.TxtagoProperties;

import com.mobile365.api.mm7.client.MM7RequestClient;
import com.mobile365.api.mm7.client.MM7RequestClientException;
import com.mobile365.api.mm7.pdu.MM7SubmitRequest;
import com.mobile365.api.mm7.pdu.MM7SubmitResponse;
import com.mobile365.api.mm7.pdu.PDUException;
import com.mobile365.api.mm7.pdu.MM7MessageFactory;

import com.mobile365.api.mm7.pdu.datatypes.*;
import com.mobile365.api.mm7.client.ErrorResponseException;
import com.mobile365.util.p2p.io.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.mail.internet.MimeBodyPart;

public class MessagingService 
{
	private static Logger log = Logger.getLogger(MessagingService.class);
	private MM7MessageFactory _pduFactory = MM7MessageFactory.newInstance();
		
	
	public void processCampaign(Campaign campaign)
	{
		try
		{
			CampaignService service = new CampaignService();
			SubscriptionService sservice = new SubscriptionService();
			UserSubscription userSub = sservice.getUserSubscription(campaign.getUserId());
			Subscription sub = sservice.getSubscription(userSub.getSubscriptionId());
			if(userSub.getUsage() < sub.getMessageLimit() && userSub.getStatus().equalsIgnoreCase("ACTIVE"))
			{
				
				List<Contact> contacts = service.getContacts(campaign.getId());
				Content content = service.getContentByCampaign(campaign.getId());
				String shortcode = campaign.getShortcode();
				for(int i=0;i<contacts.size();i++)
				{
					Contact cc = (Contact)contacts.get(i);
					String mdn = cc.getPhone();
					boolean success = sendMessageToPhone(shortcode,mdn,content);
					Message m = new Message();
					m.setCampaignId(campaign.getId());
					m.setDeliveryDate(new java.util.Date());
					m.setDestinationMdn(cc.getPhone());
					m.setShortcode(campaign.getShortcode());
					if(success)
					{
						m.setStatus("PROCESSED");
						//add 1 to message quota
						int total = userSub.getUsage() + 1;
						userSub.setUsage(total);
						sservice.updateUserSubscription(userSub);
						
					}
					else
					{
						m.setStatus("ERROR");
					}
					this.saveMessage(m);
				}
				campaign.setStatus("PROCESSED");
				service.updateCampaign(campaign);
			}
			else
			{
				campaign.setStatus("FAILED");
				service.updateCampaign(campaign);
			}
			
		}
		catch(Exception e)
		{
			log.error("",e);
		}
	}

	public void saveMessage(Message m)
	{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			session.beginTransaction();
			session.save(m);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
		}
	}
	
	public void optIn(String shortcode, String mdn, String keyword)
	{
		try
		{
			CampaignService service = new CampaignService();
			Campaign c = service.getCampaignByShortCodeKeyword(shortcode,keyword);
			Contact cc = new Contact();
			cc.setCampaignId(c.getId());
			cc.setPhone(mdn);
			service.addContact(cc);
		}
		catch(Exception e)
		{
			log.error("",e);
		}
	}
	
	public boolean sendMessageToPhone( String shortcode, String mdn, Content content ) throws MM7RequestClientException, PDUException {
		
		TxtagoProperties properties = TxtagoProperties.getInstance();
		String vaspid = properties.getProperty("sybase.vaspid");
		String vasid = properties.getProperty("sybase.vasid");
		String msgUrl = properties.getProperty("sybase.url");
		
		MM7RequestClient _client = new MM7RequestClient( msgUrl );
		
		byte[] contentBuffer = null;
		try {
			if(content.getContentUrl()!=null && !content.getContentUrl().trim().equals(""))
			{
				contentBuffer = getUrlContent(content.getContentUrl());
				log.debug("payload ----------");
				log.debug(contentBuffer);
				
			}
			else
			{
				contentBuffer = content.getContentText().getBytes();
			}
		}
		catch ( Exception e ) {
			log.error( "Unable to find product file.", e );
			return false;
		}

		try {
			MM7DataTypeFactory dtf = MM7DataTypeFactory.newInstance();
			
			MM7SubmitRequest thisRequest = _pduFactory.createSubmitRequest();
			Address senderAddress = dtf.createAddress( shortcode, AddressType.NUMBER );  
			// This address would be the shortcode for the VAS
			Address recipientAddress = dtf.createAddress( mdn, AddressType.NUMBER ); 
			// This address would be the mobile number that the message's recipient.
			
			thisRequest.setSender( dtf.createSender( vaspid, vasid, senderAddress ) );
			thisRequest.addRecipient( dtf.createRecipient( recipientAddress , RecipientType.TO ) );
			thisRequest.setSubject( "" );
			thisRequest.setMessageClass( MessageClass.PERSONAL );
			thisRequest.setDeliveryReport( false );
			//thisRequest.setA2PTransactionId( "placeOrder.getTransactionId()" );
			
			MimeBodyPart attachment = thisRequest.createAttachment( "<"+content.getName()+">", content.getContentType(), contentBuffer );
			thisRequest.addAttachment( attachment ); 
		
			MM7SubmitResponse response = _client.sendSubmit( thisRequest ); 
			log.info( "Message sent succussfully!  Recorded as Messageid " + response.getMessageID() );
			return true;
		}
		catch ( ErrorResponseException e ) {
			log.error( "Exception trace:", e );
			return false;
		}
		catch ( Exception e ) {
			log.error( "Exception trace:", e );
			return false;
		}
		
	}
	
	public byte[] getUrlContent(String webPage) {
		byte[] result = null;
		try {
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			
			result = InputStreamUtil.toByteArray(is);
			is.close();
			
			

		} catch (Exception e) {
			log.error("",e);
		} 
		return result;
	}
}