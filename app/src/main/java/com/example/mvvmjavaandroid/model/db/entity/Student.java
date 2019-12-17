package com.example.mvvmjavaandroid.model.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student_table")
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "roll_num")
    private int rollNumber;


    @ColumnInfo(name = "student_name")
    private String studentName;

    @ColumnInfo(name = "phone")
    private String phoneNumber;

    public Student(int rollNumber, String studentName, String phoneNumber) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Roll Number : "+rollNumber+" Name : "+ studentName+" Phone : "+ phoneNumber+"\n";
    }
}
