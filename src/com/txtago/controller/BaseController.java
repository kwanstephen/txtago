package com.txtago.controller;


import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.txtago.bean.User;
import com.txtago.util.Constants;

import org.apache.log4j.Logger;



public class BaseController implements Serializable{
		
	private static Logger log = Logger.getLogger(BaseController.class);
	

    public int getUserId()
    {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest httpRequest = (HttpServletRequest)externalContext.getRequest();
		
		User userBean = (User)httpRequest.getSession().getAttribute("loginUser");
		return userBean.getId();
    }
    public User getLoggedInUser()
    {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest httpRequest = (HttpServletRequest)externalContext.getRequest();
		
		User userBean = (User)httpRequest.getSession().getAttribute("loginUser");
		return userBean;
    }    

	public String cancelAction() {
    	return Constants.CANCEL;
    }
}
