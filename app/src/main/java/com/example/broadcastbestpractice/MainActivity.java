package com.example.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
public static final String  force ="com.example.broadcastbestpractice.FORCE_OFFLINE";
    private Button forceOffline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forceOffline = findViewById(R.id.main_btn);
        //forceOffline.setOnClickListener(new );
    }
    public void forceClick(View view){
      switch (view.getId()){
          case R.id.main_btn:
              //发出下线广播
              Intent intent = new Intent(force);
              sendBroadcast(intent);
              break;
      }
    }
}
