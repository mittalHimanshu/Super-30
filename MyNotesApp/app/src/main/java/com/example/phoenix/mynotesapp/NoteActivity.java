package com.example.phoenix.mynotesapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import static com.example.phoenix.mynotesapp.MainActivity.sharedPreferences;

public class NoteActivity extends AppCompatActivity {
    EditText title_edit, body_edit;
    static SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        title_edit = (EditText) findViewById(R.id.title_edit);
        body_edit = (EditText) findViewById(R.id.body_edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.save:
            {
                editor = sharedPreferences.edit();
                editor.putString("isAdded", "true");
                editor.commit();
                Note.insertNote(title_edit.getText().toString(), body_edit.getText().toString());
                Intent i = new Intent(NoteActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }
        return true;
    }

    public static boolean checkStatus(){
        try{
            String value = sharedPreferences.getString("isAdded", "false");
            if(value.equals("true"))
                return true;
            else
                return false;
        }
        catch(Exception e){ }
        return false;
    }

}
