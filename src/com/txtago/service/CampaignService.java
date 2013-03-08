package com.txtago.service;

import com.txtago.util.ChargifyUtil;
import com.txtago.util.Constants;

import com.txtago.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.bean.*;

import java.util.*;

public class CampaignService {
	
	private static Logger log = Logger.getLogger(SubscriptionService.class);

		

	public List<Campaign> getCampaigns(int userId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			
			session.beginTransaction();
			Query q = session.createQuery("from Campaign as cam where cam.userId = ?");
			q.setInteger(0, userId);
			List list = q.list();
		    session.getTransaction().commit();

			if(list == null)
				list = new ArrayList();
			
			return list;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		

	}

	public List<Campaign> getCampaignsByStatus(String status) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			
			session.beginTransaction();
			Query q = session.createQuery("from Campaign as cam where cam.status = ?");
			q.setString(0, status);
			List list = q.list();
		    session.getTransaction().commit();

			if(list == null)
				list = new ArrayList();
			
			return list;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		

	}
	
	public Campaign getCampaign(int camId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from Campaign as sub where sub.id = ?");
			q.setInteger(0, camId);
			Campaign campaign = (Campaign)q.uniqueResult();;
		    session.getTransaction().commit();

			
			return campaign;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void addCampaign(Campaign newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.save(newSub);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void updateCampaign(Campaign newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.update(newSub);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public List<Contact> getContacts(int camId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			
			session.beginTransaction();
			Query q = session.createQuery("from Contact as cam where cam.campaignId = ?");
			q.setInteger(0, camId);
			List list = q.list();
		    session.getTransaction().commit();

		    if(list == null)
		    	list = new ArrayList();
		    
			return list;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		

	}

	public void deleteContact(Contact contact) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			
			session.beginTransaction();
			session.delete(contact);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public Contact getContact(int contactId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from Contact as sub where sub.id = ?");
			q.setInteger(0, contactId);
			Contact contact = (Contact)q.uniqueResult();;
		    session.getTransaction().commit();

			
			return contact;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void addContact(Contact newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.save(newSub);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void updateContact(Contact newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.update(newSub);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}	

	public Campaign getCampaignByShortCodeKeyword(String shortcode,String keyword) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from Campaign as campaign where campaign.shortcode = ? and campaign.keyword =?");
			q.setString(0, shortcode);
			q.setString(1, keyword);
			Campaign campaign = (Campaign)q.uniqueResult();;
		    session.getTransaction().commit();

			
			return campaign;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	
	public Content getContentByCampaign(int campaignId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from Content as content where content.campaignId = ?");
			q.setInteger(0, campaignId);
			Content contact = (Content)q.uniqueResult();;
		    session.getTransaction().commit();

			
			return contact;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}

	public Content getContent(int contentId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from Content as content where content.id = ?");
			q.setInteger(0, contentId);
			Content contact = (Content)q.uniqueResult();;
		    session.getTransaction().commit();

			
			return contact;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void addContent(Content newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.save(newSub);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void updateContent(Content newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.update(newSub);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
}
