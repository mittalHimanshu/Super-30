package com.example.phoenix.mynotesapp;

import android.os.Environment;
import android.support.annotation.NonNull;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Note implements Serializable, ExclusionStrategy {
    private static ArrayList<Note> notes = new ArrayList<>();
    String title;
    String content;
    String dateTime;
    String alarmTIme = "";
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static File myFile = new File(Environment.getExternalStorageDirectory() + File.separator + "MyNotes");
    static File file  = new File(myFile.getAbsolutePath() + File.separator + "MyNotes.data");
    public Note(String title, String content, String alarmTIme) {
        this.dateTime = getCurrentDateTime();
        this.title = title;
        this.content = content;
        this.alarmTIme = alarmTIme;
    }

    public String getAlarmTIme() {
        return alarmTIme;
    }

    public void setAlarmTIme(String alarmTIme) {
        this.alarmTIme = alarmTIme;
    }

    public Note(){}

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

    public static Comparator<Note> titleComparator = new Comparator<Note>() {
        @Override
        public int compare(Note note, Note t1) {
            String title = note.getTitle();
            String title1 = t1.getTitle();
            return title.compareTo(title1);
        }
    };

    public static Comparator<Note> timeComparator = new Comparator<Note>() {
        @Override
        public int compare(Note note, Note t1) {
            String dateTime = note.getDateTime();
            String dateTime1 = t1.getDateTime();
            return dateTime1.compareTo(dateTime);
        }
    };

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getDeclaredClass() == SimpleDateFormat.class;

    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

    public String getCurrentDateTime(){
        dateTime = formatter.format(date);
        return dateTime;
    }
}
