package com.example.notificationtemplate;

import static android.content.Context.ALARM_SERVICE;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class NotifyService extends BroadcastReceiver {
    private static final String PERIODS_NOTIFICATION_ID = "10002";

    DBHelper dbHelper;

    @Override
    public void onReceive(Context context, Intent mIntent) {

        Log.e("Bro NOTIFICATION APP",new Date().toString());

        dbHelper = new DBHelper(context);
        Bundle bundle = mIntent.getBundleExtra("bundle");
        String type_of_notif = bundle.getString("type_of_notif");

        if(type_of_notif!=null && type_of_notif.equalsIgnoreCase("period")){
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_WEEK);

            switch (day) {
                case Calendar.SUNDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Mon");
                    break;
                case Calendar.MONDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Mon");
                    break;
                case Calendar.TUESDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Tue");
                    break;
                case Calendar.WEDNESDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Wed");
                    break;
                case Calendar.THURSDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Thu");
                    break;
                case Calendar.FRIDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Fri");
                    break;
                case Calendar.SATURDAY:
                    sendPeriodReminder(context,mIntent,bundle.getInt("period"),"Sat");
                    break;
            }



            //sendPeriodReminder(context,mIntent,bundle.getInt("period"));
        }

        /*Intent intent = new Intent(context , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0 , intent,0);


        //int period = mIntent.getIntExtra("period",0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, PERIODS_NOTIFICATION_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Next Period :"+type_of_notif+"  "+bundle.getInt("period"))
                .setContentText("Content")
                .setAutoCancel(false)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(PERIODS_NOTIFICATION_ID, "NOTIFICATION_CHANNEL_NAME", importance);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            assert mNotificationManager != null;
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(0 *//* Request Code *//*, mBuilder.build());*/

       // WakeLocker.release();

    }

    private void sendPeriodReminder(Context context, Intent mIntent,int period,String day) {
        Intent intent = new Intent(context , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0 , intent,0);


        Cursor cursor = dbHelper.getDayData(day);
        if(cursor.getCount() > 0){
            cursor.moveToNext();
            String next_period = cursor.getString(period);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, PERIODS_NOTIFICATION_ID);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setContentTitle("Next Period : "+next_period)
                    .setContentText("Content")
                    .setAutoCancel(false)
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setVibrate(new long[]{100,200,300,400})
                    .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                    .setContentIntent(resultPendingIntent);

            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            assert mNotificationManager != null;
            mNotificationManager.notify(0 /* Request Code */, mBuilder.build());


            switch (period){
                case 1:
                    setNextNotification1(context);
                    break;
                case 2:
                    setNextNotification2(context);
                    break;
                case 3:
                    setNextNotification3(context);
                    break;
                case 4:
                    setNextNotification4(context);
                    break;
                case 5:
                    setNextNotification5(context);
                    break;
                case 6:
                    setNextNotification6(context);
                    break;
                case 7:
                    setNextNotification7(context);
                    break;
            }




        }


        //int period = mIntent.getIntExtra("period",0);
        /*NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, PERIODS_NOTIFICATION_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Lopala"+period)
                .setContentText("Content")
                .setAutoCancel(false)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{100,200,300,400})
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        assert mNotificationManager != null;
        mNotificationManager.notify(0 *//* Request Code *//*, mBuilder.build());



        setNextNotification(context);*/


    }


    private void setNextNotification1(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",1);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 191, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

    private void setNextNotification2(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",2);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 192, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

    private void setNextNotification3(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",3);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 193, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

    private void setNextNotification4(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",4);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 194, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

    private void setNextNotification5(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",5);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 195, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

    private void setNextNotification6(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",6);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 196, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

    private void setNextNotification7(Context context){

        Calendar cal = Calendar.getInstance();
        Log.e("calender Printed this",cal.toString());
        cal.add(Calendar.DAY_OF_YEAR, 1);
        Log.e("calender Printed this",cal.toString());


        Intent srvIntent = new Intent(context, NotifyService.class);
        Bundle bundle = new Bundle();
        bundle.putInt("period",7);
        bundle.putString("type_of_notif","period");
        //intent.putExtra("period",1);
        //intent.putExtra("type","period");
        srvIntent.putExtra("bundle",bundle);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 197, srvIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Use context argument to access service
        AlarmManager alarm =
                (AlarmManager)context.getSystemService(ALARM_SERVICE);

        // Repeat every 5 seconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),  pIntent);
        }

    }

}
