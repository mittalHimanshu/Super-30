package com.example.phoenix.note_making;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class DatabaseHandler {

    static ArrayAdapter<String> adapter;
    private SQLiteDatabase mydatabase;
    private Cursor resultSet;
    private String subject;
    Context context;
    ArrayList<String> notes = new ArrayList<>();
    ArrayList<String> showNote = new ArrayList<>();
    ArrayList<String> showSubject = new ArrayList<>();
    public DatabaseHandler(String subject, Context context){
        this.subject = subject;
        this.context = context;
        mydatabase = context.openOrCreateDatabase("Phoenix",MODE_PRIVATE,null);
    }

    public DatabaseHandler(Context context){
        mydatabase = context.openOrCreateDatabase("Phoenix",MODE_PRIVATE,null);
    }

    public DatabaseHandler(Context context, String subject) {
        mydatabase = context.openOrCreateDatabase("Phoenix",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS " +subject+ "(Notes VARCHAR);");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Subjects (Name VARCHAR);");
        mydatabase.execSQL("INSERT INTO Subjects VALUES('"+subject+"');");
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, notes);
        this.subject = subject;
    }

    public void addNote(String note){
        mydatabase.execSQL("INSERT INTO "+subject+"(Notes) VALUES('"+note+"');");
        notes.add(note);
    }

    public ArrayAdapter<String> fetchNotes(){
        return adapter;
    }

    public ArrayAdapter<String> getNotes() {
        resultSet = mydatabase.rawQuery("Select * from "+subject, null);
        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){
            showNote.add(resultSet.getString(0));
            resultSet.moveToNext();
        }
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, showNote);
        return adapter;
    }

    public ArrayList<String> getSubjects() {
        resultSet = mydatabase.rawQuery("Select * from Subjects", null);
        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){
            Log.d("fttrr", resultSet.getString(0));
            showSubject.add(resultSet.getString(0));
            resultSet.moveToNext();
        }
        return showSubject;
    }
}
