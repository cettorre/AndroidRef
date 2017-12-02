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

    Button btn6;
    Button btn7=null;
    Button btn8=null;
    Button btn9=null;
    Button btn10=null;
    Button btn11=null;
    Button btn12=null;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);


        //aterrizaje buttons y eventos

        btn6=(Button)view.findViewById(R.id.button1_hscroll);
        btn7=(Button)view.findViewById(R.id.button2_hscroll);
        btn8=(Button)view.findViewById(R.id.button3_hscroll);
        btn9=(Button)view.findViewById(R.id.button4_hscroll);
        btn10=(Button)view.findViewById(R.id.button5_hscroll);
        btn11=(Button)view.findViewById(R.id.button6_hscroll);
        btn12=(Button)view.findViewById(R.id.button7_hscroll);



        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext() , Main2Activity.class);
                startActivity(i);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main3Activity.class);
                startActivity(i);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main4Activity.class);
                startActivity(i);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main5Activity.class);
                startActivity(i);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main6Activity.class);
                startActivity(i);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Main7Activity.class);
                startActivity(i);
            }
        });


        return view;
    }


}
