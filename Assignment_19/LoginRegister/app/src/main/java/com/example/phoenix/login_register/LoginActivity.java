package com.example.phoenix.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.phoenix.login_register.MainActivity.obj;

public class LoginActivity extends AppCompatActivity {

    private EditText username2, password2;
    private TextView newUser;
    Button button2;
    DatabaseHandler obj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button2 = (Button) findViewById(R.id.button2);
        username2 = (EditText) findViewById(R.id.name);
        password2 = (EditText) findViewById(R.id.password);
        newUser = (TextView) findViewById(R.id.newUser);
        obj1 = new DatabaseHandler(this);

        username2.setText(obj.getUsername());
        password2.setText(obj.getPassword());

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obj1.validateData(username2.getText().toString(), password2.getText().toString())){
                    Intent i = new Intent(LoginActivity.this, ShowDataActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Check Username/ Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj1.setFalse();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
