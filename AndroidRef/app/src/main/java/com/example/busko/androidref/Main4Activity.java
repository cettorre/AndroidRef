package com.example.busko.androidref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        WebView wv = (WebView)findViewById(R.id.webView);
        Intent i = getIntent();
        String url = i.getStringExtra("data");

        //cargar url dentro webview
        wv.loadUrl(url);

        //hay que los permiso INTERNET en manifast porque. es nuestra aplicacion que abre la pagina
    }


    public void  abrirDatosWeb1(View view){
        Intent i = new Intent(this,Main4Activity.class);
        i.putExtra("data", "http://www.ilfattoquotidiano.it/");
        startActivity(i);
    }
    public void  abrirDatosWeb2(View view){
        Intent i = new Intent(this,Main4Activity.class);
        i.putExtra("data", "http://www.lavanguardia.com/");
        startActivity(i);
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
