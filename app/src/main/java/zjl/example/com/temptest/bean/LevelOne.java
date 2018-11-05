package zjl.example.com.temptest.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import zjl.example.com.temptest.adapter.MyAdapter;
import zjl.example.com.temptest.adapter.ThreeLevelAdapter;

/**
 * Created by Administrator on 2018/11/5 0005.
 */

public class LevelOne extends AbstractExpandableItem<LevelTwo> implements MultiItemEntity {

    public String title;

    public LevelOne(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return 0;
    }

    @Override
    public int getLevel() {
        return ThreeLevelAdapter.LEVEL_ONE;
    }
}
