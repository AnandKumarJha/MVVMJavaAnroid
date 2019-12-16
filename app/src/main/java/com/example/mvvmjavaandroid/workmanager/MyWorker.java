package com.example.mvvmjavaandroid.workmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.mvvmjavaandroid.R;

import java.io.DataOutput;

public class MyWorker extends Worker {

    Context mContext;
    private String channelId = "ChannelId";

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        mContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Data data = getInputData();
        String yourName = data.getString("YourName");
        String channelId = "task_channel";
        String channelName = "task_name";

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), channelId);
        notificationBuilder.setContentTitle("Hello world");
        notificationBuilder.setContentText("This is testing");
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background);

        notificationManager.notify(0, notificationBuilder.build());

        Data dataOutput = new Data.Builder().putString("MyName", "Anand Kumar Jha").build();
        return Result.success(dataOutput);
    }
}
