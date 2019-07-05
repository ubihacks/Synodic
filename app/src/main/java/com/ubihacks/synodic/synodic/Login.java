package com.ubihacks.synodic.synodic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wang.avi.AVLoadingIndicatorView;

public class Login extends AppCompatActivity {

    private AVLoadingIndicatorView loginLoading;
    private LinearLayout loginView;
    private ImageView imageView;
    private TextInputEditText email;
    private TextInputEditText password;
    private CheckBox rememberPass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initView();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,MainActivity.class));
                finish();
            }
        });
    }

    private void initView() {
        loginLoading = (AVLoadingIndicatorView) findViewById(R.id.loginLoading);
        loginView = (LinearLayout) findViewById(R.id.loginView);
        imageView = (ImageView) findViewById(R.id.imageView);
        email = (TextInputEditText) findViewById(R.id.email);
        password = (TextInputEditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.rememberPass);
        login = (Button) findViewById(R.id.login);
    }
}
