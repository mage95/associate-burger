<%-- 
    Document   : product
    Created on : Oct 29, 2015, 8:47:35 PM
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
        <title>Product</title>
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
							<h1 class="centered">Product</h1>
							<form action="doSearch">
								<table align="center">
									<tr>
										<td><input type="text" name="searchByName" placeholder="Search by Name"></td>
										<td>
											<select name="searchByPrice">
												<option selected value="-1">Any Price Range</option>
												<option value="0-10000">Rp 0 - Rp 10.000</option>
												<option value="10001-20000">Rp 10.001 - Rp 20.000</option>
												<option value="20001-30000">Rp 20.001 - Rp 30.000</option>
												<option value="30001-40000">Rp 30.001 - Rp 40.000</option>
												<option value="40001-50000">Rp 40.001 - Rp 50.000</option>
											</select>
										</td>
										<td><input type="submit" value="Search"></td>
									</tr>
								</table>
							</form>

							<p></p>
							<p></p>

							<%
								Connect con = new Connect(application);
								ResultSet rs = con.select("SELECT * FROM MsProduct");

								if(request.getParameter("name") != null && request.getParameter("minPrice") == null){
									rs = con.select("SELECT * FROM MsProduct WHERE productName LIKE '%" + request.getParameter("name") + "%'");
								} else if(request.getParameter("name") == null && request.getParameter("minPrice") != null){
									rs = con.select("SELECT * FROM MsProduct WHERE price BETWEEN " + request.getParameter("minPrice") + " AND " + request.getParameter("maxPrice"));
								} else if(request.getParameter("name") != null && request.getParameter("minPrice") != null){
									rs = con.select("SELECT * FROM MsProduct WHERE productName LIKE '%" + request.getParameter("name") + "%' AND price BETWEEN " + request.getParameter("minPrice") + " AND " + request.getParameter("maxPrice"));
								}

								if(!rs.isBeforeFirst()){
							%>
									<h2 class="centered">No Data Found...</h2>
							<%
								} else while (rs.next()) {
							%>
									<table border="1" width="60%" align="center">
										<tr>
											<td colspan="2">
												<%="<img src=\"" + rs.getString("image") + "\" width=\"250px\">"%>
											</td>
										</tr>

										<tr>
											<td width="50%">ID</td>
											<td width="50%"><%= rs.getString("ID")%></td>
										</tr>

										<tr>
											<td width="50%">Name</td>
											<td width="50%"><%= rs.getString("productName")%></td>
										</tr>

										<tr>
											<td width="50%">Description</td>
											<td width="50%"><%= rs.getString("description")%></td>
										</tr>

										<tr>
											<td width="50%">Price</td>
											<td width="50%"><%= rs.getInt("price")%></td>
										</tr>

										<tr>
											<td width="50%">Stock</td>
											<td width="50%"><%= rs.getInt("stock")%></td>
										</tr>
									</table>

									<p></p>
								<%
									}
								%>

							<%
								if(session.getAttribute("Username").equals("admin")){
							%>
									<div class="centered" style="margin: 20px;"><a href="productInsert.jsp" style="background-color: red; border-radius: 2px; color: orange;">Insert New Product</a></div>
							<%
								}
							%>
						</div>
					</td>

					<td width="20%"></td>
				</tr>
			</table>
		</div>

		<%@include file="footer.jsp" %>
    </body>
</html>
