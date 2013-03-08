<%@ page import="com.txtago.bean.*" 

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

		<jsp:include page="header.jsp?headerTitle=Campaigns"/>
<h:form id="campaignform">
		<h:commandButton value="New Campaign" action="#{campaignBackingBean.addCampaignAction}"/>
			<div class="container">
			<div class="grid">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			<div>
			

        <h:dataTable id="campaignDataTable"
          binding="#{campaignBackingBean.campaignTable}" 
          value="#{campaignBackingBean.campaignList}" 
          var="campaign"
          rows="10"
          styleClass="results">
                    
          <h:column>    
            <f:facet name="header">
              <h:outputText value="ID"/>
            </f:facet>  
            <h:outputText value="#{campaign.id}"/>    
          </h:column>
          
          <h:column>           
            <f:facet name="header">
              <h:outputText value="TITLE"/>
            </f:facet>         
            <h:outputText value="#{campaign.title}"/>       	
          </h:column>
          
          <h:column>           
            <f:facet name="header">
              <h:outputText value="SHORTCODE"/>
            </f:facet>         
            <h:outputText value="#{campaign.shortcode}"/>       	
          </h:column>

          <h:column>           
            <f:facet name="header">
              <h:outputText value="KEYWORD"/>
            </f:facet>            
            <h:outputText value="#{campaign.keyword}"/> 	
          </h:column>
			<h:column>           
            <f:facet name="header">
              <h:outputText value="DATE"/>
            </f:facet>            
            <h:outputText value="#{campaign.deliveryDate}"/> 	
          </h:column>        
          <h:column>           
            <f:facet name="header">
              <h:outputText value="STATUS"/>
            </f:facet>         
            <h:outputText value="#{campaign.status}"/>       	
          </h:column>

          <h:column>
            <f:facet name="header">
              <h:outputText value="EDIT"/>
            </f:facet>              
            <h:commandButton value="Edit" action="#{campaignBackingBean.editCampaignAction}"/>   	
          </h:column>
			<h:column>
            <f:facet name="header">
              <h:outputText value="CONTACTS"/>
            </f:facet>              
            <h:commandButton value="Contacts" action="#{campaignBackingBean.listContactAction}"/>   	
          </h:column>                
			<h:column>
            <f:facet name="header">
              <h:outputText value="CONTENT"/>
            </f:facet>              
            <h:commandButton value="Content" action="#{campaignBackingBean.listContentAction}"/>   	
          </h:column>
          
        </h:dataTable>
        
		<rich:spacer height="5px"/>
		<rich:datascroller align="right" for="campaignDataTable" maxPages="10"/>
		 

</div>		
</div>
</div>

</h:form>	
<!--div.header end -->
			
			

		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>