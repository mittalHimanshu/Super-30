package com.example.phoenix.login_register;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import static android.content.Context.MODE_PRIVATE;
import static com.example.phoenix.login_register.MainActivity.sharedPreferences;

public class DatabaseHandler {

    private SQLiteDatabase mydatabase;
    private Cursor resultSet;
    SharedPreferences.Editor editor;

    DatabaseHandler(Context context){
        mydatabase = context.openOrCreateDatabase("Phoenix",MODE_PRIVATE,null);
        editor = sharedPreferences.edit();
    }

    public void createDB(String name, String email, String phone, String password) {
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Register(Username VARCHAR,Password VARCHAR, Email VARCHAR, Phone VARCHAR);");
        mydatabase.execSQL("DELETE from Register;");
        mydatabase.execSQL("INSERT INTO Register VALUES('"+name+"','"+password+"','"+email+"','"+phone+"');");
        editor.putBoolean("exists", true);
        editor.commit();
    }

    public void setFalse(){
        editor.putBoolean("exists", false);
        editor.commit();
    }

    public boolean checkDB(){
        if(sharedPreferences.getBoolean("exists", false))
            return true;
        else
            return false;
    }

    public String getUsername(){
        resultSet = mydatabase.rawQuery("Select * from register",null);
        resultSet.moveToFirst();
        return resultSet.getString(0);
    }

    public String getPassword(){
        return resultSet.getString(1);
    }

    public String getEmail(){
        return resultSet.getString(2);
    }

    public String getPhone(){
        return resultSet.getString(3);
    }

    public boolean validateData(String s, String s1) {
        if(s.equals(getUsername()) && s1.equals(getPassword()))
            return true;
        else
            return false;
    }
}
