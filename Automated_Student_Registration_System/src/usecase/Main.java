package usecase;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		int adminOp;
		int userOp;
		int val=0;
		int num=0;
		
		while (true) {
			System.out.println("Enter 1 to Login as Admin");
			System.out.println("Enter 2 to Login as Student");
			

			int anss = sc.nextInt();
			
			if(anss==1) {

				while (true ) {
					
					if(val==0) {
						Login.adminLogin();
					}
					
					
					
					System.out.println("Enter 1 to Add a new Course");
					System.out.println("Enter 2 to Updte Fees of course");
					System.out.println("Enter 3 to Delete a course ");
					System.out.println("Enter 4 to Search Information about course");
					System.out.println("Enter 5 to Create Batch under a course");
					System.out.println("Enter 6 to Allocate Student in a Batch under course");
					System.out.println("Enter 7 to Update Total Seats of a batch");
					System.out.println("Enter 8 to View the students of  batch");
					
					adminOp = sc.nextInt();
					
					if(adminOp==1) {
						AddCourse.addCourse();
						val++;
						}else if(adminOp==2) {
						UpdateFees.fees();
						val++;
						
					}else if(adminOp==3) {
						DeleteCourse.course_delete();
						val++;
						
					}else if(adminOp==4) {
						SearchCourse.search();	
						val++;
					}else if(adminOp==5) {
						CreateBatch.create_batch();
						val++;
					}else if(adminOp==6) {
						AllocateStudent.allocate();
						val++;
					}else if(adminOp==7) {
						UpdateTotalSeatBatch.update_seats();
						val++;
					}else if(adminOp==8) {
						ViewStudebtByBatchId.views();
						val++;
					}
				}
			}else if(anss==2) {
				while(true) {
					if(num==0) {
						System.out.println("Enter 1 to Login as Student");
						System.out.println("Enter 2 to Register ");
						int res=sc.nextInt();
						
						if(res==1) {
							LoginStudent.login();
							num++;
						}else if(res==2) {
							RegisterStudent.reg();
						}
						
						
					}

					
					System.out.println("Enter 3 to Update Student Details");
					System.out.println("Enter 4 to See available course");
					
					userOp = sc.nextInt();
					if(userOp==3) {
						UpdateStudent.update();
					}else if(userOp==4) {
						ViewAvailableCourse.view();
					}
					
				}
			}

	}
}
}
