package com.example.busko.androidref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
        messageText = (EditText) findViewById(R.id.messageText);
        messageList = (ListView)findViewById(R.id.messageList);

        messages = new ArrayList<Message>();

        adapter = new ChatAdapter(this,this.messages);
        this.messageList.setAdapter(adapter);

        //listener
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1.- coger el contenido campo texto
                String message = messageText.getText().toString();
                //2.- Crear un objeto de tipo Message con el valor recogido
                Message msg = new Message("",message,true,new Date());
                //3.- Añadir este objeto de tipo Message al ArrayList
                messages.add(msg);
                //4.- Informar a la lista mediante adapter que se refresque
                adapter.notifyDataSetChanged();

                messageText.setText("");
            }
        });


    }
}
