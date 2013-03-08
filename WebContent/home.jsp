<%@ page import="com.txtago.scheduler.*" 
		language="java" 
		errorPage="index.jsp"
%>
<%
TaskScheduler task = new TaskScheduler();
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
	<body class="home">
		<jsp:include page="header.jsp?headerTitle= "/>
		<!-- div start container -->
		<div class="container">
			<div class="center">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>

		<!-- div start proms -->
		<div class="proms">
			<div class="left">
				<h2>Our Service is Amazing!</h2>
				<p>TXTaGO, the text-as-you-go service, allows you to pay-as-you-go for mobile messages.  
				We provide the most reliable service in the industry.  Our customer support is there to help 
				you every step of the way.  Take TXTaGO for a spin FREE!!!</p>
		<br/><br/>
				<a class="radius button" href="plans.jsf">See Plans &amp; Pricing</a>
			</div>
			<div class="right">
				<p id="prom1">
<img src="images/service1.png" alt="Dashboard" />
<img src="images/service3.png" alt="Dashboard" />
<p/>

<a class="radius button" href="signup.jsf">Try Us Free!</a>
				
			</div>
		</div>
		<!-- div end proms -->
		<!-- div start features -->
		<div class="features">
			<ul>		
				<li>
					<div class="icon">
						<img src="images/onebit/03/PNG/bonus48x48_20.png" alt="Performance" />
					</div>
					<div class="content">
						<h3>High Performance</h3>
						<p>We provide the highest throughput in the business.  We deliver up to 100 million messages per day.  We can scale up to your needs.  It's all seamless to you.</p>
					</div>
				</li>
				<li>
					<div class="icon">
						<img src="images/onebit/02/PNG/onebit_08.png" alt="Features" />
					</div>
					<div class="content">
						<h3>Rich Features</h3>
						<p>We offer shortcode setup and campaign management all from the a self-service Web interface.  It's intuitive to use and convenient.  </p>
					</div>
				</li>
				<li>
					<div class="icon">
						<img src="images/onebit/02/PNG/onebit_16.png" alt="Analytics" />
					</div>
					<div class="content">
						<h3>Insightful Analytics</h3>
						<p>Our reports and analytics provide can provide you will insight into your business.  What is the return on messages sent?  What is the viewing rate?  </p>
					</div>
				</li>
				<li>
					<div class="icon">
						<img src="images/onebit/03/PNG/bonus48x48_10.png" alt="Service" />
					</div>
					<div class="content">
						<h3>Superior Service</h3>
						<p>We provide the highest customer service in the industry.  Our staff are available 24x7.  </p>
					</div>
				</li>	
			</ul>
		</div>
		<!-- div end features -->
		<!-- div start testimonials -->
		<div class="testimonials radius">
			<div>		
				<h3>What Our Customers Say!</h3>
				<ul>
					<li>
						<div class="avatar"><img size="50" src="images/obama.jpeg" alt="" /></div>
						<div class="testiContent">
							<div class="radius">
								<span class="arrow"><img src="images/bg-arrow.png" alt="" /></span>
								<p>I am the President of the United States and I love TXTaGO!  I use it heavily to communicate with my cabinet.
								</p>
								<p class="a-right"><em>Obama, Washington, D.C.</em></p>
							</div>
						</div>
					</li>
				</ul>	
			</div>
		</div>
		<!-- div end testimonials -->
		<!-- div start free trial -->
		<div class="free-trial radius">
			<h3>Get a Free Account</h3>
			<a class="radius button" href="signup.jsf">Sign Up Now!</a>
			<p>Takes 4 seconds!</p>
		</div>
		<!-- div end free trial -->

			
			
			</div>
		</div>	
		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>