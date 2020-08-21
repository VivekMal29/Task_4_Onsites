package com.vivek.task_4_onsites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

//public class canvas extends View {
//
//    CountDownTimer countDownTimer ;
//
//    Paint secPaint;
//    Paint minPaint;
//    Paint mDrawPaint;
//    Bitmap mDrawBitmap;
//    Canvas mBitmapCanvas;
//
//
//    public canvas(Context context) {
//        super(context);
//        secPaint = new Paint();
//        minPaint = new Paint();
//        mDrawPaint = new Paint();
//        secPaint.setAntiAlias(true);
//        secPaint.setColor(Color.RED);
//        minPaint.setColor(Color.BLUE);
//        minPaint.setAntiAlias(true);
//        secPaint.setStrokeWidth(20);
//        minPaint.setStrokeWidth(5);
//        secPaint.setStyle(Paint.Style.STROKE);
//        minPaint.setStyle(Paint.Style.STROKE);
//        Log.d("time", "hello");
//
//
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        int w = getWidth();
//        int h = getHeight();
//
//        if (mDrawBitmap == null) {
//            mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
//            mBitmapCanvas = new Canvas(mDrawBitmap);
//        }
//        mBitmapCanvas.drawCircle(w/2,h/2,300,secPaint);
//
////        float time = System.currentTimeMillis();
////        Log.d("time", String.valueOf(time));
////        Log.d("time", "hello");
//
//        canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);
//
//    }
//}
