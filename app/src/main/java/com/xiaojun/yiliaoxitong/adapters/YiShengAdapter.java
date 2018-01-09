package com.xiaojun.yiliaoxitong.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.beans.YiShengBeans;

import java.util.List;

/**
 * Created by Administrator on 2017/10/3.
 */


public class YiShengAdapter extends RecyclerView.Adapter<YiShengAdapter.ViewHolder> {
    private List<YiShengBeans.DataBean.RowsBean> datas;
    private Context context=null;
    private String zhuji;

    public YiShengAdapter(List<YiShengBeans.DataBean.RowsBean> datas, Context context,String zhuji) {
        this.datas = datas;
        this.context=context;
        this.zhuji=zhuji;

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
        Glide.with(context)
                .load(zhuji+datas.get(position).getHead_url())
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                //  .transform(new GlideCircleTransform(RenGongFuWuActivity.this,1, Color.parseColor("#ffffffff")))
                .into(viewHolder.touxiang);
        viewHolder.name.setText(datas.get(position).getReal_name());
        viewHolder.zhiyeyiyuan.setText(datas.get(position).getPractice_hospital());
        viewHolder.keshi.setText(datas.get(position).getDepartment());
        viewHolder.zhicheng.setText(datas.get(position).getTitle());
        viewHolder.mengzhengdidian.setText(datas.get(position).getOutpatient_site());
        viewHolder.lingchuangshanchang.setText(datas.get(position).getClinical_expertise());

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
      private ImageView touxiang;


        private ViewHolder(View view){
            super(view);
           name= (TextView) view.findViewById(R.id.name);
            zhiyeyiyuan= (TextView) view.findViewById(R.id.zhiyeyiyuan);
            keshi= (TextView) view.findViewById(R.id.keshi);
            zhicheng= (TextView) view.findViewById(R.id.zhicheng);
            mengzhengdidian= (TextView) view.findViewById(R.id.mengzhengdidian);
            lingchuangshanchang= (TextView) view.findViewById(R.id.lingchuangshanchang);
            top_bg= (LinearLayout) view.findViewById(R.id.top_bg);
            touxiang= (ImageView) view.findViewById(R.id.touxiang);
        }
    }



}
