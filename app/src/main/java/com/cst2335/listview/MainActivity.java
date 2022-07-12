package com.cst2335.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //activity_main button onclick点击的活动（跳转到ArrayListActivity.class）
    public void toArrayListTest(View view){
        Intent intent = new Intent (this, ArrayListActivity.class);
        startActivity(intent);


    }

    public void toSimpleListTest(View view){
        Intent intent = new Intent(this,SimpleListActivity.class);
        startActivity(intent);
    }

    public void toBaseListTest(View view){
        Intent intent = new Intent(this, BaseListActivity.class );
        startActivity(intent);
    }
}