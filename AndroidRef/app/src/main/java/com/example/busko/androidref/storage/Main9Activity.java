package com.example.busko.androidref.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.busko.androidref.*;


public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);




    }

    public void openInternalStorageDemoActivity(View view) {

        Intent intent = new Intent(this, InternalStorageDemo.class);
        startActivity(intent);
    }

    public void openCacheStorageDemoActivity(View view) {

//        Intent intent = new Intent(this, CacheStorageDemo.class);
//        startActivity(intent);
    }

    public void openExternalStorageDemoActivity(View view) {

//        Intent intent = new Intent(this, ExternalStorageDemo.class);
//        startActivity(intent);
    }


}
