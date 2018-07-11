package com.example.phoenix.mynotesapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmHandler extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.notification);
        mediaPlayer.start();
        intent = new Intent(context, MainActivity.class);
        PendingIntent intent1 = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.icon);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon));
        builder.setContentTitle("It's Time !!!");
        builder.setContentText("Click to open MyNotes and see your Note");
        builder.setContentIntent(intent1);
        builder.setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
