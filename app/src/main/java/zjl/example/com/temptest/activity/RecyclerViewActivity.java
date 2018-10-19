package zjl.example.com.temptest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.LinearLayout;

import com.jaydenxiao.common.commonutils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import zjl.example.com.temptest.R;
import zjl.example.com.temptest.adapter.MyAdapter;
import zjl.example.com.temptest.widget.SimpleItemTouchHelperCallback;

/**
 * Created by Administrator on 2018/10/18 0018.
 */

public class RecyclerViewActivity extends Activity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<String> stringList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.rc);
        stringList.add("item0");
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        stringList.add("item4");
        myAdapter = new MyAdapter(this, stringList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//默认
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtil.showShort(String.valueOf(position));
            }
        });

        //先实例化Callback
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(myAdapter);
        //用Callback构造ItemtouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(recyclerView);

    }
}
