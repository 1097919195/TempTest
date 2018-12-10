package zjl.example.com.temptest.activity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;

import butterknife.BindView;
import zjl.example.com.temptest.R;

public class TimeAxisActivity extends BaseActivity {
    TextView tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_timeaxis;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        tv = findViewById(R.id.tv);
    }

    public void startAnim(View view) {
//        ObjectAnimator.ofFloat(tv,"rotationX", 0.0F, 360.0F)
//                .setDuration(3000)
//                .start();


//        ValueAnimator animator = ValueAnimator.ofFloat(0, tv.getHeight());
//        animator.setDuration(1000).start();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//        {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation)
//            {
//                tv.setTranslationY((Float) animation.getAnimatedValue());
//            }
//        });

        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(tv,scaleY).setDuration(2000).start();
    }
}
