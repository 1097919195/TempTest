package zjl.example.com.temptest.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.jaydenxiao.common.commonutils.LogUtils;

import java.util.Timer;
import java.util.TimerTask;

import zjl.example.com.temptest.R;
import zjl.example.com.temptest.widget.RoundProgressBar;

/**
 * Created by Administrator on 2018/10/15 0015.
 */

public class SensorActivity extends Activity {
    RoundProgressBar progressBar;
    int i = 0;
    int random = 1000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        LogUtils.loge("onCreate");

        progressBar = findViewById(R.id.progressBar);
        initView();
    }

    private void initView() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                random = (int) (random * Math.random());
                i = (int) (i + Math.random()*10);
                progressBar.setProgress(i);

                if (i > 10) {
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 1000, random);
//        for (int i=0; i<=100; i++) {
//
//        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_sensor);
        LogUtils.loge("onConfigurationChanged");
    }
}
