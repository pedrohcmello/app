package com.example.myapplication;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.skydoves.colorpickerview.listeners.ColorPickerViewListener;

public class MainActivity extends AppCompatActivity {
//ColorPickerViewListener


    Button colorButton;
    SimplePaint simplePaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        colorButton = findViewById(R.id.btnColor);
        simplePaint = findViewById(R.id.simplePaint);
        colorButton.setOnClickListener(view -> {

            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Confirma",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setLayoutColor(envelope);
                                }
                            })
                    .setNegativeButton("Cancela",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        });
    }

        public void setLayoutColor(ColorEnvelope envelope){
            simplePaint.setColor(envelope.getColor());
        }


    }



    //VOU PRECISAR  DE  OnTouchEvent



//git checkout -b
//SKIA  --> Biblioteca do Android para componentes e gráficos  2D
// também tem  o  SEEKBAR

//APLICAÇÕES NATIVAS ,  PWAs