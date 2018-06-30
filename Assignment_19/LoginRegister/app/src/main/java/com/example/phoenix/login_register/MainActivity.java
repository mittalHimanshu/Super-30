package com.example.phoenix.login_register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name1, email1, phone1, password1;
    String name, email, phone, password;
    static DatabaseHandler obj;
    static SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1 = (EditText) findViewById(R.id.name);
        email1 = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password);
        phone1 = (EditText) findViewById(R.id.phone);
        sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE);
        obj = new DatabaseHandler(this);
        if(obj.checkDB()){
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }

    public void createDb(View view) {
        name = name1.getText().toString();
        email = email1.getText().toString();
        phone = phone1.getText().toString();
        password = password1.getText().toString();
        obj.createDB(name, email, phone, password);
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
