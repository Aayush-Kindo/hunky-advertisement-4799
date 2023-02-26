package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class UpdateTotalSeatBatch {
public static void main(String[]args) throws SQLException {
	Scanner scn=new Scanner(System.in);
AdminDao dao = new AdminDaoImpl();
 
     System.out.println("Enter Batch Id");
     int batchId = scn.nextInt();

     System.out.println("Enter new value for total  seats");
    int newTotalSeats = scn.nextInt();
    
    boolean success =dao.updateBatchTotalSeats(batchId, newTotalSeats);
    if (success) {
        System.out.println("Total seats for batch ID " + batchId + " updated to " + newTotalSeats);
    } else {
        System.out.println("Failed to update total seats for batch ID " + batchId);
    }
}
}
