package com.example.phoenix.login_register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.phoenix.login_register.MainActivity.obj;

public class ShowDataActivity extends AppCompatActivity {

    private TextView name3, email3, phone3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        name3 = (TextView) findViewById(R.id.name);
        email3 = (TextView) findViewById(R.id.email);
        phone3 = (TextView) findViewById(R.id.phone);
        name3.setText(obj.getUsername());
        email3.setText(obj.getEmail());
        phone3.setText(obj.getPhone());
    }
}
