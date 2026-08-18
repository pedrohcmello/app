

package com.ifsc.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        Button b = findViewById(R.id.button);
        TextView tv = findViewById(R.id.tv);

        tv.setText(Integer.toString(contador));


        b.setOnClickListener(v -> {
            contador++;
            tv.setText(Integer.toString(contador));



        });
    }
}

