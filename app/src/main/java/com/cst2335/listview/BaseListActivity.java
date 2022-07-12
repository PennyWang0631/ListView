package com.cst2335.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cst2335.listview.adapter.MyAdapter;
import com.cst2335.listview.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class BaseListActivity extends AppCompatActivity {
    private ListView mListView;
    //需要一个数据源
    private List<ItemBean> mBeanList;
    //需要一个桥梁adapter
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_list);

        //初始化view
        initView();
        //初始化数据
        initData();
        //把数据和listview关联起来
        initEvent();

    }



    private void initView(){
        //activity和layout绑定
        mListView = findViewById(R.id.lv);
    }

    private void initData(){
        mBeanList = new ArrayList<>();
        //设定一些假数据
        //创造一条数据
        ItemBean itemBean1 = new ItemBean();
        itemBean1.setTitle("果酱");
        itemBean1.setContent("果酱是把水果、糖及酸度调节剂混合后，用超过100℃温度熬制而成的凝胶物质，也叫果子酱。");
        itemBean1.setImgResId(R.drawable.jam);

        ItemBean itemBean2 = new ItemBean();
        itemBean2.setTitle("樱桃");
        itemBean2.setContent("樱桃（学名：Cerasus spp.）是蔷薇科、樱属几种植物的统称。世界上作为栽培的樱桃仅有4种");
        itemBean2.setImgResId(R.drawable.cherry);

        ItemBean itemBean3 = new ItemBean();
        itemBean3.setTitle("鸭梨");
        itemBean3.setContent("梨，通常品种是一种落叶乔木或灌木，极少数品种为常绿，属于被子植物门双子叶植物纲蔷薇科苹果亚科。");
        itemBean3.setImgResId(R.drawable.pear);

        ItemBean itemBean4 = new ItemBean();
        itemBean4.setTitle("塔可");
        itemBean4.setContent("源自墨西哥风味玉米饼，也称为墨西哥卷。数百年来，玉米一直是墨西哥食品中的主角，而以玉米为原料制成的Tortia饼也是墨西哥最基本、也最有特色的食品");
        itemBean4.setImgResId(R.drawable.taco);

        ItemBean itemBean5 = new ItemBean();
        itemBean5.setTitle("西瓜");
        itemBean5.setContent("西瓜为夏季之水果，果肉味甜，能降温去暑；种子含油，可作消遣食品；果皮药用，有清热、利尿、降血压之效。");
        itemBean5.setImgResId(R.drawable.watermelon);

        mBeanList.add(itemBean1);
        mBeanList.add(itemBean2);
        mBeanList.add(itemBean3);
        mBeanList.add(itemBean4);
        mBeanList.add(itemBean5);
        mBeanList.add(itemBean1);
        mBeanList.add(itemBean2);
        mBeanList.add(itemBean3);
        mBeanList.add(itemBean4);
        mBeanList.add(itemBean5);
        mBeanList.add(itemBean1);
        mBeanList.add(itemBean2);
        mBeanList.add(itemBean3);
        mBeanList.add(itemBean4);
        mBeanList.add(itemBean5);
        mBeanList.add(itemBean1);
        mBeanList.add(itemBean2);
        mBeanList.add(itemBean3);
        mBeanList.add(itemBean4);
        mBeanList.add(itemBean5);

    }

    private void initEvent() {
        mMyAdapter = new MyAdapter(this,mBeanList);
        //为listview设置识别器
        mListView.setAdapter(mMyAdapter);
        //点击方法
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ItemBean itemBean = mBeanList.get(position);
                String title = itemBean.getTitle();
                Toast.makeText(BaseListActivity.this,"click"+position+title,Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}