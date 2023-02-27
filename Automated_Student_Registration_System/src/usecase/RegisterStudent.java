package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

import model.Student;

public class RegisterStudent {
	public static void reg() throws SQLException {
		 StudentDao studentDAO = new StudentDaoImpl();
	      
	       Scanner scanner = new Scanner(System.in);

	       System.out.print("Enter student id: ");
	       int id = scanner.nextInt();
	       scanner.nextLine(); // Consume newline character

	       System.out.print("Enter student name: ");
	       String name = scanner.nextLine();

	       System.out.print("Enter student email: ");
	       String email = scanner.nextLine();

	       System.out.print("Enter student password: ");
	       String password = scanner.nextLine();

	       Student student = new Student(id, name, email, password);
	       
	       int result = studentDAO.registerStudent(student);
	       if (result > 0) {
	           System.out.println("Student registered successfully!");
	       } else {
	           System.out.println("Student registration failed.");
	       }
	}
public static void main(String[]args) throws SQLException {
	  
}
}
