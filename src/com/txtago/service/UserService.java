package com.txtago.service;

import com.txtago.util.Constants;

import com.txtago.util.HibernateUtil;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.bean.User;



public class UserService {
	
	private static Logger log = Logger.getLogger(UserService.class);

	public static final int SUCCESS = 1;
	public static final int FAILED = 2;
		
	

	public User login(String userName, String password) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			
			session.beginTransaction();
			Query q = session.createQuery("from User as user where user.email = ? and user.password = ?");
			q.setString(0, userName);
		    q.setString(1, password);
		    User userBean = (User)q.uniqueResult();;
		    session.getTransaction().commit();

			if(userBean!=null)
			{
				userBean.setLoginCode(SUCCESS);
			}
			else
			{
				//userBean.setLoginCode(FAILED);
			}
			return userBean;
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		

	}
	
	public void addUser(User newUser) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			session.beginTransaction();
			session.save(newUser);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
	
	public void updateUser(User newUser) throws Exception{
		Session session = HibernateUtil.getCurrentSession();
		try
		{ 
			//save user
			
			session.beginTransaction();
			session.update(newUser);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			log.error("",e);
			throw e;
		}
		
	}
}
