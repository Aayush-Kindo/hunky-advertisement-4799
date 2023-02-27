package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AllocateStudent {
	public static void  allocate() {
		Scanner scanner = new Scanner(System.in);

		
		System.out.print("Enter student ID: ");
		int studentId = scanner.nextInt();

		
		System.out.print("Enter batch ID: ");
		int batchId = scanner.nextInt();
	    
		AdminDao adminDAO = new AdminDaoImpl();
		
		// allocate the student to the batch
		adminDAO.allocateBatchToStudent(studentId, batchId);
		
		System.out.println("Student " + studentId + " successfully allocated to batch " + batchId);
	
	}
	public static void main(String[] args) {
	}   

}
