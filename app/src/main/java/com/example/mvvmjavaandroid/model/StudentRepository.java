package com.example.mvvmjavaandroid.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mvvmjavaandroid.model.db.dao.StudentDao;
import com.example.mvvmjavaandroid.model.db.database.StudentDatabase;
import com.example.mvvmjavaandroid.model.db.entity.Student;

import java.util.List;

public class StudentRepository {

    private LiveData<List<Student>> studentList;
    private StudentDatabase studentDatabase;
    private StudentDao studentDao;

    public StudentRepository(Application application) {
        studentDatabase = StudentDatabase.getInstance(application);
        studentDao = studentDatabase.getStudentDao();
        studentList = studentDao.getAllStudents();
    }

    public LiveData<List<Student>> getAllStudent() {
        return studentList;
    }

    public void insert(Student student) {
        StudentDatabase.executorService.execute(() -> {
            studentDao.insert(student);
        });

    }

    public void delete(Student student) {
        StudentDatabase.executorService.execute(new Runnable() {
            @Override
            public void run() {
                studentDao.delete(student);
            }
        });

    }

    public void update(Student student) {
        StudentDatabase.executorService.execute(() -> {
            studentDao.update(student);
        });

    }
}
