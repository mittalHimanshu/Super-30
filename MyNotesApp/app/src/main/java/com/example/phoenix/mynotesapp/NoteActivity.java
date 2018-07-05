package com.example.phoenix.mynotesapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static com.example.phoenix.mynotesapp.MainActivity.sharedPreferences;
import static com.example.phoenix.mynotesapp.Note.file;

public class NoteActivity extends AppCompatActivity {
    EditText title_edit, body_edit;
    static SharedPreferences.Editor editor;
    ArrayList<Note> deleteNotes = new ArrayList<>();
    String title, content;
    AlertDialog.Builder a;
    AlertDialog.Builder b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        title_edit = (EditText) findViewById(R.id.title_edit);
        body_edit = (EditText) findViewById(R.id.body_edit);
        a = new AlertDialog.Builder(NoteActivity.this);
        try {
            Bundle bundle = getIntent().getExtras();
            title = bundle.getString("title");
            content = bundle.getString("content");
            title_edit.setText(title);
            body_edit.setText(content);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.save: {
                saveNotes();
            }
            break;
            case R.id.delete: {
                showAlertBox();
            }
        }
        return true;
    }

    private void saveNotes() {
        editor = sharedPreferences.edit();
        editor.putString("isAdded", "true");
        editor.commit();
        Note.insertNote(title_edit.getText().toString(), body_edit.getText().toString());
        Intent j = new Intent(NoteActivity.this, MainActivity.class);
        startActivity(j);
        finish();
    }

    private void showAlertBox() {
        a.setMessage("Do you want to delete this note ?").setCancelable(true);
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int p) {
                removeNotes();
            }
        });
        a.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = a.create();
        alert.show();
    }

    private void removeNotes() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    deleteNotes = Note.getNotes();
                    for (int i = 0; i < deleteNotes.size(); i++) {
                        if (deleteNotes.get(i).getTitle().equals(title) && deleteNotes.get(i).getContent().equals(content)) {
                            deleteNotes.remove(deleteNotes.get(i));
                        }
                    }
                    FileOutputStream fout = new FileOutputStream(file);
                    ObjectOutputStream out = new ObjectOutputStream(fout);
                    out.writeObject(deleteNotes);
                    out.flush();
                    Intent in = new Intent(NoteActivity.this, MainActivity.class);
                    startActivity(in);
                    finish();
                } catch (Exception e) {
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    public static boolean checkStatus() {
        try {
            String value = sharedPreferences.getString("isAdded", "false");
            if (value.equals("true"))
                return true;
            else
                return false;
        } catch (Exception e) {
        }
        return false;
    }
}