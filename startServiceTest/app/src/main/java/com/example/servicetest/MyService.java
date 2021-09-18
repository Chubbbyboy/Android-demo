package com.example.servicetest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.io.IOException;

public class MyService extends Service {
    private static boolean serviceIsLive;
    private final String TAG = "MyService";
    private MediaPlayer mediaPlayer;
    private int startId;

    public enum Control {PLAY, PAUSE, STOP}

    ;

    public MyService() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        String ID = "com.example.servicetest"; //这里的id里面输入自己的项目的包的路径
        String NAME = "Channel One";
        if (mediaPlayer == null) {
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource("/sdcard/Music/123.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
        }
        Notification.Builder builder;//获取一个Noification构造器
        Intent intent = new Intent(this, MainActivity.class);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(ID, NAME, manager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setShowBadge(true);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            manager.createNotificationChannel(channel);
            builder = new Notification.Builder(this.getApplicationContext()).setChannelId(ID);
        } else {
            builder = new Notification.Builder(MyService.this);
        }
        builder.setContentIntent(PendingIntent.getActivity(this, 0, intent, 0))//设置PendingIntent
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher))//设置下拉列表的图标(大图标)
                .setContentTitle("音乐播放器")//设置标题
                .setSmallIcon(R.mipmap.ic_launcher)//设置状态栏的小图标
                .setContentText("正在播放")//设置上下文内容
                .setWhen(System.currentTimeMillis());//设置该通知发生的时间
        Notification notification = builder.build();
        startForeground(110, notification);
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.startId = startId;
        MyService.serviceIsLive = true;
        Log.d(TAG, "onStartCommand: ------startId:" + startId);
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            Control control = (Control) bundle.getSerializable("Key");
            if (control != null) {
                switch (control) {
                    case PLAY:
                        play();
                        break;
                    case PAUSE:
                        pause();
                        break;
                    case STOP:
                        stop();
                        break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            ;
            mediaPlayer.release();
        }
        MyService.serviceIsLive = false;
        stopForeground(true);
        super.onDestroy();
    }

    private void play() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        stopSelf(startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}