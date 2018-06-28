package com.example.phoenix.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username1, password1;
    private Button button;
    private String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("Username");
        password = bundle.getString("Password");
        username1 = (EditText) findViewById(R.id.name);
        password1 = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                if(user.equals("") && pass.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Username/Password", Toast.LENGTH_SHORT).show();
                }
                else if(user.equals(username) && pass.equals(password)){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Check Username/Password and Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
