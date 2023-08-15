package com.example.a01_alarm_clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

// Dùng để nhận các inten từ hệ thống, trao đổi dữ liệu giữa hai hoặc nhiều ứng dụng với nhau
// ====> Cần phải khai báo trong file AndroidManifest để có thể sử dụng được
public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Done_", "Đã thực hiện thành công rồi!");
        Intent Call_Service = new Intent(context, Service.class);
        context.startService(Call_Service);
//        Intent callServiceIntent = new Intent(context, ForegroundService.class);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context.startForegroundService(callServiceIntent);
//        } else {
//            context.startService(callServiceIntent);
//        }
    }
}
