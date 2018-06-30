package com.example.phoenix.note_making;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNote(View view) {
        Intent i = new Intent(MainActivity.this, SubjectActivity.class);
        startActivity(i);
    }

    public void viewNote(View view) {
        Intent i = new Intent(MainActivity.this, ShowSubjectActivity.class);
        startActivity(i);
    }
}
