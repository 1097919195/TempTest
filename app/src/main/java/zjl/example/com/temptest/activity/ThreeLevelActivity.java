package zjl.example.com.temptest.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;

import zjl.example.com.temptest.R;

/**
 * Created by Administrator on 2018/11/5 0005.
 */


import zjl.example.com.temptest.adapter.MyAdapter;
import zjl.example.com.temptest.adapter.ThreeLevelAdapter;
import zjl.example.com.temptest.bean.LevelOne;
import zjl.example.com.temptest.bean.LevelThree;
import zjl.example.com.temptest.bean.LevelTwo;

public class ThreeLevelActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView rvMain;
    private ArrayList<MultiItemEntity> multiList = new ArrayList<>();
    private ThreeLevelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threelevel);
        mContext = this;

        initView();
        initData();

    }

    private void initView() {

        rvMain = (RecyclerView) findViewById(R.id.rv_main);

    }

    private void initData() {

        multiList = generateData();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new ThreeLevelAdapter(this, multiList);
        rvMain.setLayoutManager(manager);
        rvMain.setAdapter(adapter);

        // 使一级列表默认展开
        for (int i = multiList.size() - 1; i >= 0; i--) {
            adapter.expand(i, false, false);
        }

    }


    private ArrayList<MultiItemEntity> generateData() {

        int levelOne = 10;
        int levelTwo = 3;

        ArrayList<MultiItemEntity> res = new ArrayList<>();

        for (int i = 0; i < levelOne; i++) {

            LevelOne lv1 = new LevelOne("一级列表" + i);

            for (int j = 0; j < levelTwo; j++) {

                LevelTwo lv2 = new LevelTwo("二级列表：" + j);

                lv2.addSubItem(new LevelThree("三级列表" + j, "德玛西亚：" + j
                ));

                lv1.addSubItem(lv2);
            }
            res.add(lv1);
        }
        return res;
    }
}
