package com.example.busko.androidref.storage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.busko.androidref.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorageDemo extends AppCompatActivity {

    private EditText etExternalPrivate, etExternalPublic;
    private TextView txvExternalPrivate, txvExternalPublic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_storage);

        etExternalPrivate = (EditText) findViewById(R.id.etExternalPrivate);
        etExternalPublic = (EditText) findViewById(R.id.etExternalPublic);

        txvExternalPrivate = (TextView) findViewById(R.id.txvExternalPrivate);
        txvExternalPublic = (TextView) findViewById(R.id.txvExternalPublic);

    }

    public void saveToExternalPrivate(View view) {

        String data = etExternalPrivate.getText().toString();

        //TODO escibir en fichero extern pero privado

        if (isExternalStorageWritable()) {
            File dir = getExternalFilesDir("DirectorioExterno");
            File file = new File(dir, "contenido_externo_privado.txt");

            writeToFile(file, data);
        }
    }

    //external public OK
    public void saveToExternalPublic(View view) {

        String data = etExternalPublic.getText().toString();

        //TODO escibir en fichero extern pero publico

        if (isExternalStorageWritable()) {
            File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(dir, "contenido_externo_publico.txt");

            writeToFile(file, data);
        }
    }



        public void loadFromExternalPrivate(View view) {

            //TODO test it works!
            if(isExternalStorageReadable()) {
                File dir = getExternalFilesDir("DirectorioExterno");

                File file = new File(dir, "contenido_externo_privado.txt");
                String data = readFromFile(file);
                txvExternalPrivate.setText(data);
            }
        }

        public void loadFromExternalPublic(View view) {

            //TODO
            // load readeable en lugar de writable
            if(isExternalStorageReadable()) {
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

                File file = new File(dir, "contenido_externo_publico.txt");
                String data = readFromFile(file);
                txvExternalPublic.setText(data);
            }



        }

        private void writeToFile(File file, String data) {

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(file);
                fos.write(data.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private String readFromFile(File file) {

            StringBuffer stringBuffer = new StringBuffer();

            FileInputStream fis = null;

            try {
                fis = new FileInputStream(file);

                int read;
                while ((read = fis.read()) != -1) {
                    stringBuffer.append((char)read);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return stringBuffer.toString();
        }

	/* Checks if external storage is available for read and write */
        public boolean isExternalStorageWritable() {

            //TODO metodo que devuelve estado storage externo
            String state = Environment.getExternalStorageState();
            if(Environment.MEDIA_MOUNTED.equals(state)){
                return true;
            }

            return false;
        }

	/* Checks if external storage is available to at least read */
        public boolean isExternalStorageReadable() {

            //TODO
            String state = Environment.getExternalStorageState();
            //lettura hay que preguntarlo explicitamente tambien si es readonly

            if(Environment.MEDIA_MOUNTED.equals(state)
                    || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)
                    ){
                return true;
            }

            return false;
        }

    }


