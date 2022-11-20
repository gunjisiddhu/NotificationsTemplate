package com.example.notificationtemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


//https://stackoverflow.com/questions/8833399/changing-java-date-one-hour-back
//https://stackoverflow.com/questions/11882102/adding-a-day-to-a-calendar-in-android-fails-on-31st
//https://stackoverflow.com/questions/45761029/how-to-set-an-alarm-inside-a-broadcastreceiver
//https://stackoverflow.com/questions/15221295/alarmmanager-inside-broadcastreceiver-when-boot-completed

public class MainActivity extends AppCompatActivity {

    private static final String PERIODS_NOTIFICATION_ID = "10002";
    Button insert,update,delete,print;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createChannels();
        setNotificationAlerts();




        dbHelper = new DBHelper(this);


        insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertData("Mon","Weekly Test","Weekly Test","Library","ML(T)","Library","SCIRP","ScIRP");
                dbHelper.insertData("Tue","SCIRP","SCIRP","BDA","BDA","Library","Library","Library");
                dbHelper.insertData("Wed","CC LAB","CC LAB","BDA","CC","Library","ML","Counselling");
                dbHelper.insertData("Thu","ML","ML(T)","Library","CC","Counselling","SCIRP","SCIRP");
                dbHelper.insertData("Fri","ML","Library","BDA","CC","Library","BDA Lab","BDA Lab");
                dbHelper.insertData("Sat","Library","Library","SCIRP","SCIRP","SCIRP","Library","Library");


            }
        });

        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateuserdata("Tue","SCIRP","sCIRP","ML","BDA","Library","Library","ScIRP");
                //dbHelper.insertData("Wed","WT1","WT2","ML","BDA","Library","Library","ScIRP");
            }
        });
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deletedata("Wed");
                dbHelper.deletedata("Tue");
                dbHelper.deletedata("Mon");
            }
        });
        print = findViewById(R.id.print);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dbHelper.getdata();
                while(cursor.moveToNext()){
                    for(int i=0;i<8;i++){
                        System.out.print(cursor.getString(i)+" ");
                    }

                    System.out.println();
                }



            }
        });


    }

    private void setNotificationAlerts() {
        setNotificationAlert1();
        setNotificationAlert2();
        setNotificationAlert3();
        setNotificationAlert4();
        setNotificationAlert5();
        setNotificationAlert6();
        setNotificationAlert7();
    }


    private void setNotificationAlert1() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE,55);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",1);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }


    private void setNotificationAlert2() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE,50);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",2);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 102, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }

    private void setNotificationAlert3() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE,5);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",3);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 103, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }

    private void setNotificationAlert4() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",4);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 104, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }

    private void setNotificationAlert5() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE,55);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",5);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 105, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }

    private void setNotificationAlert6() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE,50);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",6);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 106, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }

    private void setNotificationAlert7() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        calendar.set(Calendar.MINUTE,45);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        Intent intent = new Intent(getApplicationContext(), NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",7);
        bundle.putString("type_of_notif","period");


        intent.putExtra("bundle",bundle);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 107, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  pendingIntent);
            }
        }else{
            Toast.makeText(this, "Not working", Toast.LENGTH_SHORT).show();
        }



    }

    private void createChannels(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_NOTIFICATION).build();
            //String description = mContext.getString(R.string.default_notification_channel_description);

            NotificationManager mNotificationManager = getSystemService(NotificationManager.class);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(PERIODS_NOTIFICATION_ID, "Period Notify Channel", importance);
            notificationChannel.enableLights(true);
            notificationChannel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI,attributes);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            //NotificationChannel.setDescription("Period Notification");
            notificationChannel.setBypassDnd(true);
            notificationChannel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            notificationChannel.setShowBadge(true);


            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel);

        }
    }

    /*private void sendNotificationAleret2(){
        Toast.makeText(this, "Hello!!", Toast.LENGTH_SHORT).show();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,8);
        calendar.set(Calendar.MINUTE,13 );
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND,0);

        if (calendar.getTime().compareTo(new Date()) < 0)
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        //https://stackoverflow.com/questions/11882102/adding-a-day-to-a-calendar-in-android-fails-on-31st


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



    }*/
}