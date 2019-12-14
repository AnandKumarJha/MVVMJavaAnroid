package com.example.mvvmjavaandroid.model.db.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmjavaandroid.model.db.dao.StudentDao;
import com.example.mvvmjavaandroid.model.db.entity.Student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao getStudentDao();


    private static StudentDatabase instance;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static StudentDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (StudentDatabase.class) {
                instance = Room.databaseBuilder(context, StudentDatabase.class, "StudentDatabase").build();
            }
        }
        return instance;
    }
}
