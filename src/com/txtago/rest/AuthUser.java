package com.txtago.rest;

import org.apache.log4j.Logger;

import com.txtago.bean.User;
import com.txtago.service.UserService;


public class AuthUser {
	
	private static Logger log = Logger.getLogger(AuthUser.class);
	
	public int authUser(String email, String password)
	{
		int uid = -1;
		try
		{
			UserService service = new UserService();
			User userBean = service.login(email, password);
			if(userBean!=null && userBean.getLoginCode() == UserService.SUCCESS) {
				uid = userBean.getId();
			}
		}
		catch(Exception e)
		{
			log.error("",e);
		}
		return uid;
	}
	
	public String notAuthResponse()
	{
		return "{\"response\": {\"code\": \"-1\",\"status\": \"failed\",\"message\": \"Auth Failed\"}}";
	}
	public String errorResponse()
	{
		return "{\"response\": {\"code\": \"-2\",\"status\": \"failed\",\"message\": \"Error Occurred\"}}";
	}
	public String successResponse()
	{
		return "{\"response\": {\"code\": \"1\",\"status\": \"success\",\"message\": \"Updates Committed\"}}";
	}
}    