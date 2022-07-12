package com.cst2335.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cst2335.listview.R;
import com.cst2335.listview.bean.ItemBean;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<ItemBean> mBeanList;//数据源
    private LayoutInflater mLayoutInflater;//填充布局
    private Context mContext;

    //提供构造函数，当new的时候把这些变量存进来
    public MyAdapter(Context context,List<ItemBean> beanList){
        this.mContext = context;
        this.mBeanList = beanList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    //返回列表有多少条（list）
    public int getCount() {
        return mBeanList.size();
    }

    @Override
    //根据位置，获取这一条
    public Object getItem(int position) {
        return mBeanList.get(position);
    }

    @Override
    //获取id
    public long getItemId(int position) {
        return position;
    }

    @Override
    //生成一个条目，用到一条的布局
    public View getView(int position, View convertView, ViewGroup parent) {
        //创建视图空间：把布局文件导进来
        convertView = mLayoutInflater.inflate(R.layout.list_item_layout,parent,false);

        //填充数据,先找控件
        ImageView imageView = convertView.findViewById(R.id.iv_img);
        TextView title = convertView.findViewById(R.id.tv_title);
        TextView content = convertView.findViewById(R.id.tv_content);

        //根据位置找到数据源,itemBean是一个数据实体
        ItemBean itemBean = mBeanList.get(position);
        //为控件填充数据
        imageView.setImageResource(itemBean.getImgResId());
        title.setText(itemBean.getTitle());
        content.setText(itemBean.getContent());

        return convertView;
    }
}
