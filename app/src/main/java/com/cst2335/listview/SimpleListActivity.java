package com.cst2335.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleListActivity extends AppCompatActivity {
    //listview
    private ListView mListView;
    //adapter
    private SimpleAdapter mSimpleAdapter;
    //data,according to SimpleAdapter
    private List<Map<String,Object>> mList;
    //声明图片
    private int[] imgs = {
            R.drawable.cherry,
            R.drawable.jam,
            R.drawable.pear,
            R.drawable.taco,
            R.drawable.watermelon
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        mListView = findViewById(R.id.lv);
        //数据初始化
        mList = new ArrayList<>();
        //填充图片数据,告诉他键-值
        for (int i=0; i<50;i++){
          Map<String,Object> map = new HashMap();
          //取余，为了防止数组越界，因为只有5张图片。两种方法： i%5, i%imgs.length
          map.put("img",imgs[i%5]);
          map.put("title","这里是标题"+i);
          map.put("content","这里是内容"+i);

          mList.add(map);
        }

        mSimpleAdapter = new SimpleAdapter(this,mList,R.layout.list_item_layout,
                new String[]{"img","title","content"},
                new int[]{R.id.iv_img,R.id.tv_title,R.id.tv_content});

        mListView.setAdapter(mSimpleAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this,"click"+position,Toast.LENGTH_SHORT).show();
            }
        });


    }
}