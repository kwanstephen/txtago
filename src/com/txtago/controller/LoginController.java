package com.txtago.controller;

import java.io.IOException;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.txtago.bean.User;
import com.txtago.service.UserService;

import com.txtago.util.ChargifyCustomer;
import com.txtago.util.ChargifySubscription;
import com.txtago.util.ChargifyUtil;
import com.txtago.util.Constants;


public class LoginController {
	
	private static Logger log = Logger.getLogger(LoginController.class);
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String loginAction() {
		
		try {
						
			UserService service = new UserService();
			User userBean = service.login(username, password);
			
			if(userBean!=null && userBean.getLoginCode() == UserService.SUCCESS) {
				
				userBean.setLoggedIn(true);
				FacesContext facesContext = FacesContext.getCurrentInstance();
				ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
				ValueExpression valueExpression = expressionFactory.createValueExpression(facesContext.getELContext(), "#{user}", User.class);
				valueExpression.setValue(facesContext.getELContext(), userBean);
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				HttpServletRequest httpRequest = (HttpServletRequest)externalContext.getRequest();
				httpRequest.getSession().setAttribute("loginUser",userBean);
				return Constants.SUCCESS;
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Invalid Login",null));
			}
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to log into the system",null));
		}
		
		return Constants.FAIL;
	}
	
	/**
	 * 
	 * @return
	 */
	public String logoutAction() throws IOException {
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession)externalContext.getSession(false);
		session.invalidate();
		HttpServletResponse httpResponse = (HttpServletResponse)externalContext.getResponse();
		httpResponse.sendRedirect("home.jsf");
		return "logout";
	}
}
