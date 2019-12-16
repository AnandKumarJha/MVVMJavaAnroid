package com.example.mvvmjavaandroid.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.workmanager.MyWorker;

import java.util.concurrent.TimeUnit;

public class WorkManagerActivity extends AppCompatActivity {

    WorkManager workManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);

        workManager = WorkManager.getInstance();
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.
                Builder(MyWorker.class).
                build();

        Constraints constraints = new Constraints
                .Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(MyWorker.class, 15, TimeUnit.SECONDS)
                .setConstraints(constraints).build();

        Button startWorkManger = findViewById(R.id.btn_start_work_manager);

        startWorkManger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workManager.enqueue(oneTimeWorkRequest);
                workManager.enqueue(periodicWorkRequest);
            }
        });

        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Toast.makeText(WorkManagerActivity.this, "" +
                        workInfo.getState() + " " + workInfo.getOutputData().getString("MyName"),
                        Toast.LENGTH_LONG).show(); // prints "Anand Kumar Jha"
            }
        });
    }
}
