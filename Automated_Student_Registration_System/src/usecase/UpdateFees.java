package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

import model.Course;

public class UpdateFees {
public static void fees() throws SQLException{
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter the course id: ");
	int courseId = scanner.nextInt();
	System.out.print("Enter the new fees: ");
	double newFees = scanner.nextDouble();
	
	AdminDao dao=new AdminDaoImpl();
	
	boolean res = dao.updateCourseFees(courseId, newFees);
    if (res == true) {
       // dao.updateCourseFees(courseId, newFees);
        System.out.println("Course fees updated successfully");
    } else {
        System.out.println("Invalid course id");
    }
}
	
public static void main(String[]args) throws SQLException {
	
}
}
