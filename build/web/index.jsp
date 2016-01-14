<%--
    Document   : index
    Created on : Oct 24, 2015, 11:06:23 PM
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
						<div id="mainContent">
							<h1 class="centered">Offer The Best Fast Food Taste In The World</h1>
							<h4 class="centered">Experience the pleasure in every dish that we serve</h4>
						</div>
						
					</td>

					<td width="20%"></td>
				</tr>
			</table>
		</div>
				
		<%@include file="footer.jsp" %>
    </body>
	
	
</html>
