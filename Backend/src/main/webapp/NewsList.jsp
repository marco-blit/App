<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "unire.Database" %>
<%@ page import = "unire.News" %>
<%
	response.setHeader("Access-Control-Allow-Origin","*");
	Database db = new Database();
	List<News> news = db.ListNews();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>News</title>
</head>
<body>
	<% for(News n: news)
	{%>
		<div class="col-md-4 col-sm-6">
			<div class="hover11 column">
				<div>
					<figure>
						<img class="img-responsive" src="<%= n.getImage() %>">
					</figure>
	
					<span style="font-family: Roboto Slab; font-weight: bold;"><%= n.getTitle() %></span>

				</div>
	
			</div>
		</div>
	<% } %>
</body>
</html>