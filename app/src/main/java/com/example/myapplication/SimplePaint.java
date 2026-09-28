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

//Variável/parÂmetro  Context permite acessar uma biblioteca android,(ok),
// (e suponho que também informa onde estamos chamando e em qual classe).
public class SimplePaint extends View {
    //mapa, caminho de pontos : PATH
    Path path;
    Paint paint;
    public SimplePaint(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(0xFF000000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        //path.lineTo(x,y);


        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        invalidate();
        return  true;
       // return super.onTouchEvent(event);
    }
    //path
}
