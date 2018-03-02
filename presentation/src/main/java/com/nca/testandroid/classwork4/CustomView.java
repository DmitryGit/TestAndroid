package com.nca.testandroid.classwork4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private float radius;
    private float cx;
    private float cy;
    private float ch;
    private float cw;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint.setColor(Color.BLUE);
        paint2.setColor(Color.RED);
        paint.setAntiAlias(true);


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
        radius = w > h? h/4: w/4;
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
//        canvas.drawLine(cx, cy, cw, ch, paint2);
//        canvas.drawRect(rect, paint);

        //        canvas.drawArc();
//        canvas.save();
//        canvas.rotate(90, cx, cy);
//        canvas.restore();

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
