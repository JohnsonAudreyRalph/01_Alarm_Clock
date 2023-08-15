package com.example.a01_alarm_clock;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Service extends android.app.Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.nhachuong);
        mediaPlayer.start();
        Log.e("Done_", "Đã nhận được thông tin từ Receiver");
        return START_NOT_STICKY;
    }
}
