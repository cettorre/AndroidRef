package com.example.busko.androidref;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class BlankFragment extends Fragment {

    Button btn1=null;
    Button btn2=null;
    Button btn3=null;
    Button btn4=null;
    Button btn5=null;
    Button btnMain=null;

    Button btn6=null;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btn10=null;
    Button btn11=null;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        btn1=(Button)view.findViewById(R.id.buttonF);
        btn2=(Button)view.findViewById(R.id.button2F);
        btn3=(Button)view.findViewById(R.id.button3F);
        btn4=(Button)view.findViewById(R.id.button4F);
        btn5=(Button)view.findViewById(R.id.button5F);
        btnMain=view.findViewById(R.id.buttonMainF);

        btn6=(Button)view.findViewById(R.id.button6F);
        btn7=(Button)view.findViewById(R.id.button7F);
        btn8=(Button)view.findViewById(R.id.button8F);
        btn9=(Button)view.findViewById(R.id.button9F);
        btn10=(Button)view.findViewById(R.id.button10F);
        btn11=(Button)view.findViewById(R.id.button11F);


        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(),Main2Activity.class);
                startActivity(i);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main3Activity.class);
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main4Activity.class);
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main5Activity.class);
                startActivity(i);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main6Activity.class);
                startActivity(i);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main7Activity.class);
                startActivity(i);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {          //todo
                Intent i = new Intent(getContext(),Main7Activity.class);
                startActivity(i);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {            //todo
                Intent i = new Intent(getContext(),Main7Activity.class);
                startActivity(i);
            }
        });


        return view;
    }


}
