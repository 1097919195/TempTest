package zjl.example.com.temptest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jaydenxiao.common.commonutils.LogUtils;

/**
 * Created by Administrator on 2018/9/30 0030.
 */

public class CircleView extends View {
    Paint mPaint;


    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtils.loge("onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(16);
        canvas.drawText("起点(20,100)", 22, 100, mPaint);
        canvas.drawText("终点(50,100)", 52, 150, mPaint);
        canvas.drawLine(20, 100, 50, 150, mPaint);
        LogUtils.loge("onDraw");
    }
}
