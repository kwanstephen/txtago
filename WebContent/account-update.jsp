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
		<jsp:include page="header.jsp?headerTitle=Update_Account"/>
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
			<div>
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
<h:form id="login">
		<div class="col-main">
			<div class="contactForm radius">
				<h3>Update Account</h3>
				<div class="wpcf7" id="wpcf7-f1-p18-o1">
					<div class="item">
					<div class="half left">
          				<label>First Name</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="firstName"  size="40"  value="#{addUserBackingBean.formUser.firstName}" required="true" requiredMessage="First Name is required"/>
          				</span>
        			</div>
					<div class="half right">
         				<label>Last Name</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="lastName"  size="40"  value="#{addUserBackingBean.formUser.lastName}" required="true" requiredMessage="Last Name is required"/>
          				</span>
        			</div>
        			</div>
        			
        			<div class="item">				
					<div class="item">
					<div class="half left">
          				<label>Email</label><span class="wpcf7-form-control-wrap email">
          				<h:inputText id="username"  size="40"  value="#{addUserBackingBean.formUser.username}" required="true" requiredMessage="Email is required"/>
          				</span>
        			</div>
					<div class="half right">
         				
        			</div>
        			</div>
        			
        			<div class="item">
					<div class="half left">
          				<label>Password</label><span class="wpcf7-form-control-wrap password">
          				<h:inputSecret id="password"  size="40" value="#{addUserBackingBean.formUser.password}" required="true" requiredMessage="Password is required"/>
          				</span>
        			</div>
					<div class="half right">
         				
        			</div>
        			</div>
       
					<div class="item">
         				<h:commandButton value="Update" action="#{addUserBackingBean.updateProcessAction}"/>
        			</div>
        			
					<div class="wpcf7-response-output wpcf7-display-none"></div>
				
				</div>
			</div>
		</div>
		</div>
</h:form>
				</div>
		</div>			
			</div>
		</div>	
		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>