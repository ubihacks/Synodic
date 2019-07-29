package com.ubihacks.synodic.synodic.ACTIVITIES;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ubihacks.synodic.synodic.API.Api;
import com.ubihacks.synodic.synodic.API.DataReceived;
import com.ubihacks.synodic.synodic.MODEL.User;
import com.ubihacks.synodic.synodic.MainActivity;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.R;
import com.ubihacks.synodic.synodic.utils.PrefUtils;
import com.ubihacks.synodic.synodic.utils.actions;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.KEY_LOGGED;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.KEY_TOKEN;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private AVLoadingIndicatorView loginLoading;
    private LinearLayout loginView;
    private ImageView imageView;
    private TextInputEditText email;
    private TextInputEditText password;
    private CheckBox rememberPass;
    private Button login;

    PrefUtils prefs;
    Api api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        prefs = PrefUtils.getInstance(getApplicationContext());
        api = MyApp.getApi();

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        loginLoading.hide();

        login.setOnClickListener(this);
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

    private void login(final String email, final String password) {
        Call<User> checkLogin = api.login(email,password);

        checkLogin.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                //startActivity(new Intent(LoginActivity.this,MainActivity.class));
                MyApp.user = response.body();

                if(MyApp.user!= null) {
                    MyApp.dataProvider.initializeDevices(new DataReceived() {
                        @Override
                        public void Success() {
                            MyApp.dataProvider.getCurrentDriverStatus(new DataReceived() {
                                @Override
                                public void Success() {
                                    MyApp.dataProvider.getCurrentDayDriverStatus(new DataReceived() {
                                        @Override
                                        public void Success() {
                                            actions.calculateHOS();
                                            if(rememberPass.isChecked()){
                                                prefs.saveToPrefs(KEY_LOGGED,true);
                                                prefs.saveToPrefs(KEY_TOKEN,MyApp.user.getToken());
                                            }
                                            startActivity(new Intent(Login.this, MainActivity.class));

                                            loginLoading.hide();
                                            finish();
                                        }
                                    });
                                }
                            });


                        }
                    });
                }
                else{
                    Toast.makeText(Login.this, "Login credentials are wrong, Please try again", Toast.LENGTH_SHORT).show();
                    loginLoading.hide();
                    loginView.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(Login.this, t.toString(), Toast.LENGTH_SHORT).show();


                loginLoading.hide();
                loginView.setVisibility(View.VISIBLE);
            }
        });
    }

    public void hideKeybord(View view) {
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }

    @Override
    public void onClick(View v) {

        if(v == login) {
            hideKeybord(v);
            loginView.setVisibility(View.GONE);
            loginLoading.show();
            login(email.getText().toString(), password.getText().toString());
        }
    }

}
