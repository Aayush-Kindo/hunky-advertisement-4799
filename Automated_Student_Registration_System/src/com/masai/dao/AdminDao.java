package com.masai.dao;

import java.sql.SQLException;
import java.util.List;

import model.Admin;
import model.Batch;
import model.Course;
import model.Student;

public interface AdminDao {
	  public String login(String email, String password)throws SQLException;
	  public boolean addCourse(Course course);
	  public boolean deleteCourse(int courseId) throws SQLException;
	  public Course searchCourse(int courseId) throws SQLException;
	  boolean createBatch(Batch batch) throws SQLException;
	 
	  public Batch getBatchById(int batchId);
	    public Student getStudentById(int studentId);
	    public boolean allocateBatchToStudent(int studentId, int batchId);
	  
	    public boolean updateBatchTotalSeats(int batchId, int newTotalSeats) throws SQLException;
	     public List<Student> viewStudentListByBatchId(int batchId)throws SQLException;
	        
	 
}