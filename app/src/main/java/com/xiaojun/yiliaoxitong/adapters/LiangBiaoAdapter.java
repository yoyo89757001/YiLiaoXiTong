package com.xiaojun.yiliaoxitong.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaojun.yiliaoxitong.R;
import java.util.List;

/**
 * Created by Administrator on 2017/10/3.
 */


public class LiangBiaoAdapter extends RecyclerView.Adapter<LiangBiaoAdapter.ViewHolder> {
    private List<String> datas;
    private Context context=null;

    public LiangBiaoAdapter(List<String> datas, Context context) {
        this.datas = datas;
        this.context=context;

    }


    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yuangong_item,viewGroup,false);
        return new ViewHolder(view);

    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //判断是否显示字母标题

        viewHolder.mingcheng.setText(datas.get(position));


    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
      class ViewHolder extends RecyclerView.ViewHolder {
      private   TextView bianhao,mingcheng,shijian,caozuo;


        private ViewHolder(View view){
            super(view);
           bianhao= (TextView) view.findViewById(R.id.xuhao);
            mingcheng= (TextView) view.findViewById(R.id.mingcheng);
            shijian= (TextView) view.findViewById(R.id.shijian);
            caozuo= (TextView) view.findViewById(R.id.caozuo);


        }
    }



}
