package com.example.busko.androidref.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.busko.androidref.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageDemo extends AppCompatActivity {


    private EditText etFileName, etMessage, etFileToDelete;
    private TextView txvInternalStoragePath, txvFilesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_storage);


        etFileName 		= (EditText) findViewById(R.id.etFileName);
        etMessage 		= (EditText) findViewById(R.id.etMessage);
        etFileToDelete 	= (EditText) findViewById(R.id.etFileToDelete);

        txvInternalStoragePath 	= (TextView) findViewById(R.id.txvInternalStoragePath);
        txvFilesList 			= (TextView) findViewById(R.id.txvFilesList);


    }

    public void saveToInternalStorage(View view) {

        String fileName = etFileName.getText().toString();
        String messageData = etMessage.getText().toString();

        //TODO
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(fileName, MODE_PRIVATE);
            //no sabe escribir strings pero si bytes
            fos.write(messageData.getBytes());
        }catch (FileNotFoundException e) {
            e.printStackTrace();

        }catch (IOException e)	{
            e.printStackTrace();

        }finally {
            if(fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }


    }

    public void moveToDisplayScreen(View view) {

        Intent intent = new Intent(this, InternalStorageDisplay.class);
        startActivity(intent);
    }

    public void showInternalStoragePath(View view) {

        String path = "" + getFilesDir();
        txvInternalStoragePath.setText(path);
    }

    public void showFilesList(View view) {

        //TODO test it works!
        String[] listOfFiles = getFilesDir().list();
        StringBuffer list=new StringBuffer("");
        for (String s: listOfFiles) {
            list.append(s+", ");
        }

        txvFilesList.setText(list);

    }

    public void deleteFile(View view) {

        //TODO test it works!
        String fileToDelete = etFileToDelete.getText().toString();
        File file=new File(getFilesDir(),fileToDelete);
        file.delete();

        // also with method deleteFile

    }


}
