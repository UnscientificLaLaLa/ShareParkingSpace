package com.zhaohao.shareparkingspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "LoginActivity";
    EditText usernameEt,passwordEt;
    Button loginBt,signupBt;
    TextView loginTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEt = findViewById(R.id.usernameEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBt = findViewById(R.id.loginBt);
        signupBt = findViewById(R.id.signupBt);
        loginTv = findViewById(R.id.loginTv);
        loginBt.setOnClickListener(this);
        signupBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginBt:
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormBody.Builder()
                        .add("username",usernameEt.getText().toString())
                        .add("password",passwordEt.getText().toString())
                        .build();
                final Request request = new Request.Builder()
                        .url(MyApi.login)
                        .post(requestBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String json = response.body().string();
                        handler.sendEmptyMessage(2);
                    }
                });
                break;
            case R.id.signupBt:
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                intent.putExtra("username",usernameEt.getText());
                startActivity(intent);
        }
    }

    Handler handler = new Handler(){
        
    };

}
