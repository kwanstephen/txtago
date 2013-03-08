package com.txtago.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Date;

import com.txtago.bean.Campaign;
import com.txtago.bean.Message;
import com.txtago.bean.Report;
import com.txtago.util.HibernateUtil;
import com.txtago.util.TxtagoProperties;

public class ReportService 
{
	private static Logger log = Logger.getLogger(ReportService.class);

	public List<Message> getMessages(int userId,Report report) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			log.debug("days_back = "+report.getDaysBack());
			log.debug("shortcode = "+report.getShortcode());
			log.debug("destination_mdn = "+report.getDestinationMdn());
			log.debug("campaign.id = "+report.getCampaignId());
			
			Date d = new Date();
			d.setDate(d.getDate()-report.getDaysBack());
			
			log.debug("start date = "+d);
			session.beginTransaction();
			Query q = session.createQuery("from Message as msg where msg.userId = ? " + 
						" and msg.campaignId = ? and msg.deliveryDate > ? and msg.shortcode like ? and msg.destinationMdn like ?");
			q.setInteger(0, userId);
			q.setInteger(1, report.getCampaignId());
			q.setDate(2, d);
			q.setParameter(3, report.getShortcode()+"%");
			q.setParameter(4, report.getDestinationMdn()+"%");
		
			List list = q.list();
		    session.getTransaction().commit();

			
			return list;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		

	}
	
	public Report getDailReport(int userId,Report report)
	{
		ArrayList datapoints = new ArrayList();
				
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
					    			
			session.beginTransaction();
			PreparedStatement cs = null;
			cs = session.connection().prepareCall("select DELIVERY_DATE , COUNT(TXG_MESSAGE_ID) from TXG_MESSAGE "+ 
						" where USER_ID = ? and CAMPAIGN_ID = ? and DELIVERY_DATE > ? group by DELIVERY_DATE order by DELIVERY_DATE");
			cs.setInt(1, userId);
			cs.setInt(2, report.getCampaignId());
			Date d = new Date();
			d.setDate(d.getDate()-report.getDaysBack());
			java.sql.Date d2 = new java.sql.Date(d.getTime());
			cs.setDate(3, d2);
			
			ResultSet rs = cs.executeQuery();
			
			while(rs.next())
			{
				String[] dp = {String.valueOf(rs.getDate(1)),String.valueOf(rs.getInt(2))};
				datapoints.add(dp);
			}
			
		    session.getTransaction().commit();
		    		    

		}
		catch(Exception e)
		{
			log.error("",e);
		}
				
		report.setDataPoint(datapoints);
		return report;
	}
	
	public void addMessage(Message msg) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.save(msg);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
}