

package com.ifsc.app;

import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main));
        Insets systemBars = insets.getInsets(WindowsInsetCompat.Type.SystemBars());
        v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom);
        return insets;
    };
Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
Log.d(tag:"cicloDaVida",msg:"onDestroy");


        @Override
        protected void onStart(){
            super.onStart();
            Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
            Log.d(tag:"cicloDaVida",msg:"onStart");
        }

        @Override
        protected void onResume(){
            super.onResume();
            Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
            Log.d(tag:"cicloDaVida",msg:"onResume");
        }


        @Override
        protected void onPause(){
            super.onPause();
            Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
            Log.d(tag:"cicloDaVida",msg:"onPause");
    }




        @Override
        protected void onStop(){
            super.onStop();
            Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
            Log.d(tag:"cicloDaVida",msg:"onStop");
        }

            @Override
            protected void onRestart(){
            super.onRestart();
            Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
                Log.d(tag:"cicloDaVida",msg:"onRestart");
            }

                @Override
                protected void onDestroy() {
            super.onDestroy();
            Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
                    Log.d(tag:"cicloDaVida",msg:"onDestroy");
                }


}



