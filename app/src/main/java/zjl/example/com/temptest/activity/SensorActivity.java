package zjl.example.com.temptest.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.jaydenxiao.common.commonutils.LogUtils;

import zjl.example.com.temptest.R;

/**
 * Created by Administrator on 2018/10/15 0015.
 */

public class SensorActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        LogUtils.loge("onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_sensor);
        LogUtils.loge("onConfigurationChanged");
    }
}
