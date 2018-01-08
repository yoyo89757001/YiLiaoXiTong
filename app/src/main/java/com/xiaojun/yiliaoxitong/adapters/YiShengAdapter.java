package com.xiaojun.yiliaoxitong.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaojun.yiliaoxitong.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/3.
 */


public class YiShengAdapter extends RecyclerView.Adapter<YiShengAdapter.ViewHolder> {
    private List<String> datas;
    private Context context=null;

    public YiShengAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context=context;

    }


    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yisheng_item,viewGroup,false);
        return new ViewHolder(view);

    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //判断是否显示字母标题

        viewHolder.name.setText(datas.get(position));
        if (position%2==1){
            viewHolder.top_bg.setBackgroundResource(R.color.huise2);
        }else {
            viewHolder.top_bg.setBackgroundResource(R.color.write);
        }



    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
      class ViewHolder extends RecyclerView.ViewHolder {
      private   TextView name,zhiyeyiyuan,keshi,zhicheng,mengzhengdidian,lingchuangshanchang;
      private LinearLayout top_bg;


        private ViewHolder(View view){
            super(view);
           name= (TextView) view.findViewById(R.id.name);
            zhiyeyiyuan= (TextView) view.findViewById(R.id.zhiyeyiyuan);
            keshi= (TextView) view.findViewById(R.id.keshi);
            zhicheng= (TextView) view.findViewById(R.id.zhicheng);
            mengzhengdidian= (TextView) view.findViewById(R.id.mengzhengdidian);
            lingchuangshanchang= (TextView) view.findViewById(R.id.lingchuangshanchang);
            top_bg= (LinearLayout) view.findViewById(R.id.top_bg);


        }
    }



}
