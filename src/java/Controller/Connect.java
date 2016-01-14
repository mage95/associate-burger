/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.MsProduct;
import Bean.MsUser;
import controller.HibernateUtil;
//import java.sql.*;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author prk
 */
public class Connect {
//    Connection con;
//    ResultSet rs;
//    Statement st;
	
	List l;
    Session ses;
	Transaction tran;
	
    public Connect() {
//        try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + application.getRealPath("WEB-INF/database.accdb"));
//			st = con.createStatement(1004, 1008);
//		} catch (SQLException ex) {
//			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (ClassNotFoundException ex) {
//			Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
//		}
		ses = HibernateUtil.getSessionFactory().openSession();
    }
    
	public List getUserList(){
        l = ses.createSQLQuery("SELECT * FROM users").addEntity(MsUser.class).list();
        return l;
    }
	
	public List getUserById(int id){
        l = ses.createCriteria(MsUser.class).add(Restrictions.eq("userID", id)).list();
        return l;
    }
	
	public void insertUser(MsUser mu){
        tran = ses.beginTransaction();
        tran.begin();
        ses.save(mu);
        tran.commit();
        // tran.rollback();
    }
	
	public void insertProduct(MsProduct mp){
        tran = ses.beginTransaction();
        tran.begin();
        ses.save(mp);
        tran.commit();
        // tran.rollback();
    }
	
	public void updateUser(MsUser mu){
        tran = ses.beginTransaction();
        tran.begin();
        ses.update(mu);
        tran.commit();
    }
	
	public void deleteUser(int id){
        l = getUserById(id);
        MsUser mu = (MsUser) l.get(0);
        tran = ses.beginTransaction();
        tran.begin();
        ses.delete(mu);
        tran.commit();
    }
	
//    public ResultSet select(String query){
//        try {
//            rs = st.executeQuery(query);
//        } catch (SQLException ex) {
//            Logger.getLogger(Controller.Connect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rs;
//    }
//    
//    public void execute(String query){
//        try {
//            st.executeUpdate(query);
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Controller.Connect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}