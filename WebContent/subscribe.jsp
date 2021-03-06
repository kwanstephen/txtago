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
	<body class="page plans">
		<jsp:include page="header.jsp?headerTitle=Subscribe"/>
		
			<div class="center">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>


<div class="grid col5">
					<div>
<% 
User loginUser = ((User)request.getSession().getAttribute("loginUser"));
String user_param = "?first_name="+loginUser.getFirstName()+
						"&last_name="+loginUser.getLastName()+
						"&email="+loginUser.getEmail();
						//"&reference="+loginUser.getId();
%>						

						<section>
							<header>
								<hgroup class="top">
									<h1>Free </h1>
								</hgroup>
								<hgroup class="price">
									<h2><span class="style1">$</span><span class="style2">0</span><span class="style3">Monthly</span></h2>
								</hgroup>
							</header>
							<footer>
								<ul>
									<li>
										<strong>Support </strong>Community	
									</li>
									<li>
										<strong>500 </strong>Messages		
									</li>
									<li>
										<strong>Text </strong>Yes	
									</li>
									<li>
										<strong>Image </strong>Yes	
									</li>
									<li>
										<strong>Video </strong>Yes	
									</li>
									<li class="last"><a class="btn" 
									href="https://txtago.chargify.com/h/3283689/subscriptions/new<%= user_param %>"
									>Select Plan</a></li>
								</ul>
							</footer>
						</section>

						<section>
							<header>
								<hgroup class="top">
									<h1>Small </h1>
								</hgroup>
								<hgroup class="price">
									<h2><span class="style1">$</span><span class="style2">100</span><span class="style3">Monthly</span></h2>
								</hgroup>
							</header>
							<footer>
								<ul>
									<li>
										<strong>Support </strong>Email	
									</li>
									<li>
										<strong>10,000 </strong>Messages
										<div class="tooltip">
											<div>
												<h3>Price Per Messages</h3>
												<p>1 cent/messages</p>
											</div>
										</div>				
									</li>
									<li>
										<strong>Text </strong>Yes	
									</li>
									<li>
										<strong>Image </strong>Yes	
									</li>
									<li>
										<strong>Video </strong>Yes	
									</li>
									<li class="last"><a class="btn" 
									href="https://txtago.chargify.com/h/3283690/subscriptions/new<%= user_param %>"
									>Select Plan</a></li>
								</ul>
							</footer>
						</section>

						<section>
							<header>
								<hgroup class="top">
									<h1>Medium </h1>
								</hgroup>
								<hgroup class="price">
									<h2><span class="style1">$</span><span class="style2">500</span><span class="style3">Monthly</span></h2>
								</hgroup>
							</header>
							<footer>
								<ul>
									<li>
										<strong>Support </strong>Standard	
									</li>
									<li>
										<strong>100,000 </strong>Messages
										<div class="tooltip">
											<div>
												<h3>Price Per Messages</h3>
												<p>.5 cent/messages</p>
											</div>
										</div>		
									</li>
									<li>
										<strong>Text </strong>Yes	
									</li>
									<li>
										<strong>Image </strong>Yes	
									</li>
									<li>
										<strong>Video </strong>Yes	
									</li>
									<li class="last"><a class="btn" 
									href="https://txtago.chargify.com/h/3283691/subscriptions/new<%= user_param %>"
									>Select Plan</a></li>
								</ul>
							</footer>
						</section>
						
						<section class="on">
							<header>
								<hgroup class="top">
									<h1>Large</h1>
								</hgroup>
								<hgroup class="price">
									
									<h2><span class="style1">$</span><span class="style2">2500</span><span class="style3">Monthly</span></h2>
								</hgroup>
							</header>
							<footer>
								<ul>
									<li>
										<strong>Support </strong>Premium	
									</li>
									<li>
										<strong>1,000,000 </strong>Messages
										<div class="tooltip">
											<div>
												<h3>Price Per Messages</h3>
												<p>.25 cent/messages</p>
											</div>
										</div>		
									</li>
									<li>
										<strong>Text </strong>Yes	
									</li>
									<li>
										<strong>Image </strong>Yes	
									</li>
									<li>
										<strong>Video </strong>Yes	
									</li>
									<li class="last"><a class="btn" 
										href="https://txtago.chargify.com/h/3283804/subscriptions/new<%= user_param %>"
										>Select Plan</a></li>
								</ul>
							</footer>
						</section>

						
					</div>
				</div>		
			</div>


<!--div.header end -->
			
			

		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>