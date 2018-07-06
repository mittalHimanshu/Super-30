package com.example.phoenix.mynotesapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static com.example.phoenix.mynotesapp.MainActivity.sharedPreferences;
import static com.example.phoenix.mynotesapp.Note.file;

public class NoteActivity extends AppCompatActivity {
    EditText title_edit, body_edit;
    static SharedPreferences.Editor editor;
    ArrayList<Note> deleteNotes = new ArrayList<>();
    ArrayList<Note> updateNotes = new ArrayList<>();
    String title, content, dateTime;
    AlertDialog.Builder a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        title_edit = (EditText) findViewById(R.id.title_edit);
        body_edit = (EditText) findViewById(R.id.body_edit);
        updateNotes = Note.getNotes();
        a = new AlertDialog.Builder(NoteActivity.this);
        try {
            Bundle bundle = getIntent().getExtras();
            title = bundle.getString("title");
            content = bundle.getString("content");
            dateTime = bundle.getString("dateTime");
            title_edit.setText(title);
            body_edit.setText(content);
        } catch (Exception e) {
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveNotes();
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
            case R.id.delete:
            {
                showAlertBox();
                break;
            }

            case R.id.save:
            {
                saveNotes();
                break;
            }
        }
        return true;
    }

    private void saveNotes() {
        title = title_edit.getText().toString();
        content = body_edit.getText().toString();
        editor = sharedPreferences.edit();
        editor.putString("isAdded", "true");
        editor.commit();
        for(int i=0; i<updateNotes.size(); i++){
            if(title.equals(updateNotes.get(i).getTitle())){
                updateNotes.get(i).setContent(content);
                updateNotes.get(i).setDateTime(new Note().getCurrentDateTime());
                showAnotherAlertBox();
                return;
            }
            else if(content.equals(updateNotes.get(i).getContent())){
                updateNotes.get(i).setTitle(title);
                updateNotes.get(i).setDateTime(new Note().getCurrentDateTime());
                showAnotherAlertBox();
                return;
            }
        }
        Note n = new Note(title_edit.getText().toString(), body_edit.getText().toString());
        updateNotes.add(n);
        updateCurrentNotes(updateNotes);
        Toast.makeText(getApplicationContext(), title_edit.getText().toString() + " note added", Toast.LENGTH_SHORT).show();
        moveToMainActivity();
    }

    private void showAnotherAlertBox(){
        a.setMessage("Click 'Yes' to update existing note or 'No' to save as a new note").setCancelable(true);
        a.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int p) {
                updateCurrentNotes(updateNotes);
                Toast.makeText(getApplicationContext(), title + " updated", Toast.LENGTH_SHORT).show();
                moveToMainActivity();
            }
        });
        a.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Note n = new Note(title_edit.getText().toString(), body_edit.getText().toString());
                updateNotes.add(n);
                updateCurrentNotes(updateNotes);
                Toast.makeText(getApplicationContext(), title_edit.getText().toString() + " note added", Toast.LENGTH_SHORT).show();
                moveToMainActivity();
            }
        });
        AlertDialog alert = a.create();
        alert.show();
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
                        if (deleteNotes.get(i).getTitle().equals(title) && deleteNotes.get(i).getContent().equals(content) && deleteNotes.get(i).getDateTime().equals(dateTime)) {
                            deleteNotes.remove(deleteNotes.get(i));
                        }
                    }
                    updateCurrentNotes(deleteNotes);
                    moveToMainActivity();
                } catch (Exception e) {
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Toast.makeText(getApplicationContext(),"note deleted", Toast.LENGTH_SHORT).show();
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

    public void updateCurrentNotes(final ArrayList<Note> temp){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    FileOutputStream fout = new FileOutputStream(file);
                    ObjectOutputStream out = new ObjectOutputStream(fout);
                    out.writeObject(temp);
                    out.flush();
                }
                catch(Exception e){ }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    public void moveToMainActivity(){
        Intent in = new Intent(NoteActivity.this, MainActivity.class);
        startActivity(in);
        finish();
    }
}