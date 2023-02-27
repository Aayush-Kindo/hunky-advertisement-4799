package usecase;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

import model.Course;

public class AddCourse {
	public static void addCourse() {
		Scanner scn =new Scanner(System.in);
		Course newCourse=new Course();
		

		
		
		System.out.println("Enter course name");
		String course_name=scn.nextLine();
		newCourse.setCourseName(course_name);
		String course_desp="";
		System.out.println("Enter course description");
		course_desp+=scn.nextLine();
		newCourse.setCourseDescription(course_desp);
		
		
		
		System.out.println("Enter course fee");
		double course_fee=scn.nextDouble();
		newCourse.setCourseFees(course_fee);
		
		System.out.println("Enter course duration");
		int  course_duration=scn.nextInt();
		newCourse.setCourseDuration(course_duration);
		
		System.out.println("Enter course id");
		int  course_id=scn.nextInt();
		newCourse.setCourseId(course_id);
		
		AdminDao dao=new AdminDaoImpl();
		boolean res=dao.addCourse(newCourse);
		
		if(res==true) {
			System.out.println("Course added Sucessfully");
		}else {
			System.out.println("Unable to add course");
		}
		
		
	
	}
public static void main(String[]args) {
	
}
}
