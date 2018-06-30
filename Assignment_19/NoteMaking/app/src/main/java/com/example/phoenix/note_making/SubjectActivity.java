package com.example.phoenix.note_making;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubjectActivity extends AppCompatActivity {

    private EditText subName;
    private Button next;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        bundle = getIntent().getExtras();
        subName = (EditText) findViewById(R.id.subjectName);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(subName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Enter a Subject", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(SubjectActivity.this, ListViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject", subName.getText().toString());
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });
    }
}
