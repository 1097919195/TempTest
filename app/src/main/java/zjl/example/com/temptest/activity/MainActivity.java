package zjl.example.com.temptest.activity;


import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import util.UpdateAppUtils;
import zjl.example.com.temptest.R;
import zjl.example.com.temptest.app.AppConstant;
import zjl.example.com.temptest.widget.CircleView;
import zjl.example.com.temptest.widget.SideBar;

public class MainActivity extends BaseActivity {
    SideBar sideBar;
    TextView dialog;
    CircleView circleView;
    EditText editText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        SimpleDateFormat bDate=new SimpleDateFormat("yyyy-MMMMMM-dddddd");
        long now=System.currentTimeMillis();
        System.err.println(aDate.format(now));
        System.err.println(bDate.format(now));

        String s = "qwer?asdf";
        String newS = s.substring(s.indexOf("?")+1,s.length()-1);
        LogUtils.loge("substring=====" + newS);
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


        editText = findViewById(R.id.editText);
        editText.setError("报错了！");

//        //返回的对象不同
//        int s = Integer.parseInt("s");
//        Integer s1 = Integer.valueOf("s");

        findViewById(R.id.timeBtn).setOnClickListener(v -> {
            Intent intent = new Intent(this, TimeAxisActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.three).setOnClickListener(v -> {
            Intent intent = new Intent(this, ThreeLevelActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.sensorBtn).setOnClickListener(v -> {
            Intent intent = new Intent(this, SensorActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.recyclerViewBtn).setOnClickListener(v -> {
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.lockBtn).setOnClickListener(v -> {
            Intent intent = new Intent(this, DirectionDragActivity.class);
            startActivity(intent);
        });

        //7.1才支持添加shortcut
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N_MR1){
            //代码中动态添加shortcut
            dynamicAddShortCut();
        }
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    private void dynamicAddShortCut() {
        Intent intent = new Intent();
        intent.setAction(AppConstant.ACTION_ADD_SHORTCUT);
        intent.setClassName("zjl.example.com.temptest",
                "zjl.example.com.temptest.activity.MainActivity");
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(this, "dynamic shortcut")
                .setIntent(intent)
                .setShortLabel("This is a dynamic shortcut")
                .setLongLabel("This is a dynamic shortcut with long label")
                .setIcon(Icon.createWithResource(this, R.drawable.ic_image_loading));
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        shortcutManager.addDynamicShortcuts(Arrays.asList(builder.build()));
    }
}
