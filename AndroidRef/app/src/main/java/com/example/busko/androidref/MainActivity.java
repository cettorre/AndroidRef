package com.example.busko.androidref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.busko.androidref.database.DatabaseActivity;
import com.example.busko.androidref.storage.Main9Activity;

public class MainActivity extends AppCompatActivity {

    Button btn6v;
    Button btn7v=null;
    Button btn8v=null;
    Button btn9v=null;
    Button btn10v=null;
    Button btn11v=null;
    Button btn12v=null;
    Button btn13v=null;
    Button btn14v=null;

    TextView txvName;

    LinearLayout pageLayout;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txvName=findViewById(R.id.txvName);
        pageLayout=findViewById(R.id.nestedScrollLayout);
        toolbar=(Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        btn6v=(Button)findViewById(R.id.button1_vertical);
        btn7v=(Button)findViewById(R.id.button2_vertical);
        btn8v=(Button)findViewById(R.id.button3_vertical);
        btn9v=(Button)findViewById(R.id.button4_vertical);
        btn10v=(Button)findViewById(R.id.button5_vertical);
        btn11v=(Button)findViewById(R.id.button6_vertical);
        btn12v=(Button)findViewById(R.id.button7_vertical);
        btn13v=(Button)findViewById(R.id.button8_vertical);
        btn14v=(Button)findViewById(R.id.button9_vertical);


        btn6v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(i);
            }
        });
        btn7v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });
        btn8v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(i);
            }
        });
        btn9v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(i);
            }
        });
        btn10v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main6Activity.class);
                startActivity(i);
            }
        });
        btn11v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main7Activity.class);
                startActivity(i);
            }
        });

        btn12v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main8Activity.class);
                startActivity(i);
            }
        });

        btn13v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main9Activity.class);
                startActivity(i);
            }
        });

        btn14v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DatabaseActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadAccountData(null);

        //TODO
        getPageColor2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_en_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.config) {
            Intent i = new Intent(this, ConfigActivity.class);
            this.startActivity(i);
            return true;
        }
        if(id==R.id.info){
            Intent i = new Intent(this, InfoActivity.class);
            this.startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadAccountData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","USER(***you didn't enter you name into configuration activity***)");
        txvName.setText("Welcome "+ name + ". Please take a look to this fantastic application");
        //txvProfession.setText(prof);
    }


    public void getPageColor(){
        if(ConfigActivity.isGreen) {pageLayout.setBackgroundColor( Color.GREEN );}
        else{pageLayout.setBackgroundColor( Color.BLACK );
        }
    }
    public void getPageColor2(){
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);
        boolean b= sharedPreferences.getBoolean("green",false);
        if(b) {pageLayout.setBackgroundColor( Color.GREEN );}
        else{pageLayout.setBackgroundColor( Color.BLACK );
        }
    }
}
