<div id="header">
	<img src="images/header_associate_burger_large.jpg">

	<nav>
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<%
				if(application.getAttribute("totalOnlineUsers") == null){
					session.setAttribute("Username", null);
				}
				
				if(session.getAttribute("Username") == null){
			%>
					<li><a href="register.jsp">Register</a></li>
			<%
				} else if(session.getAttribute("Username").equals("admin")) {
			%>
					<li><a href="product.jsp">Product</a></li>
					<li><a href="users.jsp">Users</a></li>
			<%
				} else {
			%>
					<li><a href="product.jsp">Product</a></li>
			<%
				}
			%>
			<li><a href="aboutus.jsp">About Us</a></li>
		</ul>
	</nav>
</div>