package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

import model.Course;

public class DeleteCourse {
	public static void course_delete() throws SQLException {
		Scanner scn =new Scanner(System.in);
		Course newCourse=new Course();
	
		System.out.println("Enter course id");
		int  course_id=scn.nextInt();
		newCourse.setCourseId(course_id);
		
		AdminDao dao=new AdminDaoImpl();
		boolean res=dao.deleteCourse(course_id);
		
		if(res==true) {
			System.out.println("Course deleted Sucessfully");
		}else {
			System.out.println("Unable to delete course");
		}
	}
	public static void main(String[]args) throws SQLException {
	
		
		
	}
	}


