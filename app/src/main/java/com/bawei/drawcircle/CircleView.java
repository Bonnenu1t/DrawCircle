package com.bawei.drawcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Bonnenu1t丶 on 2017/6/6.
 */

public class CircleView extends View {

    Paint paint;
    private float x = 100;
    private float y = 100;

    //矩形
    Rect rect=new Rect();

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        paint.setColor(Color.YELLOW);
        //AntiAlias 抗锯齿
        paint.setAntiAlias(true);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,50,paint);
        //通过矩形设置来判断
        rect.set((int)(x-50),(int)(y-50),(int)(x+50),(int)(y+50));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :

                break;
            case MotionEvent.ACTION_MOVE :


                float x1 = event.getX();
                float y1 = event.getY();
                if (x1>rect.left && x1<rect.right && y1>rect.top && y1<rect.bottom){
                    x=event.getX();
                    y=event.getY();
                    //主线程调用刷新
                    invalidate();
                }

                //子线程 调用刷新
                //postInvalidate();
                break;
            case MotionEvent.ACTION_UP :

                break;
            case MotionEvent.ACTION_CANCEL :

                break;
        }

        return true;

    }
}
