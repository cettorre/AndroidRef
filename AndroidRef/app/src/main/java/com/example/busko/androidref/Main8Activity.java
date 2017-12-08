package com.example.busko.androidref;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton takePhoto = null;
    ImageView photo = null;
    Uri photoUri = null;
    File output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        photo = (ImageView)findViewById(R.id.foto);
        takePhoto = (ImageButton) findViewById(R.id.btnTakePhoto);

        takePhoto.setOnClickListener(this);

        if (savedInstanceState == null){
            File dir = getExternalFilesDir(Environment.DIRECTORY_DCIM);
            dir.mkdirs();
            output = new File(dir,"com.example.busko.androidref.foto1.jpg");
        } else {
            output = (File)savedInstanceState.getSerializable("foto1");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTakePhoto:
                hacerFoto();
                break;
            default:
                break;
        }
    }

    private void hacerFoto(){               //2. devulve la imagen capturada por la camara
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //asigna la uri del fichero a la Uri photoUri
        photoUri = Uri.fromFile(output);
        //The name of the Intent-extra used to indicate a content resolver Uri to be used to store the requested image or video.
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10){
            if (resultCode == Activity.RESULT_OK){
                Log.i(getClass().getSimpleName(),"Se ha relizado la operación de foto");

                photo.setImageURI(photoUri);
            }
        }
        
    }
}
