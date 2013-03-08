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
		
		
		    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
<%
Report report = ((Report)request.getAttribute("reportBean"));
if(report.getDataPoint().size()>0)
{
	
%>
	google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Date', 'Messages'],
<%      
for(int i=0;i<report.getDataPoint().size();i++)
{
		String[] dp = ((String[])report.getDataPoint().get(i));
        out.write("['"+dp[0]+"',"+dp[1]+"],");
}
%>        		
      ]);

      var options = {
        title: 'Daily Report'
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
<%
}
%>
    </script>
		
		
	</head>
	<body class="page">

		<jsp:include page="header.jsp?headerTitle=Daily_Report"/>
<h:form id="reportform">
		
			<div class="container">
			<div class="grid">
			<h:messages  layout="table" warnClass="error" infoClass="info" errorClass="error"/>
			<div>
			

		<div class="col-main">
			<div class="contactForm radius">
				<h3>Search</h3>
				<div class="wpcf7" id="wpcf7-f1-p18-o1">
					<div class="item">
					<div class="half left">
          				 <label>Campaign</label><span class="wpcf7-form-control-wrap password">
          				<h:selectOneMenu style="width: 135px;" value="#{reportBackingBean.formReport.campaignId}">	
				 			<f:selectItems value="#{reportBackingBean.campaignsList}" />
						</h:selectOneMenu>
          				</span>
					
        			</div>
					<div class="half right">
					<label>Days Back</label><span class="wpcf7-form-control-wrap password">
          				<h:selectOneMenu style="width: 135px;" value="#{reportBackingBean.formReport.daysBack}">	
				 			<f:selectItem itemValue="0" itemLabel="0" />
				 			<f:selectItem itemValue="1" itemLabel="1" />
				 			<f:selectItem itemValue="2" itemLabel="2" />
				 			<f:selectItem itemValue="3" itemLabel="3" />
				 			<f:selectItem itemValue="4" itemLabel="4" />
				 			<f:selectItem itemValue="5" itemLabel="5" />
				 			<f:selectItem itemValue="6" itemLabel="6" />
				 			<f:selectItem itemValue="7" itemLabel="7" />
				 			<f:selectItem itemValue="8" itemLabel="8" />
				 			<f:selectItem itemValue="9" itemLabel="9" />
				 			<f:selectItem itemValue="10" itemLabel="10" />
				 			<f:selectItem itemValue="11" itemLabel="11" />
				 			<f:selectItem itemValue="12" itemLabel="12" />
				 			<f:selectItem itemValue="13" itemLabel="13" />
				 			<f:selectItem itemValue="14" itemLabel="14" />
				 			<f:selectItem itemValue="15" itemLabel="15" />
				 			<f:selectItem itemValue="16" itemLabel="16" />
				 			<f:selectItem itemValue="17" itemLabel="17" />
				 			<f:selectItem itemValue="18" itemLabel="18" />
				 			<f:selectItem itemValue="19" itemLabel="19" />
				 			<f:selectItem itemValue="20" itemLabel="20" />
				 			<f:selectItem itemValue="21" itemLabel="21" />
				 			<f:selectItem itemValue="22" itemLabel="22" />
				 			<f:selectItem itemValue="23" itemLabel="23" />
				 			<f:selectItem itemValue="24" itemLabel="24" />
				 			<f:selectItem itemValue="25" itemLabel="25" />
				 			<f:selectItem itemValue="26" itemLabel="26" />
				 			<f:selectItem itemValue="27" itemLabel="27" />
				 			<f:selectItem itemValue="28" itemLabel="28" />
				 			<f:selectItem itemValue="29" itemLabel="29" />
				 			<f:selectItem itemValue="30" itemLabel="30" />
						</h:selectOneMenu>
          				</span>         	
					  
				
        			</div>
        			</div>
        			
        			        			
        			<div class="item">
         			<div class="half right">
         				<h:commandButton value="Graph" action="#{reportBackingBean.doDailyAction}"/>
        			</div>
        			</div>
        			
					<div class="wpcf7-response-output wpcf7-display-none"></div>
				
    <!--Div that will hold the chart-->
     <div id="chart_div" style="width: 650px; height: 500px;"></div>

			
				
				
				</div>
			</div>
		</div>
		</div>



        
		 

</div>		
</div>
</div>

</h:form>	
<!--div.header end -->
			
			

		<jsp:include page="footer.jsp"/>
	</body>
</f:view>
</html>