package com.example.phoenix.mynotesapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
    static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        noteAdapter = new NoteAdapter();
        try{
            if (noteAdapter.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Notes Empty", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Notes empty", Toast.LENGTH_SHORT).show();
        }
        int permission = ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("This notes will not be permanently saved because you didn't give Storage Permissions !!! Click Ok to grant permission");
                builder.setTitle("Requesting Permissions");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        makeRequest();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                makeRequest();
            }
        }
    }

    protected void makeRequest() {
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 500);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 500: {
                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Grant Storage Permission for Full functionality", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                return;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView = (ListView) findViewById(R.id.main_listview);
        try {
            if (NoteActivity.checkStatus()) {
                listView.setAdapter(noteAdapter);
            }
        }
        catch (Exception e) {}


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
