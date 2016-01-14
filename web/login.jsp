<%
	Integer totalOnlineUsers = (Integer) application.getAttribute("totalOnlineUsers");
	if(session.getAttribute("Username") != null){
%>
		<p>Welcome, <%=session.getAttribute("Username")%></p>
		<p><%=totalOnlineUsers%> User(s) Online</p>
		<form action="doLogout">
			<input type="submit" value="Logout">
		</form>
<%
	} else {
%>
		<form action="doLogin" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="checkbox" name="rememberMe">Remember Me</td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Login"> Or <a href="register.jsp">Register</a></td>
				</tr>
			</table>
		</form>
<%
	}
	
	String statusLogin = request.getParameter("statusLogin");
	if(statusLogin == null){
		statusLogin = "";
	}
%>

<p id="errMessage"><%=statusLogin%></p>