package model;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int batchId;
    
	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public Enrollment() {
		
		// TODO Auto-generated constructor stub
	}
	public Enrollment(int enrollmentId, int studentId, int batchId) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.batchId = batchId;
	}
    
	
   
}

