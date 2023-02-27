package usecase;

import java.sql.SQLException;
import java.util.List;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

import model.Batch;
import model.Course;

public class ViewAvailableCourse {
	public static void view() {
		 StudentDao dao = new StudentDaoImpl();
			List<Course> courses = dao.getAllCourses();
			List<Batch> batches = dao.getAllBatches();
			for (Course course : courses) {
			    System.out.println("Course: " + course.getCourseName() + " (" + course.getCourseDuration() + " weeks)");
			    System.out.println("Available batches:");
			    for (Batch batch : batches) {
			        if (batch.getCourseId() == course.getCourseId()) {
			            System.out.println("- Batch " + batch.getBatchId() + " (" + batch.getAvailableSeats() + " seats available)");
			        }
			    }
			    System.out.println();
			} 
	}
	public static void main(String[] args) throws SQLException {
	  
	   
	}
}
