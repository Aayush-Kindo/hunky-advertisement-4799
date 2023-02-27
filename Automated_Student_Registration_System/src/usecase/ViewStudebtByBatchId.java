package usecase;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

import model.Student;
import model.Batch;

public class ViewStudebtByBatchId {
	public static void views() throws SQLException {
		 Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter batch ID: ");
		    int batchId = scanner.nextInt();
		    
		    AdminDao dao =new  AdminDaoImpl();
		    
		    Batch batch = dao.getBatchById(batchId);
//		    Object batch;
			if (batch == null) {
		        System.out.println("Batch not found");
		        return;
		    }

		    // Get list of students in batch
		    List<Student> students = dao.viewStudentListByBatchId(batchId);
		    if (students.isEmpty()) {
		        System.out.println("No students enrolled in this batch");
		    } else {
		        System.out.println("Students enrolled in Batch " + batchId + ":");
		        for (Student student : students) {
		            System.out.println(student.getName() + " [" + student.getEmail() + "]");
		        }
		    }
	}
public static void main(String[]args) throws SQLException {
	 
}
}
