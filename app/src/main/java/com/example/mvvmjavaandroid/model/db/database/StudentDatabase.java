package com.example.mvvmjavaandroid.model.db.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                instance = Room.databaseBuilder(context, StudentDatabase.class, "StudentDatabase").addCallback(callback)/*.addMigrations(MIGRATION_1_2)*/.build();
            }
        }
        return instance;
    }

    //for migrating from version 1 to 2 in case a new field is added fro the table
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Student_table "
                    + " ADD COLUMN DOB INTEGER");
        }
    };

    //To add some data on the time of creation of database
    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.e("TAG", "SSSS");
            if(instance!=null){
                executorService.execute(()->{
                    Student s = new Student(0, "jha kumar anand", "9210363639");
                    instance.getStudentDao().insert(s);
                    instance.getStudentDao().insert(s);
                    instance.getStudentDao().insert(s);
                });

            }
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            //Every time when the application closed by removing from memory and open the database by read or write operation on DB
            Log.e("TAG", "wwww");
            if(instance!=null){
                executorService.execute(()->{
                    Student s = new Student(0, "open jha kumar anand", "9210363639");
                    instance.getStudentDao().insert(s);
                    instance.getStudentDao().insert(s);
                    instance.getStudentDao().insert(s);
                });

            }
        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
        }
    };
}
