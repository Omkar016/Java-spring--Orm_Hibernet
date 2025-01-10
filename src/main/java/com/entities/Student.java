package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  // This matches auto_increment behavior
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_city")
    private String studentCity;

    @Column(name = "student_name")
    private String studentName;

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public Student(int studentId, String studentName, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }
    // Constructors
    public Student() {
        super();
    }
}
