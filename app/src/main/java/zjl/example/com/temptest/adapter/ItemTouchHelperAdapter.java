package zjl.example.com.temptest.adapter;

/**
 * Created by Administrator on 2018/10/18 0018.
 */

public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDissmiss(int position);
}

