package com.example.phoenix.mynotesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import static com.example.phoenix.mynotesapp.NoteActivity.editor;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    NoteAdapter noteAdapter;
    static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ffttrr", "hi");
        sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        listView = (ListView) findViewById(R.id.main_listview);
        noteAdapter = new NoteAdapter();
        try{
            if(NoteActivity.checkStatus()){
                listView.setAdapter(noteAdapter);
            }
        }
        catch(Exception e){Log.d("ffttrr", e.getMessage());}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add: {
                Intent i = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(i);
            }
        }
        return true;
    }

}
