package usecase;

import java.sql.SQLException;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AllocateStudent {
	public static void main(String[] args) {
	    int studentId = 1; // replace with the ID of the student to allocate
	    int batchId = 1; // replace with the ID of the batch to allocate to
	    
	    // create a new instance of the AdminDAO implementation class
		AdminDao adminDAO = new AdminDaoImpl();
		
		// allocate the student to the batch
		adminDAO.allocateBatchToStudent(studentId, batchId);
		
		System.out.println("Student " + studentId + " successfully allocated to batch " + batchId);
	}

}
