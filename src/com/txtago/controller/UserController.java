package com.txtago.controller;

import java.util.Enumeration;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


import com.txtago.bean.User;
import com.txtago.service.UserService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.util.Constants;
import com.txtago.util.HibernateUtil;

public class UserController extends BaseController{
	private static Logger log = Logger.getLogger(UserController.class);
	
	private User formUser = new User();
		
    public User getFormUser() {
		return formUser;
	}

	public void setFormUser(User formUser) {
		this.formUser = formUser;
	}

	public String cancelAction() {
    	return Constants.CANCEL;
    }
    
	public String addAction() {
		
		try {
			UserService service = new UserService();
			service.addUser(formUser);
						
    		FacesContext.getCurrentInstance().addMessage(null, 
    				new FacesMessage(FacesMessage.SEVERITY_INFO,"User added successfully. Please login.",null));
    		return Constants.SUCCESS;
			
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to add user",null));
		}
		
		return Constants.FAIL;
	}	
	
	public String updateAction() {
		
		try {
			formUser.setFirstName(this.getLoggedInUser().getFirstName());
			formUser.setLastName(this.getLoggedInUser().getLastName());		
    		formUser.setPassword(this.getLoggedInUser().getPassword());
    		formUser.setEmail(this.getLoggedInUser().getEmail());
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to update user",null));
		}
		
		return "account-update";
	}	
	
	public String updateProcessAction() {
		
		try {
			UserService service = new UserService();
			formUser.setId(this.getUserId());
			service.updateUser(formUser);
						
    		FacesContext.getCurrentInstance().addMessage(null, 
    				new FacesMessage(FacesMessage.SEVERITY_INFO,"User updated successfully.",null));
    		return Constants.SUCCESS;
			
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to update user",null));
		}
		
		return Constants.FAIL;
	}
}
