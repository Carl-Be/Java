<!DOCTYPE html>
<html>
	<%String accountNumber = request.getParameter("accountNumber");
		String paymentAmount = request.getParameter("paymentAmount");%>
	<head>
		<title>Accepted</title>
	</head>
	<body>
		<em>Payment Accepted for Account # <%=accountNumber%> for the amount of $<%=paymentAmount%>. Thank you for your business.</em>
	</body>
</html>

