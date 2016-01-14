<%-- 
    Document   : register
    Created on : Oct 25, 2015, 1:39:54 AM
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
					<%
						String status = request.getParameter("status");
						if(status == null){
							status = "";
						}
					%>
					
					<td width="60%">
						<div id="mainContent">
							<h1 class="centered">Register Now</h1>
							<form action="doRegister" method="post">
								<table align="center">
									<tr>
										<td class="bold">Username</td>
										<td><input type="text" name="username" size="49"></td>
									</tr>

									<tr>
										<td class="bold">Password</td>
										<td><input type="password" name="password" size="49"></td>
									</tr>

									<tr>
										<td class="bold">Confirm Password</td>
										<td><input type="password" name="confirmPassword" size="49"></td>
									</tr>

									<tr>
										<td class="bold">Email</td>
										<td><input type="text" name="email" size="49"></td>
									</tr>

									<tr>
										<td class="bold">Address</td>
										<td><textarea name="address" cols="50" rows="5"></textarea></td>
									</tr>

									<tr>
										<td colspan="2"><input class="fullWidth" type="submit" value="Register"></td>
									</tr>

									<tr>
										<td colspan="2"><p id="errMessage"><%=status%></p></td>
									</tr>
								</table>
							</form>
						</div>
					</td>

					<td width="20%"></td>
				</tr>
			</table>
		</div>
				
		<%@include file="footer.jsp" %>
    </body>
</html>
