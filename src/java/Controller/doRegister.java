/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.MsUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alfredo Morgen
 */
public class doRegister extends HttpServlet {

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
	public boolean validateAlphabet(String str){
		char[] chr = str.toCharArray();
		int length = str.length();
		
		for(int i = 0; i < length; i++){
			if(!Character.isLetter(chr[i])){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean validateAlphaNumeric(String str){
		char[] chr = str.toCharArray();
		int length = str.length();
		
		for(int i = 0; i < length; i++){
			if(!Character.isLetter(chr[i]) && !Character.isDigit(chr[i])){
				return false;
			}
		}
		
		return true;
	}
	
	// Format email yang valid masih kurang jelas
	// Contohnya: Apa harus alphanumeric? Apa input "!@!.!" valid?
	public boolean validateEmail(String str){
		int length = str.length();
		int posAt = str.indexOf("@");
		int posDot = str.indexOf(".");
		
		if(posAt < 0 || posDot < 0){
			return false;
		} else if(posDot < posAt){
			return false;
		} else if(posAt == 0){
			return false;
		} else if(posDot == length - 1){
			return false;
		} else if(posAt == posDot - 1){
			return false;
		} else {
			return true;
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();
		Connect con = new Connect();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		// Validasi Username
		if(username == null || username.equals("")){
			response.sendRedirect("register.jsp?status=Name must be filled");
		} else if(!validateAlphabet(username)){
			response.sendRedirect("register.jsp?status=Name must be alphabet");
		} else if(username.length() <= 5){
			response.sendRedirect("register.jsp?status=Name must be more than 5 characters");
		}
		
		// Validasi Password
		else if(password == null || password.equals("")){
			response.sendRedirect("register.jsp?status=Password must be filled");
		} else if(!validateAlphaNumeric(password)){
			response.sendRedirect("register.jsp?status=Password must be alphanumeric");
		}
		
		// Validasi Confirm Password
		else if(!confirmPassword.equals(password)){
			response.sendRedirect("register.jsp?status=Confirm Password must be same as Password");
		}
		
		// Validasi Email
		else if(!validateEmail(email)){
			response.sendRedirect("register.jsp?status=" + email);
		}
		
		// Validasi Address
		else if(!address.contains("Street")){
			response.sendRedirect("register.jsp?status=Address must contain word 'Street'");
		}
		
		// Insert to Database
		else {
//			String query = "INSERT INTO MsUser(Username, Password, Email, Address) VALUES('"+username+"', '"+password+"', '"+email+"', '"+address+"')";
//			con.execute(query);
			
			MsUser mu = new MsUser(username, password, email, address);
			con.insertUser(mu);
			
			response.sendRedirect("register.jsp?status=Registration successful!");
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

