package com.example.busko.androidref;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import model.Message;

/**
 * Created by android on 25/10/2017.
 */

public class ChatAdapter extends ArrayAdapter<Message> {

    private Context context;
    private List<Message> messages;

    public ChatAdapter(@NonNull Context context, List<Message> messages) {
        super(context,R.layout.message_item,messages);
        this.context = context;
        this.messages = messages;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //1.- cargar en memmoria el layout message_item
        LayoutInflater inflater =
                (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View messageView = inflater.inflate(R.layout.message_item,parent,false);

        TextView msgView = (TextView) messageView.findViewById(R.id.txMessage);
        TextView timeView = (TextView) messageView.findViewById(R.id.txTime);

        msgView.setText(this.messages.get(position).getMessage());
        timeView.setText(this.messages.get(position).getTime());

        return messageView;
    }
}
