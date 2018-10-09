package zjl.example.com.temptest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import zjl.example.com.temptest.R;

/**
 * Created by Administrator on 2018/10/8 0008.
 */

public class CustomViewGroup extends LinearLayout {
    /**
     * 画笔
     */
    private Paint paint;

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);         // 解析自定义布局
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.custom_viewgroup, this);
        // 设置抗锯齿，防抖动效果
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        setWillNotDraw(false);//在构造函数里面，调用setWillNotDraw(false)，去掉其WILL_NOT_DRAW flag
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //由于特殊需求，在加载布局之后，还需要进行绘图操作
        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
    }
}
