<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<html>
	<%!java.util.Date currentDateTime = new java.util.Date();%>
	<%!java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat("'Currently: ' dd MMM yyyy 'at' HHmm z");%>

	<head>
		<title>My First HTML</title>
		<link rel="stylesheet" type="text/css" href="indexcss.css">
	</head>
	<body>
		<h1>Carl Bechie CIS 279 CNR 10835</h1><br>
		<h1><%=dateTimeFormat.format(currentDateTime)%></h1><br>
		 <strong><a href="payment.jsp">Payment JSP</a></strong> 
		<h2>Here is a list of fruit I like!</h2>
	        <ul>
			<li><h3>Fruit</h3></li>
		        <p>
			what kind of fruits you ask?
			</p>
			<ol>
				<li><a href="https://api.time.com/wp-content/uploads/2018/04/strawberries.jpg?w=800&quality=85"><strong>Stawberries</strong></a></li>
                                <img src="https://api.time.com/wp-content/uploads/2018/04/strawberries.jpg?w=800&quality=85" alt="stawberries" height="200" width="350">
				<p>
				<em>Stawberries make for a juicy sweet treat on a hot summer day!</em>                    
				</p>
				<li><a href="https://cdn-prod.medicalnewstoday.com/content/images/articles/271/271157/bananas-chopped-up-in-a-bowl.jpg"><strong>Bananas</strong></a></li>
				<img src="https://cdn-prod.medicalnewstoday.com/content/images/articles/271/271157/bananas-chopped-up-in-a-bowl.jpg" alt="banana" height="200" width="350">
				<p>
				<em>Bananas are good to eat after a long run!</em>
				</p>
				<li><a href="https://www.news-medical.net/image.axd?picture=2019%2F11%2Fshutterstock_1089612134.jpg"><strong>Blueberries</strong></a></li>
				<img src="https://www.news-medical.net/image.axd?picture=2019%2F11%2Fshutterstock_1089612134.jpg" alt="Blueberries" height="200" width="350">
				<p>
				<em>Blueberries are good in oatmeal with some cinnamon sprinkled on top!</em>
				</p>
			</ol>
		</ul>
		<form action="/content" method="post">
			Message:<br>
			<input type="text" name="message" value="Test"><br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>