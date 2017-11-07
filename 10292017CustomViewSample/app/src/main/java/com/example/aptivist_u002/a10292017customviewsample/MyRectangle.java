package com.example.aptivist_u002.a10292017customviewsample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Aptivist-U002 on 10/29/2017.
 */

public class MyRectangle extends View {
    private static final String TAG = "MyRectangleTAG_";

    private Paint paint;
    private Paint paintCircle;
    private Canvas canvas;
    private Rect rect;
    private Rect square;
    private boolean drawCircle;
    private boolean drawSquare;
    private int setShapeColor;

    public MyRectangle(Context context) {
        this(context, null);
    }

    public MyRectangle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyRectangle: ");

        if (attrs != null) {
            parseAttributes(attrs);
        }

        rect = new Rect(100, 100, 300, 250);
        square = new Rect(600, 600, 300, 300);
        paint = new Paint();
        paintCircle = new Paint();
        paint.setColor(setShapeColor);
        paintCircle.setColor(Color.CYAN);



    }

    private void parseAttributes(AttributeSet attrs) {
        TypedArray typedArray =
                getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.MyRectangle, 0, 0);

        try {
            boolean showCircle = typedArray.getBoolean(R.styleable.MyRectangle_showCircle, false);
            boolean showSquare = typedArray.getBoolean(R.styleable.MyRectangle_showSquare, false);
            int shapeColor = typedArray.getColor(R.styleable.MyRectangle_shapeColor, Color.GRAY);
            drawCircle = showCircle;
            drawSquare = showSquare;
            setShapeColor = shapeColor;


            Log.d(TAG, "parseAttributes: " + showCircle + " " + showSquare + " " + setShapeColor);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: " + widthMeasureSpec + " " + heightMeasureSpec);
        //how many pixels am I using
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d(TAG, "onLayout: " + changed + " " + left + " " + top + " "+ right + " " + bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
        canvas.drawColor(Color.BLACK);
        canvas.drawRect(rect, paint);
        if (drawSquare){
        canvas.drawRect(square, paint);}
        if (drawCircle){
        canvas.drawCircle(600, 600, 100, paintCircle);}

//        Paint paint = new Paint();
//
//        canvas.drawPaint(paint);
//
//        paint.setStrokeWidth(4);
//        paint.setColor(android.graphics.Color.RED);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setAntiAlias(true);
//
//        Point a = new Point(0, 0);
//        Point b = new Point(0, 100);
//        Point c = new Point(87, 50);
//
//        Path path = new Path();
//        path.setFillType(Path.FillType.EVEN_ODD);
//        path.lineTo(b.x, b.y);
//        path.lineTo(c.x, c.y);
//        path.lineTo(a.x, a.y);
//        path.close();
//
//        canvas.drawPath(path, paint);
    }
}
