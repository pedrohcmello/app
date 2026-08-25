

package com.ifsc.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("cicloDaVida","onCreate");


        Button b = findViewById(R.id.button);
        b.setOnClickListener( view -> {
          Intent i =  new Intent(this,ActivityB.class);
          startActivity(i);

        });
        Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(v ->{
            EditText editText=findViewById(R.id.edText);
                    String s = editText.getText().toString();

                    Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("msg",s);
            startActivity(i);
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.d("cicloDaVida","onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.d("cicloDaVida","onResume");
    }



    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.d("cicloDaVida","onPause");
    }




    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.d("cicloDaVida","onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.d("cicloDaVida","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        Log.d("cicloDaVida","onDestroy");
    }


}



