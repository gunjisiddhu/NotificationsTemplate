package com.example.notificationtemplate;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class NotificationChannels extends Application {
    public static final String CHANNEL_1_ID = "1001";
    public static final String CHANNEL_2_ID = "1002";
    public static final String CHANNEL_3_ID = "1003";
    public static final String CHANNEL_4_ID = "1004";

    private static final String PERIODS_NOTIFICATION_ID = "10002";
    @Override
    public void onCreate() {
        super.onCreate();

        createChannels();
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
                notificationChannel.setImportance(NotificationManager.IMPORTANCE_HIGH);
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
}
