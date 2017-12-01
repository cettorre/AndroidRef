package com.example.busko.androidref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class ConfigActivity extends AppCompatActivity {

    private EditText etName, etProfession;
    private TextView txvName, txvProfession;
    private Switch pageColorSwitch;
    private LinearLayout pageLayout;
    private LinearLayout pageLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        etName = (EditText) findViewById(R.id.etName);
        etProfession = (EditText) findViewById(R.id.etProfession);

        txvName = (TextView) findViewById(R.id.txvName);
        txvProfession = (TextView) findViewById(R.id.txvProfession);

        pageLayout = (LinearLayout) findViewById(R.id.pageLayout);
        pageLayout2 = (LinearLayout) findViewById(R.id.nestedScrollLayout);


        pageColorSwitch = (Switch) findViewById(R.id.pageColorSwitch);
        pageColorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPageColor(isChecked);
            }
        });


        // Load Data from Activity Level SharedPrefs
        //TODO recuperamos informacion en este caso color antes guardar ahora leer
        //                             xml accessible only to this activity
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        //constante   valor por defecto
        boolean isChecked =sharedPref.getBoolean("green",false);
        pageColorSwitch.setChecked(isChecked);
    }

    static boolean isGreen=false;
    private void setPageColor(boolean isChecked) { // Save data to Activity Level SharedPrefs

        //TODO guardar preferencias color pagina disponible solo para esta activity "getPreferences" si fuera disp para otras seria getSharedPreferences
        //modo privado actividad, fichero es privado no puede ser accedido por otras applicaciones
        SharedPreferences sharedPrefs = getSharedPreferences(getPackageName()+".my_pref_file",Context.MODE_PRIVATE);
        //abilito que se pueda modificar que deje actualizar los datos por defecto es solo lectura
        SharedPreferences.Editor editor = sharedPrefs.edit();
        //tal como en bundle añadimos informacion dentro editor
        editor.putBoolean("green", isChecked);
        //para que cambios persistan
        editor.apply();

        pageLayout.setBackgroundColor(isChecked? Color.GREEN : Color.WHITE);


        if(isChecked)isGreen=isChecked;

        //TODO
      /*  if(isChecked)
            pageLayout2.setBackgroundColor(Color.GREEN);
        //esto genera xml en tools>android>Android device monitor
        */
    }

    public void saveAccountData(View view) { // Save data to Application Level SharedPrefs

        //TODO informacion transversal getSHAREDPreferences
        String name = etName.getText().toString();
        String profesion = etProfession.getText().toString();//nombre univoco fichero
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("profession",profesion);
        editor.apply();

    }

    public void loadAccountData(View view) { // Load data from Application Level SharedPrefs

        //TODO
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","No name");
        String prof = sharedPreferences.getString("profession","No profession");
        txvName.setText(name);
        txvProfession.setText(prof);

    }


    public void clearAccountData(View view) {

        //TODO borrarlo todo
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName()+".my_pref_file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }





    public void openMainActivity(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
