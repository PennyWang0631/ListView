package com.cst2335.listview;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.cst2335.listview.databinding.ActivityArrayListBinding;

import java.util.ArrayList;
import java.util.List;

public class ArrayListActivity extends AppCompatActivity {
    private ListView mListView;
    private List<String> mStringList;
    //<String>与你的数据mStringList类型一致
    private ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        mListView = findViewById(R.id.lv);
        //数据的初始化
        mStringList = new ArrayList<>();

        //加50条数据data
        for (int i=0; i<50;i++){
            mStringList.add("这是条目"+i);
        }

        //创建adapter，第一个是上下文，第二个是布局，第三部分是数据
        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mStringList);
        //用adapter链接listview和data
        //设置一下适配器
        mListView.setAdapter(mArrayAdapter);

        //点击每一个条目，有所相应
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ArrayListActivity.this,"你点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });

        //长按的
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ArrayListActivity.this,"你长按了"+position,Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }
}