package com.example.phoenix.note_making;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ShowNotes extends AppCompatActivity {
    private Bundle bundle;
    String subject;
    DatabaseHandler db;
    ListView showNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notes);
        showNotes = (ListView) findViewById(R.id.showNotes);
        bundle = getIntent().getExtras();
        subject = bundle.getString("Subject");
        db = new DatabaseHandler(subject, this);
        showNotes.setAdapter(db.getNotes());
    }
}
