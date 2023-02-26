package model;

public class Batch {
    private int batchId;
    private int courseId;
    private int totalSeats;
    private int availableSeats;
    
    public Batch() {}
    
    public Batch(int batchId, int courseId, int totalSeats, int availableSeats) {
        this.batchId = batchId;
        this.courseId = courseId;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }
    
    // getters and setters
    public int getBatchId() {
        return batchId;
    }
    
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }
    
    public int getCourseId() {
        return courseId;
    }
    
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }
    
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    public int getAvailableSeats() {
        return availableSeats;
    }
    
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

