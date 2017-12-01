package com.example.busko.androidref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView textView3;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getInfoFromSharedPrefs();
    }

    public void showInfo(){
        Intent i = new Intent(this, InfoActivity.class);

    }

    public void getInfoFromSharedPrefs(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name","No name");
        String prof = sharedPreferences.getString("profession","No profession");
        textView3.setText(name);
        textView4.setText(prof);

    }

}
