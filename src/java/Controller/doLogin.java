/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Alfredo Morgen
 */
public class doLogin extends HttpServlet {

	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
//		Connect con = new Connect(application);
//		ResultSet rs;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		
		if(username == null || username.equals("")){
			response.sendRedirect("index.jsp?statusLogin=Username must be filled");
		} else if(password == null || password.equals("")){
			response.sendRedirect("index.jsp?statusLogin=Password must be filled");
		} else {
//			String query = "SELECT * FROM MsUser WHERE Username = '" + username + "' AND Password = '" + password + "'";
//			rs = con.select(query);
			
			Connect con = new Connect();
            List l = con.getUserList();
			
			try {
				if(l.isEmpty()){
					if(rememberMe != null){
						Cookie cookieUser = new Cookie("Username", username);
						cookieUser.setMaxAge(60 * 60);
						response.addCookie(cookieUser);
					}
					
					session.setAttribute("Username", username);
					
					// Untuk jumlah user yang sedang online
					if(application.getAttribute("totalOnlineUsers") == null){
						application.setAttribute("totalOnlineUsers", 1);              
					} else {
						application.setAttribute("totalOnlineUsers", ((Integer)application.getAttribute("totalOnlineUsers")) + 1);
					}
					
					response.sendRedirect("index.jsp");
				} else {
					response.sendRedirect("index.jsp?statusLogin=Username or Password not found");
				}
				
			} catch (Exception ex) {
				Logger.getLogger(doLogin.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
