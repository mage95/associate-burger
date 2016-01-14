<%-- 
    Document   : users
    Created on : Oct 30, 2015, 5:04:48 PM
    Author     : Alfredo Morgen
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Controller.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="stylesheet/main-css.css">
        <title>Insert New Product</title>
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
							<h1 class="centered">Users</h1>
						
							<table id="tableUsers" border="1" class="centered" width="75%" align="center">
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>E-Mail</th>
									<th>Address</th>
								</tr>

								<%
									Connect con = new Connect(application);
									ResultSet rs = con.select("SELECT * FROM MsUser");

									if(!rs.isBeforeFirst()){
								%>
								<tr>
									<td class="centered" colspan="4">No Data Found...</td>
								</tr>
								<%
									} else while (rs.next()){
								%>
										<tr>
											<td><%=rs.getString("ID")%></td>
											<td><%=rs.getString("Username")%></td>
											<td><%=rs.getString("Email")%></td>
											<td><%=rs.getString("Address")%></td>
										</tr>
								<%
									}
								%>
							</table>
						</div>
					</td>
					
					<p></p>
					
					<td width="20%"></td>
				</tr>
			</table>
		</div>

		<%@include file="footer.jsp" %>
    </body>
</html>

