package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Batch;
import model.Course;
import model.Enrollment;
import model.Student;
import utility.Utility;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String login(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		 String message = "";
	        String sql = "SELECT * FROM admins WHERE admin_email = ? AND admin_password = ?";
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
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		  boolean success = false;
	        String sql = "INSERT INTO courses (course_name, course_description, course_fees,course_id,course_duration) VALUES (?, ?, ?,?,?)";
	        PreparedStatement pstmt = null;
	        try (Connection conn= Utility.provideConnection()){
	        	   pstmt = conn.prepareStatement(sql);
	               pstmt.setString(1, course.getCourseName());
	               pstmt.setString(2, course.getCourseDescription());
	               pstmt.setDouble(3, course.getCourseFees());
	               pstmt.setInt(4, course.getCourseId());
	               pstmt.setInt(5, course.getCourseDuration());
	               int rows = pstmt.executeUpdate();
	               if (rows > 0) {
	                   success = true;
	               }
				
			  }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
	        return success;
	        
	}

	@Override
	public boolean deleteCourse(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		 boolean ans=false;
		String query = "DELETE FROM Courses WHERE course_id = ?";
		try (Connection conn= Utility.provideConnection()){
			PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setInt(1, courseId);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
			
		  }catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		return ans;
	}

	@Override
	public Course searchCourse(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		 Course course = null;
		 String sql = "SELECT * FROM courses WHERE course_id = ?";
		 
		 try (Connection conn= Utility.provideConnection()){
			 PreparedStatement stmt = conn.prepareStatement(sql);
			 stmt.setInt(1, courseId);
			 ResultSet rs = stmt.executeQuery();
			 if (rs.next()) {
                 course = new Course();
                 course.setCourseId(rs.getInt("course_id"));
                 course.setCourseName(rs.getString("course_name"));
                 course.setCourseDescription(rs.getString("course_description"));
                 course.setCourseDuration(rs.getInt("course_duration"));
                 course.setCourseFees(rs.getDouble("course_fees"));
             }
				
			  }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		 
		 
		return course;
	}

	@Override
	public boolean createBatch(Batch batch) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection conn= Utility.provideConnection()){
			
	        PreparedStatement ps = conn.prepareStatement("INSERT INTO batches (course_id,batch_id, batch_total_seats, batch_available_seats) VALUES (?,?, ?, ?)");
            ps.setInt(1, batch.getCourseId());
            ps.setInt(2, batch.getBatchId());
            
            ps.setInt(3, batch.getTotalSeats());
            ps.setInt(4, batch.getAvailableSeats());
            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
			
		  }catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}
		return false;
	}

	@Override
	public Batch getBatchById(int batchId) {
		// TODO Auto-generated method stub
		  Batch batch = null;
		  try (Connection conn= Utility.provideConnection()){
				
			  PreparedStatement statement = conn.prepareStatement("SELECT * FROM Batches WHERE batch_id = ?");
	            statement.setInt(1, batchId);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                batch = new Batch();
	                batch.setBatchId(batchId);
	                batch.setCourseId(resultSet.getInt("course_id"));
	               
	                batch.setTotalSeats(resultSet.getInt("batch_total_seats"));
	                batch.setAvailableSeats(resultSet.getInt("batch_available_seats"));
	            }
				
			  }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		  
		return batch;
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		 Student student = null;
		 try (Connection conn= Utility.provideConnection()){
				
			  PreparedStatement statement = conn.prepareStatement("SELECT * FROM Students WHERE student_id = ?");
	            statement.setInt(1, studentId);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                student = new Student();
	                student.setId(resultSet.getInt("student_id"));
	                student.setName(resultSet.getString("student_name"));
	                student.setEmail(resultSet.getString("student_email"));
	                student.setPassword(resultSet.getString("student_password"));
	            }
				
			  }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		 
		 return student;
	}

	@Override
	public boolean allocateBatchToStudent(int studentId, int batchId) {
		// TODO Auto-generated method stub
		boolean success = false;
try (Connection connection= Utility.provideConnection()){
			
	  connection.setAutoCommit(false);

      Batch batch = getBatchById(batchId);
      if (batch.getAvailableSeats() > 0) {
          Enrollment enrollment = new Enrollment();
          enrollment.setStudentId(studentId);
          enrollment.setBatchId(batchId);

          PreparedStatement enrollmentStatement = connection.prepareStatement("INSERT INTO Enrollments (student_id, batch_id) VALUES (?, ?)");
          enrollmentStatement.setInt(1, enrollment.getStudentId());
          enrollmentStatement.setInt(2, enrollment.getBatchId());
          enrollmentStatement.executeUpdate();

          PreparedStatement batchStatement = connection.prepareStatement("UPDATE Batches SET batch_available_seats = ? WHERE batch_id = ?");
          batchStatement.setInt(1, batch.getAvailableSeats() - 1);
          batchStatement.setInt(2, batchId);
          batchStatement.executeUpdate();

          connection.commit();
          success = true;
      } else {
          connection.rollback();
      }
      connection.setAutoCommit(true);
			
		  }catch (SQLException e) {
				e.printStackTrace();
				//message= e.getMessage();
			}

		return success;
	}

	@Override
	public boolean updateBatchTotalSeats(int batchId, int newTotalSeats) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
        PreparedStatement pstmt = null;
       try (Connection conn= Utility.provideConnection()){
			
	        
	  String sql = "UPDATE Batches SET batch_total_seats = ? WHERE batch_id = ?";
      pstmt = conn.prepareStatement(sql);
      
      
      pstmt.setInt(1, newTotalSeats);
      pstmt.setInt(2, batchId);
      
      
      int rowsUpdated = pstmt.executeUpdate();
      
     
      if (rowsUpdated > 0) {
          result = true;
      }
			
		  }catch (SQLException e) {
				e.printStackTrace();
				//message
		return false;
	}

	
	return result;
	}

	@Override
	public List<Student> viewStudentListByBatchId(int batchId) throws SQLException {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<>();
        String sql = "SELECT s.* FROM students s JOIN enrollments e ON s.student_id = e.student_id WHERE e.batch_id = ?";
        try (Connection conn= Utility.provideConnection()){
			
        	 PreparedStatement stmt = conn.prepareStatement(sql);
             stmt.setInt(1, batchId);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Student student = new Student();
                
                 student.setId(rs.getInt("student_id"));
                 student.setName(rs.getString("student_name"));
                 student.setEmail(rs.getString("student_email"));
                 student.setPassword(rs.getString("student_password"));
                 studentList.add(student);
             }
				
			  }catch (SQLException e) {
					e.printStackTrace();
					//message= e.getMessage();
				}
		 
		return studentList;
	}
}

	
	


