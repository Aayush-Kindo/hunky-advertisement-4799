package com.masai.dao;

import java.sql.SQLException;
import java.util.List;

import model.Batch;
import model.Course;
import model.Student;

public interface StudentDao {
	 public int registerStudent(Student student) throws SQLException;
	 public boolean updateStudent(Student student);
	  public List<Course> getAllCourses();
	    public List<Batch> getAllBatches();
	    public String login(String email, String password)throws SQLException;
}
