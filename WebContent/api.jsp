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
		<jsp:include page="header.jsp?headerTitle=REST_API"/>
		
		<!-- div start container -->
		<div class="container">
			<div class="center">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			
			
<h:form id="login">
		<div class="col-main">
			<div class="contactForm radius">
				<h3>Campaign Management</h3>

        			<div class="item">
					<div class="half left">
          				<label>List Campaign</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/campaign.list
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				
          				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
          				"campaigns": {<br/>
							"campaign": {<br/>
							"campaign.id": "11",<br/>
							"campaign.title": "my campaign",<br/>
							},<br/>
							"campaign": {<br/>
							"campaign.id": "12",<br/>
							"campaign.title": "my campaign 2",<br/>
							}<br/>
						}<br/>
						}<br/>
        			</div>
        			
        			<div class="item">
					<div class="half left">
          				<label>Create/Update Campaign</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/campaign.update
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				campaign.id<br/>
          				campaign.shortcode<br/>
          				campaign.keyword<br/>
          				campaign.title<br/>
          				campaign.description<br/>
          				campaign.delivery_date<br/>
          				campaign.delivery_hour<br/>
          				campaign.status<br/>
          				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
							"response": {<br/>
							"code": "1",<br/>
							"status": "success",<br/>
							"message": "API response message"<br/>
							}<br/>
						}<br/>
        			</div>					
        			</div>
        			
        			<div class="item">
					<div class="half left">
          				<label>List Contact</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/contact.list
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				campaign.id<br/>
          				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
          				"contacts": {<br/>
							"contact": {<br/>
							"contact.id": "11",<br/>
							"contact.phone": "+15101234567",<br/>
							},<br/>
							"contact": {<br/>
							"contact.id": "12",<br/>
							"contact.phone": "+19251234567",<br/>
							}<br/>
						}<br/>
						}<br/>
        			</div>        			
        			</div>
        			
        			<div class="item">
					<div class="half left">
          				<label>Create/Delete Contact</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/contact.create
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				contact.phone<br/>
          				campaign.id<br/>         				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
							"response": {<br/>
							"code": "1",<br/>
							"status": "success",<br/>
							"message": "API response message"<br/>
							}<br/>
						}<br/>
						<br/>
          				<br/>
						URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/contact.delete
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				contact.id<br/>         				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
							"response": {<br/>
							"code": "1",<br/>
							"status": "success",<br/>
							"message": "API response message"<br/>
							}<br/>
						}<br/>
        			</div>
					
        			</div>  
        			
        			<div class="item">
					<div class="half left">
          				<label>Create/Update Content</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/content.update
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				content.id<br/>
          				campaign.id<br/>
          				content.name<br/>
          				content.content_url<br/>
          				content.content_type<br/>
          				content.content_url<br/>
          				content.content_text<br/>
          				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
							"response": {<br/>
							"code": "1",<br/>
							"status": "success",<br/>
							"message": "API response message"<br/>
							}<br/>
						}<br/>
        			</div>
					</div>
					
        			<div class="item">
					<div class="half left">
          				<label>Send Message</label>
        			</div>
					
        			       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/campaign.send
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				campaign.id<br/>         				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
							"response": {<br/>
							"code": "1",<br/>
							"status": "success",<br/>
							"message": "API response message"<br/>
							}<br/>
						}<br/>
						</div>
					
        			</div>
        								
        			</div>     
					<div class="item">
         				
        			</div>
        			
					<div class="wpcf7-response-output wpcf7-display-none"></div>
				
				</div>
			</div>
			<div class="contactForm radius">
				<h3>Reports</h3>
        			
        			<div class="item">
					<div class="half left">
          				<label>Find Message</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
					<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/report.find
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/>
          				campaign.id<br/>  
          				report.shortcode<br/>  
          				report.destination_mdn<br/> 
          				report.days_back<br/>        				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
          				"reports": {<br/>
							"report": {<br/>
							"message.id": "1111",<br/>
							"message.shortcode": "+19000",<br/>
							"message.destination_mdn": "+15101234567",<br/>
							"message.delivery_date": "10/31/2013",<br/>
							"message.status": "PROCESSED"<br/>
							},<br/>
							"report": {<br/>
							"message.id": "1112",<br/>
							"message.shortcode": "+19000",<br/>
							"message.destination_mdn": "+15101234567",<br/>
							"message.delivery_date": "10/31/2013",<br/>
							"message.status": "PROCESSED"<br/>
							}<br/>
						}<br/>
						}<br/>
						</div>
										
        			</div>

        			<div class="item">
					<div class="half left">
          				<label>Daily Report</label>
        			</div>
					
        			</div>
       				
       				<div class="item">
										<div class="half left">
          				URL: http://<%out.write(request.getServerName()+":"+request.getServerPort()); %>/rest/report.daily
          				<br/>
          				<br/>
          				<b>Request Parameters</b><br/>
          				auth.email<br/>
          				auth.password<br/> 
          				campaign.id<br/>  
          				report.days_back<br/>        				
          				<br/>
          				<br/>
          				<b>Response Message</b><br/>
          				{<br/>
          				"reports": {<br/>
							"report": {<br/>
							"report.date": "10/30/2013",<br/>
							"report.total": "19000",<br/>
							},<br/>
							"report": {<br/>
							"report.date": "10/31/2013",<br/>
							"report.total": "19000",<br/>
							}<br/>
						}<br/>
						}<br/>
						</div>
					
        			</div>
        			        			
					<div class="item">
         				
        			</div>
        			
					<div class="wpcf7-response-output wpcf7-display-none"></div>
				
				</div>
			</div>
		</div>
</h:form>
			
			
			</div>
		</div>	


<!--div.header end -->
			
			

		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>