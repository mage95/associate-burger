<%-- 
    Document   : productInsert
    Created on : Oct 30, 2015, 4:01:33 PM
    Author     : Alfredo Morgen
--%>

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
							<h1 class="centered">Insert New Product</h1>
							<form action="doInsertProduct" method="post">
								<table border="1" width="60%" align="center">
									<tr>
										<td colspan="2">
											<img src="images/burger_unknown.png" width="300">
										</td>
									</tr>

									<tr>
										<td width="50%">Name</td>
										<td width="50%"><input type="text" name="productName" size="50"></td>
									</tr>

									<tr>
										<td width="50%">Description</td>
										<td width="50%"><textarea name="description" cols="50" rows="5"></textarea></td>
									</tr>

									<tr>
										<td width="50%">Price</td>
										<td width="50%"><input type="text" name="price" size="50"></td>
									</tr>

									<tr>
										<td width="50%">Stock</td>
										<td width="50%"><input type="text" name="stock" size="50"></td>
									</tr>

									<tr>
										<td width="50%">Image</td>
										<td width="50%">
											<select name="image">
												<option value="./images/Cheeseburger.png">Cheeseburger</option>
												<option value="./images/Double_Cheeseburger.jpg">Double Cheeseburger</option>
												<option value="./images/MacBurger.gif">MacBurger</option>
												<option value="./images/mcdonald-mexican-burger.jpg">McDonald Mexican Burger</option>
											</select>
										</td>
									</tr>

									<tr>
										<td colspan="2"><input class="fullWidth" type="submit" value="Insert"></td>
									</tr>
								</table>
							</form>

							<div class="centered">
								<%
									String status = request.getParameter("status");
									if(status == null){
										status = "";
									}
								%>
								<p id="errMessage"><%=status%></p>
							</div>
						</div>
					</td>

					<td width="20%"></td>
				</tr>
			</table>
		</div>

		<%@include file="footer.jsp" %>
    </body>
</html>