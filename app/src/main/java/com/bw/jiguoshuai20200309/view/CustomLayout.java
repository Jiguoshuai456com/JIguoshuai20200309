package com.bw.jiguoshuai20200309.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.bw.jiguoshuai20200309.R;
/**
 * 季国帅
 * 20200309
 */
public class CustomLayout extends View {

    private Paint paint;
    int[] data;
    private int color;

    public CustomLayout(Context context) {
        super(context);
        init();

    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomLayout);
//        ⑧　使用自定义属性可以配置折线图折线的颜色。
        color = typedArray.getColor(R.styleable.CustomLayout_co, Color.RED);
        init();
    }
    public void init(){
        paint = new Paint();
        paint.setColor(color);

    }
    public void getData(int[] Data){
        data=Data;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        ⑥　自定义View完成折线图X轴和Y轴刻度的绘制，刻度之间的间距是相同的
        int saX=100;
        int saY=200;
        for (int i=0;i<data.length;i++){
//            ⑦　自定义View完成X轴、Y轴和折线的绘制。
            canvas.drawLine(saX,saY,saX+100,200-data[i],paint);
            saX+=100;
            saY=200-data[i];
        }
    }
}
