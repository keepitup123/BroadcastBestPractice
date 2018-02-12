package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zhu on 2018/2/9.
 */

public class ForceOffLineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
       builder.setTitle("下线通知").setMessage("您已经在别处登陆，请重新登陆").setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               AcivityCollector.finishAll();
               Log.d("ForceOffLineReceiver", "onClick: ");
               Intent intent1 = new Intent(context,LoginActivity.class);
               context.startActivity(intent1);
           }
       }).show();
    }
}
