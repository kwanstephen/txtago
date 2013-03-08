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
		<jsp:include page="header.jsp?headerTitle=Contact"/>
		
		<!-- div start container -->
		<div class="container">
			<div class="center">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
<h:form id="contactform">
		<div class="col-main">
			<div class="contactForm radius">
				<h3>Contact Information</h3>
				<div class="wpcf7" id="wpcf7-f1-p18-o1">
					<div class="item">
					<div class="half left">
          				<label>Phone</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="phone"  size="40"  value="#{campaignBackingBean.formContact.phone}" required="true" requiredMessage="Phone is required"/>
          				</span>
        			</div>
					<div class="half right">
         				
        			</div>
        			</div>
        			
        			
					<div class="item">
					<div class="half left">
         				
        			</div>
         			<div class="half right">
         				<h:commandButton value="Save" action="#{campaignBackingBean.saveContactAction}"/>
        			</div>
        			</div>
        			<h:inputHidden value="#{campaignBackingBean.formContact.id}"/>
        			<h:inputHidden value="#{campaignBackingBean.formContact.campaignId}"/>
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