package com.example.busko.androidref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

    public int contador;

    TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        //v18@3:10 antes metodo mostrarResultado() textoResultado ha sido cambiado de sitio para ser visible
        textoResultado=(TextView)findViewById(R.id.contadorPulsaciones);

        contador=0;
        textoResultado.setText(""+contador);

        //v21@11:30 crear instancio objeto escucha evento teclado
        EventoTeclado teclado =new EventoTeclado();
        EditText n_reseteo=(EditText) findViewById(R.id.n_reseteo); //n_reseto es el objeto que se pone a la escucha y tenemoos que pasarle el teclado
        n_reseteo.setOnEditorActionListener(teclado);//eventos - pasar la instancia que implementa la interfaz

    }

    //inner class: listener para cerrar teclado
class EventoTeclado implements TextView.OnEditorActionListener{//esta interfaz devuelve la accion del editor(en este caso teclado)
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            //si se cierra el teclado porque hemos pulsado ok  v21@9:57
            if(actionId== EditorInfo.IME_ACTION_DONE){//si se ha cerrado el teclado
                reseteaContador(null);                //resetea contador
            }
            return false;
        }
    }




    public void incrementaContador(View view){
        contador++;
        //v18@4:30
        textoResultado.setText(""+contador);
    }

    public void restaContador(View view){
        contador--;
        //tiene que mirar si la variable ha llergado a 0 y si estan permitidos negativos en checkbox
        //v18@9:00
        if(contador<0){
            CheckBox negativos =(CheckBox)findViewById(R.id.negativos);
            if(!negativos.isChecked()){
                contador=0;
            }
        }
        textoResultado.setText(""+contador);
    }


    public void reseteaContador(View view){
        EditText numero_reset=(EditText)findViewById(R.id.n_reseteo);
        //v18@12:40   cambiar numero que sale en pantalla con numero introducido en EditText n_reseteo
        //v18@22:40 try
        try {
            contador = Integer.parseInt(numero_reset.getText().toString());
        }catch (Exception e){
            contador=0;
        }

        numero_reset.setText("");
        textoResultado.setText(""+contador);

        //v20@19:00 esconder teclado despues input
        InputMethodManager miteclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        miteclado.hideSoftInputFromWindow(numero_reset.getWindowToken(),0);//parametro 0 ocultacion directa

    }


}
