package com.txtago.controller;

import java.util.Enumeration;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.txtago.bean.Subscription;
import com.txtago.bean.User;
import com.txtago.bean.UserSubscription;
import com.txtago.service.SubscriptionService;
import com.txtago.service.UserService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.util.ChargifyUtil;
import com.txtago.util.Constants;
import com.txtago.util.HibernateUtil;

public class SubscriptionController extends BaseController{
	private static Logger log = Logger.getLogger(SubscriptionController.class);
	
	
	public String deleteAction() {
		try {
			SubscriptionService service = new SubscriptionService();					
			UserSubscription subscription = service.getUserSubscription(this.getUserId());
			if(subscription == null)
			{
				service.deleteUserSubscription(subscription);
				FacesContext.getCurrentInstance().addMessage(null, 
	    				new FacesMessage(FacesMessage.SEVERITY_INFO,"User subscription deleted successfully.",null));
			}
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to delete subscription",null));
		}		
		return "account";
	}	

	
	
	public String homeAction() {
		
		try {
			SubscriptionService service = new SubscriptionService();					
			UserSubscription subscription = service.getUserSubscription(this.getUserId());
			if(subscription == null)
			{
				return "subscribe";
			}
			else
			{
				Subscription product = service.getSubscription(subscription.getSubscriptionId());
				subscription.setSubscription(product);
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
				ValueExpression valueExpression = expressionFactory.createValueExpression(facesContext.getELContext(), "#{userSubscription}", UserSubscription.class);
				valueExpression.setValue(facesContext.getELContext(), subscription);

				return "subscription";
			}
			
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to retrieve subscription",null));
		}
		
		return "subscribe";
	}
	
	public String creditCardAction() {
		
		try {
			ChargifyUtil cutil = ChargifyUtil.createInstance();
			
			SubscriptionService service = new SubscriptionService();					
			UserSubscription subscription = service.getUserSubscription(this.getUserId());
			if(subscription == null)
			{
				return "credit-card";
			}
			else
			{
				String url = cutil.buildUpdatePaymentURI(subscription.getPaidBillingId());
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
				httpResponse.sendRedirect(url);
				return "credit-card";
			}
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to retrieve subscription",null));
		}
		
		return "credit-card";
	}
}
