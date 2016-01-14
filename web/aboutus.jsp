<%-- 
    Document   : aboutus
    Created on : Oct 26, 2015, 12:20:06 AM
    Author     : Alfredo Morgen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet/main-css.css">
        <title>Associate Burger</title>
    </head>
	
    <body>
		<%@include file="header.jsp" %>
		
		<div id="content">
			<table width="100%">
				<tr>
					<!-- Login & Register -->
					<td width="20%" id="loginTable">
						<div id="login">
							<%@include file="login.jsp" %>
						</div>
					</td>
				
				<!-- Main content -->
				<td width="60%">
					<div class="centered" id="mainContent">
						<h1 class="centered">About Us</h1>
						<h4 class="centered">Bluejack Burgershop is a Giant Fastfood Restaurant</h4>
						<h4 class="centered">that sells a marvelous fastfood</h4>
						<h4 class="centered">in extraordinary ways since 1998.</h4>
					</div>
				</td>
				
				<td width="20%"></td>
				</tr>
			</table>
		</div>
				
		<%@include file="footer.jsp" %>
    </body>
</html>
