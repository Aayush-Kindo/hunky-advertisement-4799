package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

public class LoginStudent {
	 public static void login() {
		 Scanner scn =new Scanner(System.in);
		   System.out.print("Enter email: ");
		   String email = scn.next();
		   //System.out.println(email);
	       System.out.print("Enter password: ");
	       String password = scn.next();
	      // System.out.println(password);
	       StudentDao dao=new StudentDaoImpl();
	       String msg = "";
	       
	       		try {
			 msg = dao.login(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//	       if (admin != null) {
//	           System.out.println("Welcome " + admin.getName() + "!");
//	           System.out.println("Profile:");
//	           System.out.println("ID: " + admin.getId());
//	           System.out.println("Name: " + admin.getName());
//	           System.out.println("Email: " + admin.getEmail());
//	       } else {
//	           System.out.println("Invalid email or password.");
//	       }
		System.out.println(msg);
	   
	 }
	  public static void main(String[]args) throws SQLException {
	  }
	   
}
