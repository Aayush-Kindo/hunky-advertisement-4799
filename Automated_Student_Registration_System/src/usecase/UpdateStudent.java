package usecase;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

import model.Student;

public class UpdateStudent {
	public static void update() {
		Scanner scn =new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		
		System.out.println("Enter id");
		int id=scn.nextInt();
		System.out.println("Enter  updated name");
		String name=scn.next();
		System.out.print("Enter updated email");
		String mail=scn.next();
		System.out.print("Enter updated password");
		String password=scn.next();
		
		Student student=new Student(id,name,mail,password);
		
	       
		   boolean updated = dao.updateStudent(student);
	       if (updated) {
	           System.out.println("Student updated successfully.");
	       } else {
	           System.out.println("Failed to update student.");
	       }
	}
public static void main(String[]args) {
	
}
}
