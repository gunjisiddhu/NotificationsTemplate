package com.example.notificationtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setNotificationAlert();
        sendNotificationAleret2();

    }

    private void sendNotificationAleret2(){
        Toast.makeText(this, "Hello!!", Toast.LENGTH_SHORT).show();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE,20);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Log.e("caldemd",calendar.getTime()+"");
        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",2);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }else{
            Toast.makeText(this, "ok avvaledu", Toast.LENGTH_SHORT).show();
        }



    }

    private void setNotificationAlert() {
        Toast.makeText(this, "Hello!!", Toast.LENGTH_SHORT).show();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 6);
        calendar.set(Calendar.MINUTE,19);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Log.e("caldemd",calendar.getTime()+"");
        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",1);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 5, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }else{
            Toast.makeText(this, "ok avvaledu", Toast.LENGTH_SHORT).show();
        }



    }
}