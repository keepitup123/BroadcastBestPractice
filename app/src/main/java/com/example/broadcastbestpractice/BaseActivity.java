package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    public static final String force = "com.example.broadcastbestpractice.FORCE_OFFLINE";
    ForceOffLineReceiver forceOffLineReceiver;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AcivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(force);
        forceOffLineReceiver = new ForceOffLineReceiver();
        registerReceiver(forceOffLineReceiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(forceOffLineReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AcivityCollector.removeAcyivity(this);
    }

    class ForceOffLineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("下线通知").setMessage("您已经在别处登陆，请重新登陆").setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AcivityCollector.finishAll();
                    Log.d("ForceOffLineReceiver", "----onClick----: ");
                    Intent intent1 = new Intent(context,LoginActivity.class);
                    context.startActivity(intent1);
                }
            }).show();
        }
    }
}
