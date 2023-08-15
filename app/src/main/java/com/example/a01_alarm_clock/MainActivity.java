package com.example.a01_alarm_clock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker TimePicker;
    Button Alarm_on;
    Button Alarm_off;
    TextView textView;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePicker = findViewById(R.id.timePicker);
        Alarm_on = findViewById(R.id.Alarm_on);
        Alarm_off = findViewById(R.id.Alarm_off);
        textView = findViewById(R.id.textView);
        calendar = Calendar.getInstance(); // Lấy ngày giờ hiện tại
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE); // Cho phép truy cập vào hệ thống báo động của máy, ALARM_SERVICE là hàm báo thức của máy
        Intent intent = new Intent(this, Receiver.class);

        Alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY, TimePicker.getHour());
                calendar.set(Calendar.MINUTE, TimePicker.getMinute());

                int Gio = TimePicker.getHour();
                int Phut = TimePicker.getMinute();
                String String_Gio = String.valueOf(Gio);
                String String_Phut = String.valueOf(Phut);

                if(Gio < 10){
                    String_Gio = "0" + Gio;
                }
                if (Phut < 10){
                    String_Phut = "0" + Phut;
                }

                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
//                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                textView.setText("Thời gian lấy được là: \n" + String_Gio + " : " + String_Phut);
                Log.e("Done_", "Thời gian đã lấy được là: " + String_Gio + " : " + String_Phut);
            }
        });

        Alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Đã ấn nút OFF");
            }
        });
    }
}