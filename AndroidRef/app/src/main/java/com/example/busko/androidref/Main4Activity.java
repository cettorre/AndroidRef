package com.example.busko.androidref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    WebView wv;
    String url;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);




         wv = (WebView)findViewById(R.id.webView);
        Intent i = getIntent();
         url = i.getStringExtra("data");

        //con este sistema actualizamos webview sin recargar la pagina y sin utilizar intent
        button9=findViewById(R.id.button9news);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main4Activity.this.wv.loadUrl("http://www.lavanguardia.com/");
            }
        });





        //hay que los permiso INTERNET en manifast porque. es nuestra aplicacion que abre la pagina
    }

    @Override
    protected void onStart() {
        super.onStart();

        //cargar url dentro webview
        wv.loadUrl(url);



    }

    public void  abrirDatosWeb1(View view){
        Intent i = new Intent(this,Main4Activity.class);
        i.putExtra("data", "http://www.ilfattoquotidiano.it/");
        startActivity(i);
    }
    public void  abrirDatosWeb2(View view){


    }

    public void  abrirDatosWeb3(View view){
        Intent i = new Intent(this,Main4Activity.class);
        i.putExtra("data", "http://time.com/");
        startActivity(i);
    }
    public void  abrirDatosWeb4(View view){
        Intent i = new Intent(this,Main4Activity.class);
        i.putExtra("data", "http://www.huffingtonpost.es/");
        startActivity(i);
    }
}
