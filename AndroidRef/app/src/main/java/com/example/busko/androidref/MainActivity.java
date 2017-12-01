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

public class MainActivity extends AppCompatActivity {

    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btn10=null;
    Button btn11=null;
    Button btn12=null;

    Button btn6v;
    Button btn7v=null;
    Button btn8v=null;
    Button btn9v=null;
    Button btn10v=null;
    Button btn11v=null;
    Button btn12v=null;

    TextView txvName;

    LinearLayout pageLayout;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn6=(Button)findViewById(R.id.button1_hscroll);
        btn7=(Button)findViewById(R.id.button2_hscroll);
        btn8=(Button)findViewById(R.id.button3_hscroll);
        btn9=(Button)findViewById(R.id.button4_hscroll);
        btn10=(Button)findViewById(R.id.button5_hscroll);
        btn11=(Button)findViewById(R.id.button6_hscroll);
        btn12=(Button)findViewById(R.id.button7_hscroll);

        btn6v=(Button)findViewById(R.id.button1_vertical);
        btn7v=(Button)findViewById(R.id.button2_vertical);
        btn8v=(Button)findViewById(R.id.button3_vertical);
        btn9v=(Button)findViewById(R.id.button4_vertical);
        btn10v=(Button)findViewById(R.id.button5_vertical);
        btn11v=(Button)findViewById(R.id.button6_vertical);
        btn12v=(Button)findViewById(R.id.button7_vertical);

        txvName=findViewById(R.id.txvName);
        pageLayout=findViewById(R.id.nestedScrollLayout);




        toolbar=(Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(i);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(i);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(i);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main6Activity.class);
                startActivity(i);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Main7Activity.class);
                startActivity(i);
            }
        });






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



    }

    @Override
    protected void onStart() {
        super.onStart();
        loadAccountData(null);

        //TODO
        getPageColor();
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

        //TODO copiando esactamente mismo codigo de MainActivity
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","USER(***you didn't enter you name into configuration activity***)");
        txvName.setText("Welcome "+ name + ". Please take a look to this fantastic application");
        //txvProfession.setText(prof);
    }


    public void getPageColor(){
        if(ConfigActivity.isGreen) pageLayout.setBackgroundColor( Color.GREEN );

    }


    /*
    private void getPageColor(boolean isChecked) { // Save data to Activity Level SharedPrefs

        //TODO guardar preferencias color pagina disponible solo para esta activity "getPreferences" si fuera disp para otras seria getSharedPreferences
        //modo privado actividad, fichero es privado no puede ser accedido por otras applicaciones
        SharedPreferences sharedPrefs = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);

        boolean b=sharedPrefs.getBoolean("green",isChecked);

        //if(b)pageLayout.setBackgroundColor( Color.GREEN );

    }
    */

}
