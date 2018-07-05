package com.example.phoenix.mynotesapp;

import android.os.Environment;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Note implements Serializable, ExclusionStrategy {
    private static Note note;
    private static ArrayList<Note> notes = new ArrayList<>();
    static ArrayList<Note> notes1 = new ArrayList<>();
    String title;
    String content;
    String dateTime;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static File file = new File(Environment.getExternalStorageDirectory() + "/notes.txt");

    public Note(String title, String content) {
        dateTime = formatter.format(date);
        this.title = title;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public static void insertNote(String title, String content) {
        note = new Note(title, content);
        notes1.add(note);
        try {
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(notes1);
            out.flush();
        }
        catch (Exception e){ }
    }

    public static ArrayList<Note> getNotes() {
        try {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fin);
            Object loadObj = in.readObject();
            notes = (ArrayList<Note>) loadObj;
            in.close();
        } catch (Exception e) { }
        return notes;
    }


    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getDeclaredClass() == SimpleDateFormat.class;

    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
