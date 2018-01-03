package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Light extends AppCompatActivity implements SensorEventListener{

    Button b1;
    MediaPlayer mp;
    SensorManager sm;
    Sensor s1,s2;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        b1=(Button)findViewById(R.id.bsk);
        e1=(EditText)findViewById(R.id.editText3);
        e1.setEnabled(false);
        mp=MediaPlayer.create(getApplicationContext(),R.raw.a);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();

                Intent i=new Intent(getApplicationContext(),Magical_player.class);
                startActivity(i);
                finish();

            }
        });
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        s1=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(Light.this,s1,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>3)
        {
            mp.start();
        }
        else
        {
            mp.pause();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
