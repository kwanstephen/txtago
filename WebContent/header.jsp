
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>

<div class="header">
	<div>
    	<div>
			<div class="center">
				<h1 class="logo">
<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
<a href="home.jsf"><font color="white">Messaging Service</font></a></h1>
				<div class="header-right">
					<div class="topnav">
						<ul id="menu-top-links" class="menu">
							<li class="menu-item"><a href="#">About</a></li>
							<li class="menu-item"><a href="api.jsf">API</a></li>
							<li class="menu-item"><a href="#">Help</a></li>
							<li class="menu-item"><a href="#">Contact Us</a></li>
						</ul>
					</div>
					<div class="nav">
					<% 
						if(request.getSession().getAttribute("loginUser")==null)
						{
					%>
						<ul id="menu-main-nav" class="menu">
							<li class="menu-item"><a href="tour.jsf">Tour</a></li>
							<li class="menu-item"><a href="plans.jsf">Plans &#038; Pricing</a></li>
							<li class="menu-item"><a href="signup.jsf">Sign Up</a></li>
							<li class="menu-item"><a href="login.jsf">Login</a></li>
						</ul>
					<%
						}else{
					%>
					<h:form id="mymenus">
						<ul id="menu-main-nav" class="menu">
							<li class="menu-item"><a href="account.jsf">Account</a></li>
							<li class="menu-item"><a href="campaigns.jsf">Campaigns</a></li>
							<li class="menu-item"><a href="reports.jsf">Reports</a></li>
							<li class="menu-item"><h:commandLink value="Logout" action="#{loginBackingBean.logoutAction}"/></li>
						</ul>
					</h:form>
					<%		
						}
					%>
					</div>
				</div>
				<div class="page-title">
					<h2><%out.print(request.getParameter("headerTitle"));%></h2>					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- div.header end -->