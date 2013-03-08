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
		<jsp:include page="header.jsp?headerTitle=Tour"/>
		<!-- div start container -->
		<div class="container">
			<div class="center">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			
			
		<div class="sidebar left">
			<div class="submenu radius">
			<h:form id="mysidebar">
				<ul>
					<li><a href="#"><img src="images/onebit/03/PNG/bonus48x48_20.png" alt="Performance" />Performance</a></li>
					<li><a href="#"><img src="images/onebit/02/PNG/onebit_08.png" alt="Features" />Features</a></li>
					<li><a href="#"><img src="images/onebit/02/PNG/onebit_16.png" alt="Analytics" />Analytics</a></li>
					<li><a href="#"><img src="images/onebit/03/PNG/bonus48x48_10.png" alt="Service" />Service</a></li>
					
				</ul>
			</h:form>
			</div>
		</div>			
<div class="content">
	<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			<div>
				<h3>What We Offer</h3>
				
				<p>
					TXTaGO, the text-as-you-go service, allows you to pay-as-you-go for mobile messages.  
				We provide the most reliable service in the industry.  Our customer support is there to help 
				you every step of the way.  Take TXTaGO for a spin FREE!!!
				</p>
				<ul class="clear">
					<li class="left">
						<h4>
							<img src="images/i_global.png" alt="" class="v-bt" />Performance	
						</h4>
						<p>We provide the highest throughput in the business.  We deliver up to 100 million messages per day.  We can scale up to your needs.  It's all seamless to you.</p>
					</li>
					<li class="right">
						<h4>
							<img src="images/i_download.png" alt="" class="v-bt" />Features	
						</h4>
						<p>We offer shortcode setup and campaign management all from the a self-service Web interface.  It's intuitive to use and convenient. </p>
					</li>
					<li class="left">
						<h4>
							<img src="images/i_stock.png" alt="" class="v-bt" />Analytics
						</h4>
						<p>Our reports and analytics provide can provide you will insight into your business.  What is the return on messages sent?  What is the viewing rate?  </p>
					</li>
					<li class="right">
						<h4>
							<img src="images/i_stick.png" alt="" class="v-bt" />Service	
						</h4>
						<p>We provide the highest customer service in the industry.  Our staff are available 24x7.  </p>
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