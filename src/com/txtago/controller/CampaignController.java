package com.txtago.controller;

import java.util.Enumeration;
import java.util.List;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.txtago.bean.Campaign;
import com.txtago.bean.Contact;
import com.txtago.bean.Content;
import com.txtago.bean.Subscription;
import com.txtago.bean.User;
import com.txtago.bean.UserSubscription;
import com.txtago.service.CampaignService;
import com.txtago.service.SubscriptionService;
import com.txtago.service.UserService;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.txtago.util.ChargifyUtil;
import com.txtago.util.Constants;
import com.txtago.util.HibernateUtil;

public class CampaignController extends BaseController{
	private static Logger log = Logger.getLogger(CampaignController.class);
	private UIData campaignTable;
	public UIData getCampaignTable() {
		return campaignTable;
	}

	public void setCampaignTable(UIData campaignTable) {
		this.campaignTable = campaignTable;
	}

	private List<Campaign> campaignList;
	
	public List<Campaign> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<Campaign> campaignList) {
		this.campaignList = campaignList;
	}

	private Campaign formCampaign;
	public Campaign getFormCampaign() {
		return formCampaign;
	}

	public void setFormCampaign(Campaign formCampaign) {
		this.formCampaign = formCampaign;
	}

	private List<Contact> contactList;
	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	private UIData contactTable;
	public UIData getContactTable() {
		return contactTable;
	}

	public void setContactTable(UIData contactTable) {
		this.contactTable = contactTable;
	}

	private Contact formContact;
	
	public Contact getFormContact() {
		return formContact;
	}

	public void setFormContact(Contact formContact) {
		this.formContact = formContact;
	}

	private Content formContent;
	
	public Content getFormContent() {
		return formContent;
	}

	public void setFormContent(Content formContent) {
		this.formContent = formContent;
	}

	public String listCampaignAction() {
		
		try {
			CampaignService service = new CampaignService();
			campaignList = service.getCampaigns(this.getUserId());
			log.debug("list size = "+campaignList.size());
			//campaignTable.setFirst(0);
		} 
		catch (Exception e) {
			log.error("Error occurred while searching campaign", e);
		}

		return "campaign-list";
	}

	public String listContactAction() {
		
		try {
			CampaignService service = new CampaignService();
			formCampaign = (Campaign) this.getCampaignTable().getRowData();
			contactList = service.getContacts(formCampaign.getId());
			log.debug("list size = "+contactList.size());
			
		} 
		catch (Exception e) {
			log.error("Error occurred while searching campaign", e);
		}

		return "contact-list";
	}

	public String addContactAction()
	{
		formContact = new Contact();
		formContact.setCampaignId(formCampaign.getId());
		return "contact-edit";
	}
	
	public String deleteContactAction() {
		
		try {
			CampaignService service = new CampaignService();
			formContact = (Contact) this.getContactTable().getRowData();
			service.deleteContact(formContact);
			listContactAction();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Contact deleted successfully",null));
			
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable delete contact",null));
			return "contact-list";
		}
			
		return "contact-list";
	}	

	public String saveContactAction() {
		
		try {
			
			CampaignService service = new CampaignService();					
			if(this.formContact.getId()==0)
			{
				service.addContact(this.getFormContact());
			}
			else
			{
				service.updateContact(this.getFormContact());
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Contact save successfully",null));
			listContactAction();
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to save contact",null));
			return "contact-edit";
		}
		
		return "contact-list";
	}
	
	public String homeAction() {
		
		return listCampaignAction();
	}
	public String editCampaignAction() {
		formCampaign = (Campaign) this.getCampaignTable().getRowData();
		return "campaign-edit";
	}
	
	public String addCampaignAction()
	{
		formCampaign = new Campaign();
		return "campaign-edit";
	}
	
	public String saveCampaignAction() {
		
		try {
			
			CampaignService service = new CampaignService();					
			if(this.formCampaign.getId()==0)
			{
				service.addCampaign(this.getFormCampaign());
			}
			else
			{
				service.updateCampaign(this.getFormCampaign());
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Campaign save successfully",null));
			
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to save campaign",null));
			return "campaign-edit";
		}
		
		return "success";
	}

	public String listContentAction() {
		
		try {
			CampaignService service = new CampaignService();
			formCampaign = (Campaign) this.getCampaignTable().getRowData();
			formContent = service.getContentByCampaign(formCampaign.getId());
			if(formContent==null)
				formContent = new Content();
			
			if(this.formContent.getCampaignId() == 0)
			{
				formContent.setCampaignId(formCampaign.getId());
			}
			log.debug("content id "+formContent.getId() + " cam id " + formContent.getCampaignId());
						
		} 
		catch (Exception e) {
			log.error("Error occurred while searching campaign", e);
		}

		return "content-edit";
	}
	
	public String saveContentAction() {
		
		try {
			
			CampaignService service = new CampaignService();
			log.debug("content id "+formContent.getId() + " cam id " + formContent.getCampaignId());
			if(this.formContent.getCampaignId() == 0)
			{
				formContent.setCampaignId(formCampaign.getId());
			}
			log.debug("content id "+formContent.getId() + " cam id " + formContent.getCampaignId());
			
			if(this.formContent.getId()==0)
			{
				service.addContent(this.getFormContent());
			}
			else
			{
				service.updateContent(this.getFormContent());
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Content save successfully",null));
			
		} 
		catch (Exception e) {
			log.error("", e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to save content",null));
			return "content-edit";
		}
		
		return "success";
	}
}
