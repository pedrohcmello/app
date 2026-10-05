package com.example.aula7;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor ac = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

//sensorEvent
        sm.registerListener(this,ac, SensorManager.SENSOR_DELAY_NORMAL);
        //Se eu colocasse  this, eu informaria que a classe se implementa.


         tv = findViewById(R.id.textView);
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
         tv.setText(Float.toString(event.values[0])+" : "+
                    Float.toString(event.values[1])+" : "+
                    Float.toString((event.values[2]))

                 );
    }
}
