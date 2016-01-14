/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Bean.Products;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alfredo Morgen
 */
public class doInsertProduct extends HttpServlet {
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
	
	public boolean validateNumeric(String str){
		char[] chr = str.toCharArray();
		int length = str.length();
		
		for(int i = 0; i < length; i++){
			if(!Character.isDigit(chr[i])){
				return false;
			}
		}
		
		return true;
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext application = getServletContext();
		Connect con = new Connect();
		
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String stock = request.getParameter("stock");
		String image = request.getParameter("image");
		
		if(productName == null || productName.equals("")){
			response.sendRedirect("productInsert.jsp?status=Name must be filled");
		} else if(description.length() < 10){
			response.sendRedirect("productInsert.jsp?status=Description must be more than 10 characters");
		} else if(!validateNumeric(price) || price.equals("")){
			response.sendRedirect("productInsert.jsp?status=Price must be numeric");
		} else if(Integer.parseInt(price) < 1000){
			response.sendRedirect("productInsert.jsp?status=Price must be more than 1000");
		} else if(!validateNumeric(stock) || stock.equals("")){
			response.sendRedirect("productInsert.jsp?status=Stock must be numeric");
		} else {
//			String query = "INSERT INTO MsProduct(productName, description, price, stock, image) VALUES('"+productName+"', '"+description+"', "+Integer.parseInt(price)+", "+Integer.parseInt(stock)+", '"+image+"')";
//			con.execute(query);
			
		Products mp = new Products(productName, description, Integer.parseInt(price), Integer.parseInt(stock), image);
			con.insertProduct(mp);
			
			response.sendRedirect("register.jsp?status=Insert product successful!");
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
