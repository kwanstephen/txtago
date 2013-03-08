<html>
<body>
<%
String subscription_id = request.getParameter("subscription_id");
String customer_id = request.getParameter("customer_id");
String customer_reference = request.getParameter("customer_reference");
String product_handle = request.getParameter("product_handle");
String product_id = request.getParameter("product_id");
String signup_payment_id = request.getParameter("signup_payment_id");
out.write("<a href='http://txtago.skwan.cloudbees.net/process-subscription.jsp?"
			+ "subscription_id="+subscription_id+"&"
			+ "customer_id="+customer_id+"&"
			+ "customer_reference="+customer_reference+"&"
			+ "product_handle="+product_handle+"&"			
			+ "product_id="+product_id+"&"
			+ "signup_payment_id="+signup_payment_id
		+ "'>");
%>
<img src="images/subscription-success.jpg" border="0"/>
<%
out.write("</a>");
%>
</body>
</html>
