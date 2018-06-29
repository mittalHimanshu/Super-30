package com.example.phoenix.sharedpreferences;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private String name, password;
    private EditText username2, password2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username2 = (EditText) findViewById(R.id.name);
        password2 = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.button);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("Username");
        password = bundle.getString("Password");
        username2.setText(name);
        password2.setText(password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
