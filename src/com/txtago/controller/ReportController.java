package com.txtago.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.txtago.bean.Campaign;
import com.txtago.bean.Message;
import com.txtago.bean.Report;
import com.txtago.bean.Subscription;
import com.txtago.bean.User;
import com.txtago.bean.UserSubscription;
import com.txtago.service.CampaignService;
import com.txtago.service.ReportService;
import com.txtago.service.SubscriptionService;
import com.txtago.service.UserService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.util.ChargifyUtil;
import com.txtago.util.Constants;
import com.txtago.util.HibernateUtil;

public class ReportController extends BaseController{
	private static Logger log = Logger.getLogger(ReportController.class);
	
	private List<Campaign> campaignList;
	
		
	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}

	private UIData messageTable;
	public UIData getMessageTable() {
		return messageTable;
	}

	public void setMessageTable(UIData messageTable) {
		this.messageTable = messageTable;
	}

	private List<Message> messageList;
	
	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	private Report formReport = new Report();
	
	public Report getFormReport() {
		return formReport;
	}

	public void setFormReport(Report formReport) {
		this.formReport = formReport;
	}

	public List getCampaignsList() {
		ArrayList selectmenu = new ArrayList();
		try
		{
		CampaignService service = new CampaignService();
		List l = service.getCampaigns(this.getUserId());
		
		for(int i=0;i<l.size();i++)
		{
			Campaign p = (Campaign)l.get(i);
			SelectItem item = new SelectItem(String.valueOf(p.getId()),p.getTitle());
			selectmenu.add(item);
		}
		}
		catch(Exception e)
		{
			
		}
		return selectmenu;
	}	
	
	public String findMessagesAction() {
		
		return "report-find";
	}

	public String dofindMessagesAction() {
		try {
			ReportService service = new ReportService();
			messageList = service.getMessages(this.getUserId(),this.formReport);
			log.debug("list size = "+messageList.size());
			
		} 
		catch (Exception e) {
			log.error("Error occurred while searching campaign", e);
		}	
		return "report-find";
	}
	
	public String dailyAction() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletRequest httpRequest = (HttpServletRequest)externalContext.getRequest();
		httpRequest.setAttribute("reportBean",formReport);	
		
		return "report-daily";
	}

	

	public String doDailyAction() {
		try {
			ReportService service = new ReportService();
			formReport = service.getDailReport(this.getUserId(),this.formReport);
			log.debug("list size = "+formReport.getDataPoint().size());
			
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest httpRequest = (HttpServletRequest)externalContext.getRequest();
			httpRequest.setAttribute("reportBean",formReport);	
		} 
		catch (Exception e) {
			log.error("Error occurred while searching campaign", e);
		}	
		return "report-daily";
	}
	
	
}
