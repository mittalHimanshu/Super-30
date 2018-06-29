package com.example.phoenix.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name1, password1, email1, phone1;
    private Button button;
    private String name, password, email, phone, value, value1;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("myPreferenc", Context.MODE_PRIVATE);
        value = sharedPreferences.getString("Username", null);
        value1 = sharedPreferences.getString("Password", null);
        name1 = (EditText) findViewById(R.id.name);
        password1 = (EditText) findViewById(R.id.password);
        email1 = (EditText) findViewById(R.id.email);
        phone1 = (EditText) findViewById(R.id.phone);
        if(value == null || value1 == null){
            button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = name1.getText().toString();
                    password = password1.getText().toString();
                    email = email1.getText().toString();
                    phone = phone1.getText().toString();
                    SharedPreferences.Editor writer = sharedPreferences.edit();
                    writer.putString("Username", name);
                    writer.putString("Password", password);
                    writer.commit();
                    Toast.makeText(getApplicationContext(), "Save Successful", Toast.LENGTH_SHORT).show();
                    value = sharedPreferences.getString("Username", null);
                    value1 = sharedPreferences.getString("Password", null);
                    Intent i = new Intent(MainActivity.this, LoginActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Username", value);
                    bundle.putString("Password", value1);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });
        }
        else{
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Username", value);
            bundle.putString("Password", value1);
            i.putExtras(bundle);
            startActivity(i);
        }
    }
}
