package com.example.tech_start;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPassword;
    private Button login;
    private ProgressDialog progressDialog;
    private ApiInterface mAPIService;
    private TextView gotoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);


        mAPIService = ApiUtils.getAPIService();
        gotoRegister = (TextView) findViewById(R.id.gotoregister);

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                progressDialog = new ProgressDialog(MainActivity.this);

                //checking if email and passwords are empty
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_LONG).show();
                    return;
                }

                progressDialog.setMessage("Logging in, Please wait ......");
                progressDialog.show();

                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                MainUser mainUser=new MainUser(password,email);
                Call<MainUser> calldash = mAPIService.signInUser(mainUser);
                String strcheck="ashish";
                calldash.enqueue(new Callback<MainUser>() {
                    @Override
                    public void onResponse(Call<MainUser> call, Response<MainUser> response) {
                        progressDialog.dismiss();
                        Log.e("htyu", "entered");
                        int code =response.code();
                        if(response.isSuccessful()) {
                            Log.e("htyu", "success");
                            if(response.body() == null){
                                Toast.makeText(MainActivity.this, "NULL response", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "response not successful"+response.code(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MainUser> call, Throwable t) {
//                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Failure"+t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
