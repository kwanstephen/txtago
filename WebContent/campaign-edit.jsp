<%@ page language="java" 
		errorPage="index.jsp"
%>
<html>
  <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
  <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
  <%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
  <%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<f:view>
    <head>
      <title>TXTaGO - Mobile Messaging As a Service</title>
		<link href="css/saas-common.css" rel="stylesheet" type="text/css" media="all" />
		<link href="css/saas-default.css" rel="stylesheet" type="text/css" media="all" />
		<script type='text/javascript' src='js/jquery/jquery.js%3Fver=1.4.2'></script>
		<script type='text/javascript' src='js/html5.js%3Fver=3.0'></script>
		<script type='text/javascript' src='js/jquery/ui.core.js%3Fver=1.7.3'></script>
		<script type='text/javascript' src='js/jquery/ui.tabs.js%3Fver=1.7.3'></script>
		<script type='text/javascript' src='js/saas.js%3Fver=3.0'></script>
		<script language="javascript">
		
		</script>
	</head>
	<body class="page">
		<jsp:include page="header.jsp?headerTitle=Campaign"/>
		
		<!-- div start container -->
		<div class="container">
			<div class="center">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
<h:form id="campaignform">
		<div class="col-main">
			<div class="contactForm radius">
				<h3>Campaign Information</h3>
				<div class="wpcf7" id="wpcf7-f1-p18-o1">
					<div class="item">
					<div class="half left">
          				<label>Title</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="title"  size="40"  value="#{campaignBackingBean.formCampaign.title}" required="true" requiredMessage="Title is required"/>
          				</span>
        			</div>
					<div class="half right">
         				<label>Short Code</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="shortcode"  size="40"  value="#{campaignBackingBean.formCampaign.shortcode}" required="true" requiredMessage="Shortcode is required"/>
          				</span>
        			</div>
        			</div>
        			
        			<div class="item">
					<div class="half left">
          				<label>Keyword</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="keyword"  size="40"  value="#{campaignBackingBean.formCampaign.keyword}" required="true" requiredMessage="Keyword is required"/>
          				</span>
        			</div>
					<div class="half right">
         				<label>Description</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="description"  size="40"  value="#{campaignBackingBean.formCampaign.description}" required="false" />
          				</span>
        			</div>
        			</div>
        			
        			<div class="item">
					<div class="half left">
          				<label>Delivery Date</label><span class="wpcf7-form-control-wrap password">
          				<h:inputText id="deliveryDate"  size="40" value="#{campaignBackingBean.formCampaign.deliveryDate}" required="true" requiredMessage="Delivery date is required"/>
          				(yyyy-MM-dd)
          				</span>
        			</div>
					<div class="half right">
         				<label>Delivery Hour</label><span class="wpcf7-form-control-wrap password">
          				<h:selectOneMenu style="width: 135px;" value="#{campaignBackingBean.formCampaign.deliveryHour}">	
				 			<f:selectItem itemValue="0" itemLabel="0" />
				 			<f:selectItem itemValue="1" itemLabel="1" />
				 			<f:selectItem itemValue="2" itemLabel="2" />
				 			<f:selectItem itemValue="3" itemLabel="3" />
				 			<f:selectItem itemValue="4" itemLabel="4" />
				 			<f:selectItem itemValue="5" itemLabel="5" />
				 			<f:selectItem itemValue="6" itemLabel="6" />
				 			<f:selectItem itemValue="7" itemLabel="7" />
				 			<f:selectItem itemValue="8" itemLabel="8" />
				 			<f:selectItem itemValue="9" itemLabel="9" />
				 			<f:selectItem itemValue="10" itemLabel="10" />
				 			<f:selectItem itemValue="11" itemLabel="11" />
				 			<f:selectItem itemValue="12" itemLabel="12" />
				 			<f:selectItem itemValue="13" itemLabel="13" />
				 			<f:selectItem itemValue="14" itemLabel="14" />
				 			<f:selectItem itemValue="15" itemLabel="15" />
				 			<f:selectItem itemValue="16" itemLabel="16" />
				 			<f:selectItem itemValue="17" itemLabel="17" />
				 			<f:selectItem itemValue="18" itemLabel="18" />
				 			<f:selectItem itemValue="19" itemLabel="19" />
				 			<f:selectItem itemValue="20" itemLabel="20" />
				 			<f:selectItem itemValue="21" itemLabel="21" />
				 			<f:selectItem itemValue="22" itemLabel="22" />
				 			<f:selectItem itemValue="23" itemLabel="23" />
				 			
						</h:selectOneMenu>
          				</span>
        			</div>
        			</div>
       				<div class="item">
					<div class="half left">
          				<label>Status</label><span class="wpcf7-form-control-wrap email">
          				<h:selectOneMenu style="width: 135px;" value="#{campaignBackingBean.formCampaign.status}">	
				 			<f:selectItem itemValue="ACTIVE" itemLabel="ACTIVE" />
				 			<f:selectItem itemValue="PROCESSED" itemLabel="PROCESSED" />
				 			<f:selectItem itemValue="CANCELED" itemLabel="CANCELED" />
				 		</h:selectOneMenu>
				 		</span>
        			</div>
					<div class="half right">
         				
        			</div>
        			</div>
					<div class="item">
					<div class="half left">
         				
        			</div>
         			<div class="half right">
         				<h:commandButton value="Save" action="#{campaignBackingBean.saveCampaignAction}"/>
        			</div>
        			</div>
        			<h:inputHidden value="#{campaignBackingBean.formCampaign.id}"/>
        			<h:inputHidden value="#{campaignBackingBean.formCampaign.userId}"/>
					<div class="wpcf7-response-output wpcf7-display-none"></div>
				
				</div>
			</div>
		</div>
		</div>
</h:form>
			
			
			</div>
		</div>	
		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>