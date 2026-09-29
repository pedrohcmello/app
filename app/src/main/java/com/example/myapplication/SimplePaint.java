package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//Variável/parÂmetro  Context permite acessar uma biblioteca android,(ok),
// (e suponho que também informa onde estamos chamando e em qual classe).
public class SimplePaint extends View {
    //mapa, caminho de pontos : PATH
    Path mpath;
    Paint mpaint;

    ArrayList<Paint> paintList;
    ArrayList<Path> pathList;

    public SimplePaint(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        mpath = new Path();
        mpaint = new Paint();
        mpaint.setStrokeWidth(5);
        mpaint.setColor(0xFF000000);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setAntiAlias(true);

        paintList=new ArrayList<>();
        pathList=new ArrayList<>();
    }


    //simplepaint
    //path paint,  para não colorir defina que cada toque é um PATH

    //Como isso vai ocorrer ?
    //Resposta : ATRAVÉS de um ARRAYLIST  de PATH






    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i<paintList.size();i++){
            canvas.drawPath(pathList.get(i), paintList.get(i));
        }
   canvas.drawPath(mpath, mpaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        //path.lineTo(x,y);


        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mpath.moveTo(x,y);
                return true;
            case MotionEvent.ACTION_MOVE:
                mpath.lineTo(x,y);
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return  true;
       // return super.onTouchEvent(event);
    }

    public void setColor(int color) {
        //CRIAR NOVA CAMADA(layer)
        paintList.add(mpaint);
        pathList.add(mpath);
        mpath = new Path();
        mpaint = new Paint(mpaint);

        mpaint.setColor(color);
        invalidate();
    }
    //path
}
