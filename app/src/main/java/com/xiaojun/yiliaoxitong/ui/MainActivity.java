package com.xiaojun.yiliaoxitong.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.adapters.LiangBiaoAdapter;
import com.xiaojun.yiliaoxitong.adapters.PopupWindowAdapter;
import com.xiaojun.yiliaoxitong.utils.DateUtils;
import com.xiaojun.yiliaoxitong.views.WrapContentLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends Activity implements View.OnClickListener {
    private int dw, dh;
    private WindowManager wm;
    private LayoutInflater mInflater = null;
    private View view = null;
    private TextView t1, t2, t3, t4, t5, t6;
    private ImageView im1, im2, im3, im4, im5, im6;
    private LinearLayout l1, l2, l3, l4, l5, l6,ll1,ll2;
    private EditText xingming,xingbie,mingzu,chushengriqi,zhiye,zhuceyouxiang,wenhuachengdu,paihang,hunyingzhuangkuang;
    private TextView xiongdijiemei,beishixuexing,beishiliexing,beishilaiyuan,fabingnianling,zongjiaoxingyang,fenchuangnianling,fuqingxueli,muqingxueli,yangyuzhe;
    private Button baocun;
    private PopupWindow popupWindow=null;
    private List<String> stringList=new ArrayList<>();
    private PopupWindowAdapter adapterss;
    private WrapContentLinearLayoutManager linearLayoutManager = null;
    private LRecyclerView lRecyclerView;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private List<String> dataList = new ArrayList<>();;
    private LiangBiaoAdapter taiZhangAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        dw = dm.widthPixels;
        dh = dm.heightPixels;
//        //设置无标题
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //设置横屏
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        mInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert mInflater != null;
        view = mInflater.inflate(R.layout.activity_main, null);
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.OPAQUE;
        wmParams.flags = WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        ;
        wmParams.width = dw;
        wmParams.height = dh;

        t1 = (TextView) view.findViewById(R.id.t1);
        t2 = (TextView) view.findViewById(R.id.t2);
        t3 = (TextView) view.findViewById(R.id.t3);
        t4 = (TextView) view.findViewById(R.id.t4);
        t5 = (TextView) view.findViewById(R.id.t5);
        t6 = (TextView) view.findViewById(R.id.t6);
        l1 = (LinearLayout) view.findViewById(R.id.l1);
        l1.setOnClickListener(this);
        l2 = (LinearLayout) view.findViewById(R.id.l2);
        l2.setOnClickListener(this);
        l3 = (LinearLayout) view.findViewById(R.id.l3);
        l3.setOnClickListener(this);
        l4 = (LinearLayout) view.findViewById(R.id.l4);
        l4.setOnClickListener(this);
        l5 = (LinearLayout) view.findViewById(R.id.l5);
        l5.setOnClickListener(this);
        l6 = (LinearLayout) view.findViewById(R.id.l6);
        l6.setOnClickListener(this);
        ll1= (LinearLayout) view.findViewById(R.id.ll1);
        ll2= (LinearLayout) view.findViewById(R.id.ll2);
        im1 = (ImageView) view.findViewById(R.id.im1);
        im2 = (ImageView) view.findViewById(R.id.im2);
        im3 = (ImageView) view.findViewById(R.id.im3);
        im4 = (ImageView) view.findViewById(R.id.im4);
        im5 = (ImageView) view.findViewById(R.id.im5);
        im6 = (ImageView) view.findViewById(R.id.im6);
        TextView time = (TextView) view.findViewById(R.id.time);
        time.setText(DateUtils.time(System.currentTimeMillis() + ""));
        xingming= (EditText) view.findViewById(R.id.xingming);
        xingbie= (EditText) view.findViewById(R.id.xingbie);
        mingzu= (EditText) view.findViewById(R.id.mingzu);
        chushengriqi= (EditText) view.findViewById(R.id.chushengriqi);
        zhiye= (EditText) view.findViewById(R.id.zhiye);
        zhuceyouxiang= (EditText) view.findViewById(R.id.zhuceyouxiang);
        wenhuachengdu= (EditText) view.findViewById(R.id.wenhuachengdu);
        paihang= (EditText) view.findViewById(R.id.paihang);
        hunyingzhuangkuang= (EditText) view.findViewById(R.id.hunyingzhuangkuang);
        xiongdijiemei= (TextView) view.findViewById(R.id.xiongdijiemei);
        xiongdijiemei.setOnClickListener(this);
        beishixuexing= (TextView) view.findViewById(R.id.beishixuexing);
        beishixuexing.setOnClickListener(this);
        beishiliexing= (TextView) view.findViewById(R.id.beishiliexing);
        beishiliexing.setOnClickListener(this);
        beishilaiyuan= (TextView) view.findViewById(R.id.beishilaiyuan);
        beishilaiyuan.setOnClickListener(this);
        fabingnianling= (TextView) view.findViewById(R.id.fabingnianling);
        fabingnianling.setOnClickListener(this);
        zongjiaoxingyang= (TextView) view.findViewById(R.id.zongjiaoxingyang);
        zongjiaoxingyang.setOnClickListener(this);
        fenchuangnianling= (TextView) view.findViewById(R.id.fenchuangnianlin);
        fenchuangnianling.setOnClickListener(this);
        fuqingxueli= (TextView) view.findViewById(R.id.fuqingxueli);
        fuqingxueli.setOnClickListener(this);
        muqingxueli= (TextView) view.findViewById(R.id.muqingxueli);
        muqingxueli.setOnClickListener(this);
        yangyuzhe= (TextView) view.findViewById(R.id.yangyuzhexueli);
        yangyuzhe.setOnClickListener(this);

        dataList.add("ddd");
        dataList.add("sss");
        dataList.add("ddd");
        dataList.add("sss");
        dataList.add("ddd");
        dataList.add("sss");
        dataList.add("ddd");
        dataList.add("sss");
        dataList.add("ddd");
        dataList.add("sss");
        dataList.add("ddd");
        dataList.add("sss");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");


        linearLayoutManager = new WrapContentLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false);
        lRecyclerView = (LRecyclerView) view.findViewById(R.id.recyclerview);
        taiZhangAdapter = new LiangBiaoAdapter(dataList,MainActivity.this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(taiZhangAdapter);

        lRecyclerView.setLayoutManager(linearLayoutManager);

        lRecyclerView.setAdapter(lRecyclerViewAdapter);

        //设置头部加载颜色
        lRecyclerView.setHeaderViewColor(R.color.colorAccent, R.color.blake ,android.R.color.white);
        lRecyclerView.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        lRecyclerView.setFooterViewColor(R.color.textcolor, R.color.blake ,android.R.color.white);
        //设置底部加载文字提示
        lRecyclerView.setFooterViewHint("拼命加载中","--------我是有底线的--------","网络不给力...");
        lRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerView.setPullRefreshEnabled(false);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }
        });


        wm.addView(view, wmParams);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.l1:
                chongzhi();
                l1.setBackgroundResource(R.color.write);
                im1.setBackgroundResource(R.drawable.lanjiantou);
                t1.setTextColor(Color.parseColor("#008AFF"));
                setViewGoen();
                ll1.setVisibility(View.VISIBLE);
                break;
            case R.id.l2:
                chongzhi();
                l2.setBackgroundResource(R.color.write);
                im2.setBackgroundResource(R.drawable.lanjiantou);
                t2.setTextColor(Color.parseColor("#008AFF"));
                setViewGoen();
                ll2.setVisibility(View.VISIBLE);
                break;
            case R.id.l3:
                chongzhi();
                l3.setBackgroundResource(R.color.write);
                im3.setBackgroundResource(R.drawable.lanjiantou);
                t3.setTextColor(Color.parseColor("#008AFF"));
                break;
            case R.id.l4:
                chongzhi();
                l4.setBackgroundResource(R.color.write);
                im4.setBackgroundResource(R.drawable.lanjiantou);
                t4.setTextColor(Color.parseColor("#008AFF"));
                break;
            case R.id.l5:
                chongzhi();
                l5.setBackgroundResource(R.color.write);
                im5.setBackgroundResource(R.drawable.lanjiantou);
                t5.setTextColor(Color.parseColor("#008AFF"));
                break;
            case R.id.l6:
                chongzhi();
                l6.setBackgroundResource(R.color.write);
                im6.setBackgroundResource(R.drawable.lanjiantou);
                t6.setTextColor(Color.parseColor("#008AFF"));
                break;
            case R.id.xiongdijiemei:
                View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.xiangmu_po_item, null);
                ListView listView= (ListView) contentView.findViewById(R.id.dddddd);
                adapterss=new PopupWindowAdapter(MainActivity.this,stringList);
                listView.setAdapter(adapterss);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        xiongdijiemei.setText(stringList.get(position));
                        popupWindow.dismiss();
                    }
                });

                popupWindow=new PopupWindow(contentView,180, setListViewHeightBasedOnChildren(listView));
                popupWindow.setFocusable(true);//获取焦点
                popupWindow.setOutsideTouchable(true);//获取外部触摸事件
                popupWindow.setTouchable(true);//能够响应触摸事件
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));//设置背景
                popupWindow.showAsDropDown(xiongdijiemei,0,0);
                break;
            case R.id.beishixuexing:

                break;
            case R.id.beishiliexing:

                break;
            case R.id.beishilaiyuan:

                break;
            case R.id.fabingnianling:

                break;
            case R.id.zongjiaoxingyang:

                break;
            case R.id.fenchuangnianlin:

                break;
            case R.id.fuqingxueli:

                break;
            case R.id.muqingxueli:

                break;
            case R.id.yangyuzhexueli:

                break;


        }


    }

    private void setViewGoen(){
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);

    }

    private void chongzhi() {
        l1.setBackgroundResource(R.color.blake);
        im1.setBackgroundResource(R.drawable.baijiantou);
        t1.setTextColor(Color.parseColor("#ffffff"));
        l2.setBackgroundResource(R.color.blake);
        im2.setBackgroundResource(R.drawable.baijiantou);
        t2.setTextColor(Color.parseColor("#ffffff"));
        l3.setBackgroundResource(R.color.blake);
        im3.setBackgroundResource(R.drawable.baijiantou);
        t3.setTextColor(Color.parseColor("#ffffff"));
        l4.setBackgroundResource(R.color.blake);
        im4.setBackgroundResource(R.drawable.baijiantou);
        t4.setTextColor(Color.parseColor("#ffffff"));
        l5.setBackgroundResource(R.color.blake);
        im5.setBackgroundResource(R.drawable.baijiantou);
        t5.setTextColor(Color.parseColor("#ffffff"));
        l6.setBackgroundResource(R.color.blake);
        im6.setBackgroundResource(R.drawable.baijiantou);
        t6.setTextColor(Color.parseColor("#ffffff"));


    }

    public  int setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return 0;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            // listItem.measure(0, 0);
            listItem.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += listItem.getMeasuredHeight();
        }

//        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height = totalHeight
//                + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
//        listView.setLayoutParams(params);
        return totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
    }
}
