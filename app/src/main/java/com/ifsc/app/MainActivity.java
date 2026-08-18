

package com.ifsc.app;

import android.os.Bundle;
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


        EditText edmin,edmax;


        edmin=findViewById(R.id.edmin);
        edmax=findViewById(R.id.edmax);

        Button b = findViewById(R.id.button);
        TextView tv = findViewById(R.id.tv);

        tv.setText("");



        b.setOnClickListener(v -> {
            String smin=edmin.getText().toString();
            String smax=edmax.getText().toString();

            if(smin.isEmpty()){
                edmin.setError("Informe um inteiro");
                return;
            }
            if(smax.isEmpty()){
                edmax.setError("Informe um inteiro");
                return;
            }

            int min = Integer.parseInt(smin);
            int max = Integer.parseInt(smax);

            if(min > max){
                Toast.makeText(this,"Defina Mínimo < Máximo",Toast.LENGTH_SHORT).show();
                return;
            }
            Random random = new Random();
            int randomN = random.nextInt(min,max);
            tv.setText(Integer.toString(randomN));



        });
    }
}

