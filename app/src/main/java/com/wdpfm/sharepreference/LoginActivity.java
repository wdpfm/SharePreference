package com.wdpfm.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText eUsername,ePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eUsername=findViewById(R.id.username);
        ePassword=findViewById(R.id.password);

        //SharePreference的读取
        //1.获取SharePreference对象
        SharedPreferences share=getSharedPreferences("myshare",MODE_PRIVATE);
        //2.根据key获取内容
        String oldUsername=share.getString("username","");
        String oldPassword=share.getString("password","");

        eUsername.setText(oldUsername);
        ePassword.setText(oldPassword);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=eUsername.getText().toString();
                String password=ePassword.getText().toString();
                //存储信息到SharePreference
                //1.获取SharePreference对象
                SharedPreferences share=getSharedPreferences("myshare",MODE_PRIVATE);
                //2.获取Editor对象
                SharedPreferences.Editor editor=share.edit();
                //3.存储信息
                editor.putString("username",username);
                editor.putString("password",password);
                //4.提交
                editor.commit();
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
