package com.example.phoenix.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name1, address1, email1, phone1, password1;
    private String name, address, email, phone, password;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1 = (EditText) findViewById(R.id.name);
        address1 = (EditText) findViewById(R.id.address);
        email1 = (EditText) findViewById(R.id.email);
        phone1 = (EditText) findViewById(R.id.phone);
        password1 = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = name1.getText().toString();
                address = address1.getText().toString();
                email = email1.getText().toString();
                phone = phone1.getText().toString();
                password = password1.getText().toString();
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Username", name);
                bundle.putString("Password", password);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
