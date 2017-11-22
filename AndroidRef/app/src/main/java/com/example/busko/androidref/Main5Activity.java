package com.example.busko.androidref;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main5Activity extends AppCompatActivity {

    Intent i = null;
    LinearLayout layout=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        layout = (LinearLayout)findViewById(R.id.LayoutPrincipal);
    }
    public void playMusic(View view) {
        i = new Intent(this, PlayerService.class);
        startService(i);
    }

    public void stopMusic(View view) {
        stopService(i);
    }

    public void callReceiver(View view) {
        Intent i = new Intent("es.pue.itentiimplicitowebandroid.MY_BROWSER");
        i.putExtra("data", "http://www.google.com");
        startActivity(i);
    }

    //tiene que ser public
    public void changeBkColor(View view){
        Button b=(Button) view; //Voew->Button obligatorio

        switch (b.getId()){
            case R.id.button18:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.button17:
                layout.setBackgroundColor(Color.BLACK);
                break;
            case R.id.button16:
                layout.setBackgroundColor(Color.WHITE);
                break;


        }

    }


}
