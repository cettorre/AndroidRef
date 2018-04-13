package com.example.busko.androidref;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressDialog mDialog;
    VideoView videoView;
    ImageButton btnPlayPause;
    String videoURL="https://vimeo.com/251646742?ref=fb-share&1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        videoView= findViewById(R.id.videoView);
        btnPlayPause= findViewById(R.id.btn_play_pause);
        btnPlayPause.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        mDialog= new ProgressDialog(MediaPlayerActivity.this);
        mDialog.setMessage("loading...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

    }
}
