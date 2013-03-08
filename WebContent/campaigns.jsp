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
		<jsp:include page="header.jsp?headerTitle=Campaigns"/>
		<!-- div start container -->
		<div class="container">
			<div class="center">
			
		<div class="sidebar left">
			<div class="submenu radius">
			<h:form id="mysidebar">
				<ul>
					<li><h:commandLink action="#{campaignBackingBean.homeAction}"><img src="images/onebit/02/PNG/onebit_07.png" alt="" />Campaign</h:commandLink></li>
					
				</ul>
			</h:form>
			</div>
		</div>			
<div class="content">
	<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			<div>
				<h3>Manage My Campaigns</h3>
				
				<p>
					You can manage your campaign from this section.  Schedule your campaigns and provision your keywords and short.
				</p>
				<ul class="clear">
					<li class="left">
						<h4>
							<img src="images/i_global.png" alt="Condimentum ornare" class="v-bt" />Update Contacts	
						</h4>
						<p>Update your contacts for the campaign</p>
					</li>
					<li class="right">
						<h4>
							<img src="images/i_download.png" alt="Fusce velit tinicdunt" class="v-bt" />Manage My Content	
						</h4>
						<p>Configure the content you want sent with this campaign.</p>
					</li>
					
				</ul>
			</div>
</div>			
			
			</div>
		</div>	
		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>