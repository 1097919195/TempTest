package zjl.example.com.temptest.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import zjl.example.com.temptest.activity.ThreeLevelActivity;
import zjl.example.com.temptest.adapter.MyAdapter;
import zjl.example.com.temptest.adapter.ThreeLevelAdapter;

/**
 * Created by Administrator on 2018/11/5 0005.
 */

public class LevelTwo extends AbstractExpandableItem<LevelThree> implements MultiItemEntity {

    public String title;

    public LevelTwo(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return 1;
    }

    @Override
    public int getLevel() {
        return ThreeLevelAdapter.LEVEL_TWO;
    }
}
