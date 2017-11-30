package com.example.busko.androidref;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main7Activity extends AppCompatActivity {

    private ProgressBar bar = null;
    private ImageView status = null;
    private TextView level = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        bar = (ProgressBar) findViewById(R.id.bar);
        status = (ImageView)findViewById(R.id.status);
        level = (TextView)findViewById(R.id.level);

    }


    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(onBatteryChanged, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(onBatteryChanged);
    }


    BroadcastReceiver onBatteryChanged = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int pct = 100*intent.getIntExtra(BatteryManager.EXTRA_LEVEL,1)/
                    intent.getIntExtra(BatteryManager.EXTRA_SCALE,1);

            bar.setProgress(pct);
            level.setText(String.valueOf(pct));

            switch (intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1)){
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    status.setImageResource(R.drawable.battery_charging);
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    status.setImageResource(R.drawable.battery_full);
                    break;
                default:
                    status.setImageResource(R.drawable.battery_on);
            }
        }
    };


}
