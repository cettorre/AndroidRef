package com.example.busko.androidref;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import model.Item;

public class Main3Activity extends AppCompatActivity {

    ListView lista=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


    //atterrizaje
    lista=(ListView)findViewById(R.id.list2View);

    List<Item> listaArray= new ArrayList<>();
        listaArray.add(new Item("primo"));
        listaArray.add(new Item("secondo"));
        listaArray.add(new Item("terzo"));
        listaArray.add(new Item("quarto"));
        listaArray.add(new Item("quinto"));
        listaArray.add(new Item("sesto"));


    ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(
            this, android.R.layout.simple_list_item_1,listaArray);
    lista.setAdapter(adapter);


    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0: Intent intent = new Intent(Main3Activity.this, MainActivity.class);startActivity(intent);break;
                case 1: Intent intent2 = new Intent(Main3Activity.this, Main2Activity.class);startActivity(intent2);break;
                case 2: Intent intent3 = new Intent(Main3Activity.this, Main3Activity.class);startActivity(intent3);break;
                case 3: Intent intent4 = new Intent(Main3Activity.this, Main4Activity.class);startActivity(intent4);break;
                case 4: Intent intent5 = new Intent(Main3Activity.this, Main5Activity.class);startActivity(intent5);break;
                case 5: Intent intent6 = new Intent(Main3Activity.this, Main6Activity.class);startActivity(intent6);break;
            }
        }
    });
    }

    public void  abrirDatosWeb(View view){
        Intent i = new Intent(this,Main4Activity.class);
        i.putExtra("data", "http://www.ilfattoquotidiano.it");
        startActivity(i);
    }

    public void abrirNavegador(View view){

        //intent implicito SO se encarga de encontrar navegador
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pue.es"));
        startActivity(i);

    }




}
