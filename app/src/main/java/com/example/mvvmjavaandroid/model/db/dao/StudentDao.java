package com.example.mvvmjavaandroid.model.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mvvmjavaandroid.model.db.entity.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    public void insert(Student student);

    @Delete
    public void delete(Student student);

    @Update
    public void update(Student student);

    @Query("DELETE FROM Student_table")
    void deleteAll();

    @Query("SELECT * from Student_table ORDER BY roll_num ASC")
    LiveData<List<Student>> getAllStudents();

}
