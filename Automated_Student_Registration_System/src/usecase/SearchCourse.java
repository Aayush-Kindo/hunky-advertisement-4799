package usecase;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

import model.Course;

public class SearchCourse {
	public static void search() throws SQLException {
		 AdminDao dao = new AdminDaoImpl();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter Course ID:");
         int courseId = scanner.nextInt();
         Course course = dao.searchCourse(courseId);
         if (course != null) {
             System.out.println("Course ID: " + course.getCourseId());
             System.out.println("Course Name: " + course.getCourseName());
             System.out.println("Course Description: " + course.getCourseDescription());
             System.out.println("Course Duration: " + course.getCourseDuration() + " days");
             System.out.println("Course Fees: Rs" + course.getCourseFees());
         } else {
             System.out.println("Course not found!");
         }
	}
	public static void main(String[] args) throws SQLException {
		
     
         
	}
}
