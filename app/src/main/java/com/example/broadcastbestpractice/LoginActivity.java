package com.example.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText mAccountEdit,mPasswordEdit;
    private Button mLoginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAccountEdit = findViewById(R.id.account);
        mPasswordEdit = findViewById(R.id.password);
        mLoginbutton = findViewById(R.id.login_button);
        mLoginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String accout = mAccountEdit.getText().toString();
               String password = mPasswordEdit.getText().toString();
               if(accout.equals("zhuhongxi")&&password.equals("1215637936")){
                   Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                   startActivity(intent);
                   finish();
               }else{
                   Toast.makeText(LoginActivity.this,"账号或密码错误，请重新输入",Toast.LENGTH_LONG).show();
                   mAccountEdit.getText().clear();
                   mPasswordEdit.getText().clear();
               }
            }
        });
    }
}
