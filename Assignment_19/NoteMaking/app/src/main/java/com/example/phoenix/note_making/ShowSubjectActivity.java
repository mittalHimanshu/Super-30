package com.example.phoenix.note_making;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowSubjectActivity extends AppCompatActivity {
    ListView showSubject;
    DatabaseHandler db1;
    ArrayList<String> notes = new ArrayList<>();
    ArrayAdapter<String> adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_subject);
        try{
            showSubject = (ListView) findViewById(R.id.showSubject);
            db1 = new DatabaseHandler(this);
            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, db1.getSubjects());
            showSubject.setAdapter(adapter1);
            showSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent in = new Intent(ShowSubjectActivity.this, ShowNotes.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Subject", (String) showSubject.getItemAtPosition(i));
                    in.putExtras(bundle);
                    startActivity(in);
                }
            });
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Add a Note First", Toast.LENGTH_SHORT).show();
        }
    }
}
