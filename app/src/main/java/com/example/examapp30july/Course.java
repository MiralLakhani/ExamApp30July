package com.example.examapp30july;

public class Course {
    private String courseName;
    private double fees;
    private int hours;

    public Course(String courseName, double fees, int hours) {
        this.courseName = courseName;
        this.fees = fees;
        this.hours = hours;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getFees() {
        return fees;
    }

    public int getHours() {
        return hours;
    }
}
