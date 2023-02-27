package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import model.Batch;
import model.Course;
import model.Student;
import utility.Utility;

public class StudentDaoImpl implements  StudentDao {

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		 boolean updated = false;
	        String sql = "UPDATE Students SET student_name = ?, student_email = ?, student_password = ? WHERE student_id = ?";
		 try (Connection conn= Utility.provideConnection()){
			 PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, student.getName());
	            ps.setString(2, student.getEmail());
	            ps.setString(3, student.getPassword());
	            ps.setInt(4, student.getId());
	            int rowsUpdated = ps.executeUpdate();
	            if (rowsUpdated > 0) {
	                updated = true;
	            }
            }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		return updated;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		 List<Course> courses = new ArrayList<>();
		 try (Connection conn= Utility.provideConnection()){
			 PreparedStatement statement = conn.prepareStatement("SELECT * FROM Courses");
			 ResultSet rs = statement.executeQuery();
		       
	            while (rs.next()) {
	                Course course = new Course();
	                course.setCourseId(rs.getInt("course_id"));
	                course.setCourseName(rs.getString("course_name"));
	                course.setCourseDescription(rs.getString("course_description"));
	                course.setCourseDuration(rs.getInt("course_duration"));
	                course.setCourseFees(rs.getInt("course_fees"));
	                courses.add(course);
            }
		 }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		 
		return courses;
	}

	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		 List<Batch> batches = new ArrayList<>();
		 
		 try (Connection conn= Utility.provideConnection()){
			  
	          
	            PreparedStatement statement = conn.prepareStatement ("SELECT * FROM Batches");
				 ResultSet rs = statement.executeQuery();
	            while (rs.next()) {
	                Batch batch = new Batch();
	                batch.setBatchId(rs.getInt("batch_id"));
	                batch.setCourseId(rs.getInt("course_id"));
	                batch.setTotalSeats(rs.getInt("batch_total_seats"));
	                batch.setAvailableSeats(rs.getInt("batch_available_seats"));
	                batches.add(batch);
	            }
		 }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		 
		return batches;
	}

	@Override
	public int registerStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		 int result = 0;
		 try (Connection conn= Utility.provideConnection()){
			  PreparedStatement ps = conn.prepareStatement("INSERT INTO students (student_id,student_name, student_email, student_password) VALUES (?,?, ?, ?)");
			  ps.setInt(1, student.getId()); 
			  ps.setString(2, student.getName());
	            ps.setString(3, student.getEmail());
	            ps.setString(4, student.getPassword());
	            
	            result = ps.executeUpdate();
	          
	           
	            
		 }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		 
		return result;
	}

	@Override
	public String login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		 String message = "";
	        String sql = "SELECT * FROM students WHERE student_email = ? AND student_password = ?";
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
			
		 try (Connection conn= Utility.provideConnection()){
			  pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, email);
	            pstmt.setString(2, password);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                message = "Login successful!";
	            } else {
	                message = "Invalid email or password.";
	            }  
			
		  }catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		return message;
		//return null;
	}

}
