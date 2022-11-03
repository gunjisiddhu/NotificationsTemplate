package com.example.notificationtemplate;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotifyService extends BroadcastReceiver {
    private static final String PERIODS_NOTIFICATION_ID = "10002";

    @Override
    public void onReceive(Context context, Intent mIntent) {


        Bundle bundle = mIntent.getBundleExtra("bundle");
        String type_of_notif = bundle.getString("type_of_notif");

        if(type_of_notif!=null && type_of_notif.equalsIgnoreCase("period")){
            sendPeriodReminder(context,mIntent,bundle.getInt("period"));
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

        *//*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
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
        }*//*
        assert mNotificationManager != null;
        mNotificationManager.notify(0 *//* Request Code *//*, mBuilder.build());*/


    }

    private void sendPeriodReminder(Context context, Intent mIntent,int period) {
        Intent intent = new Intent(context , MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0 , intent,0);


        //int period = mIntent.getIntExtra("period",0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, PERIODS_NOTIFICATION_ID);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("Lopala"+period)
                .setContentText("Content")
                .setAutoCancel(false)
                .setVibrate(new long[]{100,200,300,400})
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
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
        }*/
        assert mNotificationManager != null;
        mNotificationManager.notify(0 /* Request Code */, mBuilder.build());


        /*NotificationManagerCompat notificationCompat = NotificationManagerCompat.from(context);
        notificationCompat.notify(1,mBuilder.build());*/





    }
}