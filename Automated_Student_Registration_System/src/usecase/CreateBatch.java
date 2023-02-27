package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

import model.Batch;
import model.Course;

public class CreateBatch {
	public static void create_batch() throws SQLException {
		Scanner scn =new Scanner(System.in);
		Batch newBatch=new Batch();
		
		System.out.println("Enter course id");
		int  course_id=scn.nextInt();
		newBatch.setCourseId(course_id);
		
		System.out.println("Enter batch id");
		int  batch_id=scn.nextInt();
		newBatch.setBatchId(batch_id);
		
		
		System.out.println("Enter total seats");
		int  tseats=scn.nextInt();
		newBatch.setTotalSeats(tseats);
		
		
		System.out.println("Enter available seats");
		int  aseats=scn.nextInt();
		newBatch.setAvailableSeats(aseats);
		
		AdminDao dao=new AdminDaoImpl();
		boolean ans=dao.createBatch(newBatch);
		
		if(ans==true) {
			System.out.println("Batch created Sucessfully");
		}else {
			System.out.println("Unable to create Batch");
		}
	}
public static void main(String[]args) throws SQLException {
	
	
	
}
}
