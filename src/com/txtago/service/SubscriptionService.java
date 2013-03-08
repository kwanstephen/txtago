package com.txtago.service;

import java.util.List;

import com.txtago.util.ChargifyUtil;
import com.txtago.util.Constants;

import com.txtago.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.bean.Campaign;
import com.txtago.bean.Subscription;
import com.txtago.bean.User;
import com.txtago.bean.UserSubscription;



public class SubscriptionService {
	
	private static Logger log = Logger.getLogger(SubscriptionService.class);

	public List<UserSubscription> getAllUserSubscriptions() throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from UserSubscription as sub");
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

	public UserSubscription getUserSubscription(int userId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from UserSubscription as sub where sub.userId = ?");
			q.setInteger(0, userId);
			UserSubscription subscription = (UserSubscription)q.uniqueResult();
		    session.getTransaction().commit();

			
			return subscription;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}

	public Subscription getSubscription(int subId) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			session.beginTransaction();
			Query q = session.createQuery("from Subscription as sub where sub.id = ?");
			q.setInteger(0, subId);
			Subscription subscription = (Subscription)q.uniqueResult();
		    session.getTransaction().commit();

			
			return subscription;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void addUserSubscription(UserSubscription newSub) throws Exception{
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
	
	public void updateUserSubscription(UserSubscription newSub) throws Exception{
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
	
	public void deleteUserSubscription(UserSubscription newSub) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		
		try
		{ 
			ChargifyUtil cutil = ChargifyUtil.createInstance();
			cutil.cancelSubscriptionNow(newSub.getPaidBillingId(), null);
			
			//save user
			session.beginTransaction();
			session.delete(newSub);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
}
