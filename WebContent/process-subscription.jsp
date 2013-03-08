<%@ page import="com.txtago.bean.*,
					com.txtago.service.*" 

		errorPage="index.jsp"
%>
<html>
<body>
<%
String subscription_id = request.getParameter("subscription_id");
String customer_id = request.getParameter("customer_id");
String customer_reference = request.getParameter("customer_reference");
String product_handle = request.getParameter("product_handle");
String product_id = request.getParameter("product_id");
String signup_payment_id = request.getParameter("signup_payment_id");

SubscriptionService service = new SubscriptionService();
User loginUser = ((User)request.getSession().getAttribute("loginUser"));
UserSubscription sub = null;
sub = service.getUserSubscription(loginUser.getId());
if(sub == null)
	sub = new UserSubscription();

sub.setNextBillingDate(String.valueOf(new java.util.Date().getTime()));
sub.setPaidBillingId(subscription_id);
sub.setUserId(loginUser.getId());
sub.setUsage(0);

if(sub.getId() == 0)
	service.addUserSubscription(sub);
else
	service.updateUserSubscription(sub);

response.sendRedirect("account.jsf");
%>

</body>
</html>
