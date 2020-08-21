package com.vivek.task_4_onsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Math.PI;
import static java.lang.Math.negateExact;

public class MainActivity extends AppCompatActivity {

    View view;
    canvas canvas;
    ConstraintLayout constraintLayout;
    Handler handler;
    Button start;
    Button reset;
    long startTime;

    long millisec;
    long pausetime=0;

    Boolean timerRunning=false;
    Boolean timerPaused = false;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        canvas = new canvas(this);
        constraintLayout = findViewById(R.id.consLayout);
        constraintLayout.addView(canvas);

        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);

        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!timerRunning) {

                    startTime = System.currentTimeMillis();
                    timerRunning = true;
                    runnable.run();
                    start.setText("Pause");
                }
                else{
                    pausetime=millisec;
                    timerRunning=false;
                    start.setText("Start");
                    timerPaused=true;
                    handler.removeCallbacks(runnable);


                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                millisec=0;
                pausetime=0;
                start.setText("Start");
                timerRunning=false;
                timerPaused=false;
                handler.removeCallbacks(runnable);
                canvas.invalidate();
            }
        });


    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            Log.d("hello", String.valueOf(startTime));

            millisec = System.currentTimeMillis() - startTime+pausetime;
            canvas.invalidate();
            handler.postDelayed(runnable, 10);


        }
    };

    public class canvas extends View {

        CountDownTimer countDownTimer ;

        Paint secPaint;
        Paint minPaint;
        Paint mDrawPaint;
        Bitmap mDrawBitmap;
        Canvas mBitmapCanvas;
        Paint second;
        Paint linePaint;
        Paint linePaintD;
        Paint txtPaint;


        public canvas(Context context) {
            super(context);
            second = new Paint();
            secPaint = new Paint();
            minPaint = new Paint();
            mDrawPaint = new Paint();
            linePaint = new Paint();
            linePaintD = new Paint();
            txtPaint = new Paint();
            secPaint.setAntiAlias(true);
            secPaint.setColor(Color.RED);
            minPaint.setColor(Color.BLUE);
            minPaint.setAntiAlias(true);
            secPaint.setStrokeWidth(20);
            minPaint.setStrokeWidth(5);
            secPaint.setStyle(Paint.Style.STROKE);
            minPaint.setStyle(Paint.Style.STROKE);
            second.setStyle(Paint.Style.FILL);
            second.setAntiAlias(true);
            second.setColor(Color.BLUE);
            second.setStrokeWidth(3);
            linePaint.setStyle(Paint.Style.FILL);
            linePaint.setStrokeWidth(2);
            linePaint.setAntiAlias(true);
            linePaintD.setStyle(Paint.Style.FILL);
            linePaintD.setStrokeWidth(4);
            linePaintD.setAntiAlias(true);
            txtPaint.setStrokeWidth(10);
            txtPaint.setAntiAlias(true);
            txtPaint.setStyle(Paint.Style.FILL);
            txtPaint.setTextSize(30);
            txtPaint.setTextAlign(Paint.Align.CENTER);
            Log.d("time", "hello");


        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int w = getWidth();
            int h = getHeight();
            float cX=0;
            float cY=0;
            float dX=0;
            float dY=0;

            if (mDrawBitmap == null) {
                mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                mBitmapCanvas = new Canvas(mDrawBitmap);
            }
            canvas.drawCircle(w/2,h/2,300,secPaint);
            canvas.drawCircle(w/2,h/2,150,secPaint);

            for(int i=0;i<60;i++){
                float lX = (float) (w/2 + 270*Math.sin(i*6*PI/180));
                float lY= (float) (h/2 - 270*Math.cos(i*6*PI/180));
                float sX = (float) (w/2 + 290*Math.sin((i*6)*PI/180));
                float sY = (float) (h/2 - 290*Math.cos((i*6)*PI/180));
                canvas.drawLine(lX,lY,sX,sY,linePaint);
            }
            for(int i=0;i<4;i++){
                float lX = (float) (w/2 + 250*Math.sin(i*90*PI/180));
                float lY= (float) (h/2 - 250*Math.cos(i*90*PI/180));
                float sX = (float) (w/2 + 290*Math.sin((i*90)*PI/180));
                float sY = (float) (h/2 - 290*Math.cos((i*90)*PI/180));
                canvas.drawLine(lX,lY,sX,sY,linePaintD);

                float txtlX = (float) (w/2 + 220*Math.sin(i*90*PI/180));
                float txtlY= (float) (h/2 - 220*Math.cos(i*90*PI/180));

                canvas.drawText(String.valueOf(i*15),txtlX,txtlY+10,txtPaint);


            }

            for(int i=0;i<60;i++){
                float lX = (float) (w/2 + 120*Math.sin(i*6*PI/180));
                float lY= (float) (h/2 - 120*Math.cos(i*6*PI/180));
                float sX = (float) (w/2 + 140*Math.sin((i*6)*PI/180));
                float sY = (float) (h/2 - 140*Math.cos((i*6)*PI/180));
                canvas.drawLine(lX,lY,sX,sY,linePaint);
            }
            for(int i=0;i<4;i++){
                float lX = (float) (w/2 + 100*Math.sin(i*90*PI/180));
                float lY= (float) (h/2 - 100*Math.cos(i*90*PI/180));
                float sX = (float) (w/2 + 140*Math.sin((i*90)*PI/180));
                float sY = (float) (h/2 - 140*Math.cos((i*90)*PI/180));
                canvas.drawLine(lX,lY,sX,sY,linePaintD);

                float txtlX = (float) (w/2 + 80*Math.sin(i*90*PI/180));
                float txtlY= (float) (h/2 - 80*Math.cos(i*90*PI/180));

                canvas.drawText(String.valueOf(i*15),txtlX,txtlY+10,txtPaint);


            }



            if(!timerPaused&&!timerRunning){
                cX= w/2;
                cY = h/2-300;
                dX = w/2;
                dY = h/2 -150;
            }
            if(timerRunning||timerPaused){
                cX = (float) (w/2 + 300*Math.sin(millisec/166.666667*PI/180));
                cY = (float) (h/2 - 300*Math.cos(millisec/166.666667*PI/180));
                dX = (float) (w/2 + 150*Math.sin((millisec/10000)*PI/180));
                dY = (float) (h/2 - 150*Math.cos((millisec/10000)*PI/180));
            }

           canvas.drawLine(w/2,h/2,cX,cY,second);
           canvas.drawLine(w/2,h/2,dX,dY,second);

            Log.d("hello", String.valueOf(millisec));
//        float time = System.currentTimeMillis();
//        Log.d("time", String.valueOf(time));
//            Log.d("time", "hello");

            canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);

        }
    }


}

