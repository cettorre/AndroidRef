package com.example.busko.androidref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Message;

public class Main2Activity extends AppCompatActivity {

    Button sendButton;
    EditText messageText;
    ListView messageList;

    //estructura datos
    List<Message> messages = null;

    //adapter
    ChatAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //widgets
        sendButton = (Button) findViewById(R.id.sendButton);


        EventoTeclado teclado = new EventoTeclado();
        messageText = (EditText) findViewById(R.id.messageText);
        messageText.setOnEditorActionListener(teclado);


        messageList = (ListView) findViewById(R.id.messageList);

        messages = new ArrayList<Message>();

        adapter = new ChatAdapter(this, this.messages);
        this.messageList.setAdapter(adapter);

    }

 //changed from anonimous class to explicit methos that uses onclick property in order to invoke the method from the listener that closes the system keyboard
    public void enviarMensaje(View view) {

        //1.- coger el contenido campo texto
        String message = messageText.getText().toString();
        //2.- Crear un objeto de tipo Message con el valor recogido
        Message msg = new Message("", message, true, new Date());
        //3.- Añadir este objeto de tipo Message al ArrayList
        messages.add(msg);
        //4.- Informar a la lista mediante adapter que se refresque
        adapter.notifyDataSetChanged();

        messageText.setText("");

        //esconder teclado
        InputMethodManager miteclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        miteclado.hideSoftInputFromWindow(messageText.getWindowToken(), 0);//parametro 0 ocultacion directa

        //added  android:windowSoftInputMode="adjustPan" in manifest para que el teclado no esconda el EditText

    }



    //inner class: listener invocar enviarMensaje cuando se cierra el teclado
    class EventoTeclado implements TextView.OnEditorActionListener {//esta interfaz devuelve la accion del editor(en este caso teclado)

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {//si se ha cerrado el teclado
                enviarMensaje(null);
                //para que salga boton (v) hay que camboar el inputType del editText en xnl

            }
            return false;
        }
    }

}