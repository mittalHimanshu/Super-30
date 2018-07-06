package com.example.phoenix.mynotesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter = new NoteAdapter();
        if (noteAdapter.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Notes Empty", Toast.LENGTH_SHORT).show();
        }
        listView = (ListView) findViewById(R.id.main_listview);
        listView.setAdapter(noteAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Note n;
                n = (Note) listView.getItemAtPosition(i);
                Intent in = new Intent(MainActivity.this, NoteActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", n.getTitle());
                bundle.putString("content", n.getContent());
                bundle.putString("dateTime", n.getDateTime());
                bundle.putInt("selection", i);
                in.putExtras(bundle);
                startActivity(in);
            }
        });

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
