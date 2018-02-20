package com.nca.testandroid.hw4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextView;

import com.nca.testandroid.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WatchView extends View {

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private float radius;
    private float cx;
    private float cy;
    private float ch;
    private float cw;
    private RectF rect;

    private Date date;
    private Calendar calendar;

    public WatchView(Context context) {
        super(context);
        init();
    }

    public WatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint.setColor(Color.BLUE);
        paint2.setColor(Color.RED);
        paint.setAntiAlias(true);
//        long time = new Date().getTime();
        date  = new Date();
        calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

//        new AnalogClock
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ch = h;
        cw = w;
        radius = w > h? h/2: w/2;
        cx = w/2;
        cy = h/2;

        float wRec = w * 0.9f;
        float hRec = h * 0.2f;
        rect = new RectF();
        rect.left = (w - wRec) / 2;
        rect.right = w - rect.left;
        rect.top = (h - hRec) / 2;;
        rect.bottom = h - rect.top;;

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

//        invalidate();
        canvas.drawCircle(cx, cy, radius, paint);

        canvas.save();
        paint2.setStrokeWidth(20f);
        paint2.setColor(Color.GRAY);
        int degree = 0;
        while(degree < 360) {
            canvas.drawLine(cx, cy+radius-30, cx, cy+radius, paint2);
            degree = degree + 30;
            canvas.rotate(30, cx, cy);
        }
        canvas.restore();

//        canvas.drawRect(rect, paint);
        //        canvas.drawArc();

        int size = 120;
        paint2.setColor(Color.GREEN);
        paint2.setTextSize((float)size);
        paint2.setFakeBoldText(true);
        canvas.drawText("9", cx*0.1f, cy+cy*0.05f, paint2);
        canvas.drawText("12", cx-cx*0.13f, cy-radius+cy*0.2f, paint2);
        canvas.drawText("3", cx+radius-cx*0.25f, cy+cy*0.05f, paint2);
        canvas.drawText("6", cx-cx*0.06f, cy+radius-cy*0.1f, paint2);

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        paint2.setColor(Color.BLACK);
        canvas.drawCircle(cx, cy, 15f, paint2);
        paint2.setStrokeWidth(20f);
        canvas.save();
        canvas.rotate(minute*6-180, cx, cy);
        canvas.drawLine(cx, cy, cx, cy+radius-cy*0.1f, paint2);
        canvas.restore();
        paint2.setStrokeWidth(30f);
        canvas.save();
        canvas.rotate(hour*30-180+minute*0.5f, cx, cy);
        canvas.drawLine(cx, cy, cx, cy+radius-cy*0.2f, paint2);
        canvas.restore();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {

                rect.contains(event.getX(), event.getY()); // проверка: попадает ли в квадрат

                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;
//                break;
            }
        }
        return true;
//        return super.onTouchEvent(event);
    }
}
