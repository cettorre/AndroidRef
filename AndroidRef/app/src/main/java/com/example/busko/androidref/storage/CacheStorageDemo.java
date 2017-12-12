package com.example.busko.androidref.storage;

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

public class CacheStorageDemo extends AppCompatActivity {

    private EditText etInternalCacheData, etExternalCacheData;
    private TextView txvInternalCacheData, txvExternalCacheData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cache_storage);

        etInternalCacheData = (EditText) findViewById(R.id.etInternalCacheData);
        etExternalCacheData = (EditText) findViewById(R.id.etExternalCacheData);

        txvInternalCacheData = (TextView) findViewById(R.id.txvInternalCacheContent);
        txvExternalCacheData = (TextView) findViewById(R.id.txvExternalCacheContent);

    }

    public void saveToInternalCache(View view) {

        String cacheData = etInternalCacheData.getText().toString();
        //TODO
        File cacheDir = getCacheDir();
        //File cacheD = getExternalCacheDir(); //si fuera externo
        File file = new File(cacheDir,"contenido_cache_interno.txt");
        writeToFile(file,cacheData);




    }

    public void saveToExternalCache(View view) {

        String cacheData = etExternalCacheData.getText().toString();

        //TODO test

        File cacheDir = getExternalCacheDir();
        File file = new File(cacheDir,"contenido_cache_externo.txt");
        writeToFile(file,cacheData);



    }

    public void loadFromInternalCache(View view) {

        //TODO test it works!

        File dir = getCacheDir();
        File file = new File(dir, "contenido_cache_interno.txt");
        String data = readFromFile(file);
        txvInternalCacheData.setText(data);

    }

    public void loadFromExternalCache(View view) {

        //TODO test it works!
        File dir = getExternalCacheDir();
        File file = new File(dir, "contenido_cache_externo.txt");
        String data = readFromFile(file);
        txvExternalCacheData.setText(data);

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
}
