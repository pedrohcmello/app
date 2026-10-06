package com.example.aula7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv;
    SQLiteDatabase database;
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
         database = openOrCreateDatabase("bd",MODE_PRIVATE,null);
         database.execSQL("CREATE TABLE IF NOT EXISTS eventos (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                  "value1 REAL(5,2),"  +
                  "value2 REAL(5,2)," +
                  "value3  REAL(5,2))");
    }

    public ArrayList<Eventos> getAllEvents(){
          Cursor cursor = database.rawQuery("SELECT * FROM eventos LIMIT ?", new String[]{"1000"});
         cursor.moveToFirst();


         ArrayList<Eventos> result = new ArrayList<>();
         while(!cursor.isAfterLast()){
             new Eventos(cursor.getInt(0),
                     new Float[]{cursor.getFloat(1),
                             cursor.getFloat(2),
                             cursor.getFloat(3)
                     });



         }
          return result;
    }
//FALTA IMPORTAR GRÁFICO  PARA VER O RESULTADO DESSE CÓDIGO

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
         tv.setText(Float.toString(event.values[0])+" : "+
                    Float.toString(event.values[1])+" : "+
                    Float.toString(event.values[2]));

        ContentValues contentValues = new ContentValues();

                 contentValues.put("value1",event.values[0]);
                 contentValues.put("value1",event.values[1]);
                 contentValues.put("value1",event.values[2]);

                 database.insert("eventos",null,contentValues);

    }
}
