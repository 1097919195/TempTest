package zjl.example.com.temptest.activity;


import android.view.View;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;

import util.UpdateAppUtils;
import zjl.example.com.temptest.R;
import zjl.example.com.temptest.widget.CircleView;
import zjl.example.com.temptest.widget.SideBar;

public class MainActivity extends BaseActivity {
    SideBar sideBar;
    TextView dialog;
    CircleView circleView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        UpdateAppUtils.from(this)
                .checkBy(UpdateAppUtils.CHECK_BY_VERSION_NAME) //更新检测方式，默认为VersionCode
                .serverVersionCode(2)
                .serverVersionName("2.0")
                .apkPath("https://www.npclo.com/dlo")
                .showNotification(true) //是否显示下载进度到通知栏，默认为true
                .updateInfo("更新更新")  //更新日志信息 String
                .downloadBy(UpdateAppUtils.DOWNLOAD_BY_APP) //下载方式：app下载、手机浏览器下载。默认app下载
                .isForce(false) //是否强制更新，默认false 强制更新情况下用户不同意更新则不能使用app
                .update();


        dialog = findViewById(R.id.dialog);
        sideBar = findViewById(R.id.sideBar);
        sideBar.setTextView(dialog);
        //根据活动的位置可以做出响应的监听事件
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {

            }
        });

        circleView = findViewById(R.id.circleView);
        circleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleView.invalidate();
            }
        });

    }
}
