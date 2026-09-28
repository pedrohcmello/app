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

        path.lineTo(x,y);
        invalidate();
        return super.onTouchEvent(event);
    }
    //path
}
