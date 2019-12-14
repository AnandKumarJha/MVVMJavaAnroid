package com.example.mvvmjavaandroid.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmjavaandroid.model.StudentRepository;
import com.example.mvvmjavaandroid.model.db.entity.Student;

import java.util.List;

public class StudentViewModel extends ViewModel {
    private StudentRepository studentRepository;

    public StudentViewModel(Application application) {
        studentRepository = new StudentRepository(application);
    }

    public LiveData<List<Student>> getStudentList() {
        return studentRepository.getAllStudent();
    }

    public void insertStudent() {
        studentRepository.insert(new Student(0, "anand", "1234"));
    }

    public void deleteStudent() {
        studentRepository.insert(new Student(0, "anand", "1234"));
    }

    public void updateStudent() {
        studentRepository.insert(new Student(0, "anand", "1234"));
    }
}
