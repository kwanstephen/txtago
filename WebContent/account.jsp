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
		<jsp:include page="header.jsp?headerTitle=Account"/>
		<!-- div start container -->
		<div class="container">
			<div class="center">
			
		<div class="sidebar left">
			<div class="submenu radius">
			<h:form id="mysidebar">
				<ul>
					<li><h:commandLink action="#{addUserBackingBean.updateAction}"><img src="images/onebit/01/PNG/onebit_18.png" alt="" />Account</h:commandLink></li>
					<li><h:commandLink action="#{subscriptionBackingBean.homeAction}"><img src="images/onebit/02/PNG/onebit_26.png" alt="" />Subscription</h:commandLink></li>
					<li><h:commandLink action="#{subscriptionBackingBean.creditCardAction}"><img src="images/onebit/03/PNG/bonus48x48_05.png" alt="" />Credit Card</h:commandLink></li>
					
				</ul>
			</h:form>
			</div>
		</div>			
<div class="content">
	<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			<div>
				<h3>Manage My Account</h3>
				
				<p>
					You can manage your account from this section.  Update your user information. Update your subscription.  Update your credit card.
				</p>
				<ul class="clear">
					<li class="left">
						<h4>
							<img src="images/i_global.png" alt="Condimentum ornare" class="v-bt" />Update User Account	
						</h4>
						<p>Update your email and password.  Keep her information safe.</p>
					</li>
					<li class="right">
						<h4>
							<img src="images/i_download.png" alt="Fusce velit tinicdunt" class="v-bt" />Manage My Subscription	
						</h4>
						<p>Subscribe to a messaging plan.  Check out how many messages you've used and how many more you have left.</p>
					</li>
					<li class="left">
						<h4>
							<img src="images/i_stock.png" alt="Curabitur arcu nulla" class="v-bt" />Update Credit Card
						</h4>
						<p>Our credit card processing is PCI compliant.  Rest assure your information is safe with us.</p>
					</li>
					<li class="right">
						<h4>
							<img src="images/i_stick.png" alt="Volutpat vestibulum hendrerit" class="v-bt" />Security	
						</h4>
						<p>Your information and privacy is very important to us.  We take security very seriously.  </p>
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