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
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaojun.yiliaoxitong.MyApplication;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.adapters.DeFenAdapter;
import com.xiaojun.yiliaoxitong.adapters.LiangBiaoAdapter;
import com.xiaojun.yiliaoxitong.adapters.PopupWindowAdapter;
import com.xiaojun.yiliaoxitong.adapters.YiShengAdapter;
import com.xiaojun.yiliaoxitong.beans.DeFenBean;
import com.xiaojun.yiliaoxitong.beans.DengLuBean;
import com.xiaojun.yiliaoxitong.beans.DengLuBeanDao;
import com.xiaojun.yiliaoxitong.beans.GeRenXinXi;
import com.xiaojun.yiliaoxitong.beans.LiangBiaoBean;
import com.xiaojun.yiliaoxitong.beans.YiShengBeans;
import com.xiaojun.yiliaoxitong.beans.YiShengInFoBean;
import com.xiaojun.yiliaoxitong.utils.DateUtils;
import com.xiaojun.yiliaoxitong.utils.GsonUtil;
import com.xiaojun.yiliaoxitong.views.WrapContentLinearLayoutManager;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends Activity implements View.OnClickListener {
    private int dw, dh;
    private int qingQiuYe=1;
    private int qingQiuYe2=1;
    private WindowManager wm;
    private String datestrold;
    private String datestr;
    private LayoutInflater mInflater = null;
    private View view = null;
    private TextView t1, t2, t3, t4, t5;
    private ImageView im1, im2, im3, im4, im5, datouxiang,tanchuang2,tuichu,im11,im22,im33,im44,im55;
    private LinearLayout l1, l2, l3, l4, l5, ll1, ll2, ll3, ll4, ll5;
    private EditText xingming, xingbie, mingzu, zhiye, zhuceyouxiang, wenhuachengdu, paihang,
            hunyingzhuangkuang, mima1, mima2, mima3, liangbiaosousuo, yisheng_sousuo,defensousuo;
    private TextView chushengriqi,haoma, xiongdijiemei, beishixuexing, beishiliexing, beishilaiyuan, fabingnianling, zongjiaoxingyang, fenchuangnianling, fuqingxueli, muqingxueli, yangyuzhe;
    private Button baocun, fanhui_ys, xiugaimima,a5,a6;
    private TextView xingming_ys, xingbie_ys, mingzu_ys, chushengriqi_ys, zhiyeyiyuan, keshi, zhicheng, mengzhengdidian, lingchuangshanchang;
    private PopupWindow popupWindow = null,popupWindow_rq = null;
    private List<String> stringList = new ArrayList<>();
    private PopupWindowAdapter adapterss;
    private LRecyclerView lRecyclerView, lRecyclerView_ys,lRecyclerView_df;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter_ys;
    private LRecyclerViewAdapter lRecyclerViewAdapter_df;
    private List<LiangBiaoBean.DataBean.GuagesBean.RowsBean> dataList = new ArrayList<>();
    private List<DeFenBean.DataBean.RowsBean> deFendataList = new ArrayList<>();
    private List<YiShengBeans.DataBean.RowsBean> dataList_ys = new ArrayList<>();
    private LiangBiaoAdapter taiZhangAdapter;
    private DeFenAdapter deFenAdapter;
    private YiShengAdapter yiShengAdapter;
    private DengLuBeanDao dengLuBeanDao = null;
    private DengLuBean dengLuBean = null;
    private long id = -2;
    private ScrollView scrollView_ys;
    private String case_number = null;
    private RelativeLayout tanchuang1;
    private WebView webView,webView2;
    DatePicker  datePicker;
    TimePicker  timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dengLuBeanDao = MyApplication.getAppContext().getDaoSession().getDengLuBeanDao();
        dengLuBean = dengLuBeanDao.load(123456L);

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
        wmParams.screenOrientation=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        wmParams.flags = WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
        ;
        wmParams.width = dw;
        wmParams.height = dh;

        webView= (WebView) view.findViewById(R.id.web);
        webView2= (WebView) view.findViewById(R.id.web2);

        WebSettings webSettings = webView.getSettings();
        WebSettings webSettings2 = webView2.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
        //支持插件
        // webSettings.setPluginsEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setAppCacheEnabled(true);
        //设置 缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        webSettings.setDomStorageEnabled(true);
        //其他细节操作
        //  webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webView.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webSettings2.setJavaScriptEnabled(true);
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
        //支持插件
        // webSettings.setPluginsEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings2.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings2.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //缩放操作
        webSettings2.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings2.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings2.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings2.setAppCacheEnabled(true);
        //设置 缓存模式
        webSettings2.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 开启 DOM storage API 功能
        webSettings2.setDomStorageEnabled(true);
        //其他细节操作
        //  webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings2.setAllowFileAccess(true); //设置可以访问文件
        webSettings2.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings2.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings2.setDefaultTextEncodingName("utf-8");//设置编码格式
        webView2.setWebViewClient(new WebViewClient() {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        t1 = (TextView) view.findViewById(R.id.t1);
        t2 = (TextView) view.findViewById(R.id.t2);
        t3 = (TextView) view.findViewById(R.id.t3);
        t4 = (TextView) view.findViewById(R.id.t4);
        t5 = (TextView) view.findViewById(R.id.t5);
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
        ll1 = (LinearLayout) view.findViewById(R.id.ll1);
        ll2 = (LinearLayout) view.findViewById(R.id.ll2);
        ll3 = (LinearLayout) view.findViewById(R.id.ll3);
        ll4 = (LinearLayout) view.findViewById(R.id.ll4);
        ll5 = (LinearLayout) view.findViewById(R.id.ll5);
        im1 = (ImageView) view.findViewById(R.id.im1);
        im2 = (ImageView) view.findViewById(R.id.im2);
        im3 = (ImageView) view.findViewById(R.id.im3);
        im4 = (ImageView) view.findViewById(R.id.im4);
        im5 = (ImageView) view.findViewById(R.id.im5);
        im11 = (ImageView) view.findViewById(R.id.im11);
        im22 = (ImageView) view.findViewById(R.id.im22);
        im33 = (ImageView) view.findViewById(R.id.im33);
        im44 = (ImageView) view.findViewById(R.id.im44);
        im55 = (ImageView) view.findViewById(R.id.im55);
        tuichu= (ImageView) view.findViewById(R.id.tuichu);
        tuichu.setOnClickListener(this);
        tanchuang2= (ImageView) view.findViewById(R.id.tanchuang2);
        tanchuang1= (RelativeLayout) view.findViewById(R.id.tanchuang);
        a5= (Button) view.findViewById(R.id.a5);
        a5.setOnClickListener(this);
        a6= (Button) view.findViewById(R.id.a6);
        a6.setOnClickListener(this);
        xiugaimima = (Button) view.findViewById(R.id.xiugaimima);
        xiugaimima.setOnClickListener(this);
        mima1 = (EditText) view.findViewById(R.id.mima1);
        mima2 = (EditText) view.findViewById(R.id.mima2);
        mima3 = (EditText) view.findViewById(R.id.mima3);

        datouxiang = (ImageView) view.findViewById(R.id.datouxiang);
        TextView time = (TextView) view.findViewById(R.id.time);
        TextView time2 = (TextView) view.findViewById(R.id.time2);
        time.setText(DateUtils.time(System.currentTimeMillis() + ""));
        time2.setText(DateUtils.time(System.currentTimeMillis() + ""));
        xingming = (EditText) view.findViewById(R.id.xingming);
        xingbie = (EditText) view.findViewById(R.id.xingbie);
        mingzu = (EditText) view.findViewById(R.id.mingzu);
        chushengriqi = (TextView) view.findViewById(R.id.chushengriqi);
        chushengriqi.setOnClickListener(this);
        zhiye = (EditText) view.findViewById(R.id.zhiye);
        zhuceyouxiang = (EditText) view.findViewById(R.id.zhuceyouxiang);
        wenhuachengdu = (EditText) view.findViewById(R.id.wenhuachengdu);
        paihang = (EditText) view.findViewById(R.id.paihang);
        hunyingzhuangkuang = (EditText) view.findViewById(R.id.hunyingzhuangkuang);
        xiongdijiemei = (TextView) view.findViewById(R.id.xiongdijiemei);
        xiongdijiemei.setOnClickListener(this);
        beishixuexing = (TextView) view.findViewById(R.id.beishixuexing);
        beishixuexing.setOnClickListener(this);
        beishiliexing = (TextView) view.findViewById(R.id.beishiliexing);
        beishiliexing.setOnClickListener(this);
        beishilaiyuan = (TextView) view.findViewById(R.id.beishilaiyuan);
        beishilaiyuan.setOnClickListener(this);
        fabingnianling = (TextView) view.findViewById(R.id.fabingnianling);
        fabingnianling.setOnClickListener(this);
        zongjiaoxingyang = (TextView) view.findViewById(R.id.zongjiaoxingyang);
        zongjiaoxingyang.setOnClickListener(this);
        fenchuangnianling = (TextView) view.findViewById(R.id.fenchuangnianlin);
        fenchuangnianling.setOnClickListener(this);
        fuqingxueli = (TextView) view.findViewById(R.id.fuqingxueli);
        fuqingxueli.setOnClickListener(this);
        muqingxueli = (TextView) view.findViewById(R.id.muqingxueli);
        muqingxueli.setOnClickListener(this);
        yangyuzhe = (TextView) view.findViewById(R.id.yangyuzhexueli);
        yangyuzhe.setOnClickListener(this);
        baocun = (Button) view.findViewById(R.id.baocun2);
        baocun.setOnClickListener(this);
        haoma = (TextView) view.findViewById(R.id.haoma);
        haoma.setText(dengLuBean.getUsername());
        fanhui_ys = (Button) view.findViewById(R.id.fanhui_ys);
        fanhui_ys.setOnClickListener(this);
        xingming_ys = (TextView) view.findViewById(R.id.xingming_ys);
        xingbie_ys = (TextView) view.findViewById(R.id.xingbie_ys);
        mingzu_ys = (TextView) view.findViewById(R.id.mingzu_ys);
        chushengriqi_ys = (TextView) view.findViewById(R.id.shengri_ys);
        zhiyeyiyuan = (TextView) view.findViewById(R.id.zhiyeyiyuan_ys);
        keshi = (TextView) view.findViewById(R.id.keshi_ys);
        zhicheng = (TextView) view.findViewById(R.id.zhicheng_ys);
        mengzhengdidian = (TextView) view.findViewById(R.id.mengzhengdidian_ys);
        lingchuangshanchang = (TextView) view.findViewById(R.id.lingchuangshanchang_ys);
        scrollView_ys = (ScrollView) view.findViewById(R.id.scrollView2);
        liangbiaosousuo = (EditText) view.findViewById(R.id.liangbiaosuosuo);
        yisheng_sousuo = (EditText) view.findViewById(R.id.yisheng_sousuo);


        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");

        lRecyclerView = (LRecyclerView) view.findViewById(R.id.recyclerview);
        lRecyclerView_df = (LRecyclerView) view.findViewById(R.id.recyclerview2);
        lRecyclerView_ys = (LRecyclerView) view.findViewById(R.id.recyclerview_ys);

        taiZhangAdapter = new LiangBiaoAdapter(dataList, MainActivity.this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(taiZhangAdapter);
        lRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        lRecyclerView.setAdapter(lRecyclerViewAdapter);
        //设置头部加载颜色
        lRecyclerView.setHeaderViewColor(R.color.colorAccent, R.color.blake, android.R.color.white);
        lRecyclerView.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        lRecyclerView.setFooterViewColor(R.color.textcolor, R.color.blake, android.R.color.white);
        //设置底部加载文字提示
        lRecyclerView.setFooterViewHint("拼命加载中", "--------我是有底线的--------", "网络不给力...");
        lRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerView.setPullRefreshEnabled(false);
        lRecyclerView.setLoadMoreEnabled(true);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                link_liangbiao_url(dataList.get(position).getGuage_id());

            }
        });
        lRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                qingQiuYe++;
                //加载更多
                link_liangbiao_list(qingQiuYe,20);

            }
        });

        //得分报告的
        deFenAdapter = new DeFenAdapter(deFendataList, MainActivity.this);
        lRecyclerViewAdapter_df = new LRecyclerViewAdapter(deFenAdapter);
        lRecyclerView_df.setLayoutManager(new WrapContentLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        lRecyclerView_df.setAdapter(lRecyclerViewAdapter_df);
        //设置头部加载颜色
        lRecyclerView_df.setHeaderViewColor(R.color.colorAccent, R.color.blake, android.R.color.white);
        lRecyclerView_df.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        lRecyclerView_df.setFooterViewColor(R.color.textcolor, R.color.blake, android.R.color.white);
        //设置底部加载文字提示
        lRecyclerView_df.setFooterViewHint("拼命加载中", "--------我是有底线的--------", "网络不给力...");
        lRecyclerView_df.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerView_df.setPullRefreshEnabled(false);
        lRecyclerView_df.setLoadMoreEnabled(true);
        lRecyclerViewAdapter_df.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                lRecyclerView_df.setVisibility(View.GONE);
                webView2.setVisibility(View.VISIBLE);
                webView2.loadUrl(deFendataList.get(position).getReport_url());

            }
        });
        lRecyclerView_df.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                qingQiuYe2++;
                //加载更多
                link_liangbiao_list2(qingQiuYe2,20);

            }
        });

        //医生的
        yiShengAdapter = new YiShengAdapter(dataList_ys, MainActivity.this, dengLuBean.getZhuji());
        lRecyclerViewAdapter_ys = new LRecyclerViewAdapter(yiShengAdapter);
        lRecyclerView_ys.setLayoutManager(new WrapContentLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        lRecyclerView_ys.setAdapter(lRecyclerViewAdapter_ys);
        //设置头部加载颜色
        lRecyclerView_ys.setHeaderViewColor(R.color.colorAccent, R.color.blake, android.R.color.white);
        lRecyclerView_ys.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        lRecyclerView_ys.setFooterViewColor(R.color.textcolor, R.color.blake, android.R.color.white);
        //设置底部加载文字提示
        lRecyclerView_ys.setFooterViewHint("拼命加载中", "--------我是有底线的--------", "网络不给力...");
        lRecyclerView_ys.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerView_ys.setPullRefreshEnabled(false);

        lRecyclerViewAdapter_ys.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ll3.setVisibility(View.GONE);
                scrollView_ys.setVisibility(View.VISIBLE);
                link_ys_info(dataList_ys.get(position).getUser_id());

            }
        });


        wm.addView(view, wmParams);

        link_info();
        link_ys_list(1, 10, null);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.l1:
                chongzhi();
                l1.setBackgroundResource(R.color.write);
                im1.setBackgroundResource(R.drawable.lanjiantou);
                im11.setBackgroundResource(R.drawable.gerenxinxi);
                t1.setTextColor(Color.parseColor("#008AFF"));
                baocun.setText("保 存");
                setViewGoen();
                ll1.setVisibility(View.VISIBLE);
                break;
            case R.id.l2:
                chongzhi();

                l2.setBackgroundResource(R.color.write);
                im2.setBackgroundResource(R.drawable.lanjiantou);
                im22.setBackgroundResource(R.drawable.liangbiao);
                t2.setTextColor(Color.parseColor("#008AFF"));
                setViewGoen();
                ll2.setVisibility(View.VISIBLE);
                HideKeyboard(liangbiaosousuo);
                if (id!=-2)
                link_liangbiao_list(1,20);
                lRecyclerView.setVisibility(View.VISIBLE);
                webView.setVisibility(View.GONE);
                break;
            case R.id.l3:
                chongzhi();
                l3.setBackgroundResource(R.color.write);
                im3.setBackgroundResource(R.drawable.lanjiantou);
                im33.setBackgroundResource(R.drawable.yisheng);
                t3.setTextColor(Color.parseColor("#008AFF"));
                setViewGoen();
                ll3.setVisibility(View.VISIBLE);
                HideKeyboard(yisheng_sousuo);
                break;
            case R.id.l4:
                chongzhi();
                l4.setBackgroundResource(R.color.write);
                im4.setBackgroundResource(R.drawable.lanjiantou);
                im44.setBackgroundResource(R.drawable.defenbaogao);
                t4.setTextColor(Color.parseColor("#008AFF"));
                setViewGoen();
                ll4.setVisibility(View.VISIBLE);
                link_liangbiao_list2(1,20);
                lRecyclerView_df.setVisibility(View.VISIBLE);
                webView2.setVisibility(View.GONE);
                break;
            case R.id.l5:
                chongzhi();
                l5.setBackgroundResource(R.color.write);
                im5.setBackgroundResource(R.drawable.lanjiantou);
                im55.setBackgroundResource(R.drawable.xiugaimima);
                t5.setTextColor(Color.parseColor("#008AFF"));
                setViewGoen();
                ll5.setVisibility(View.VISIBLE);
                break;

            case R.id.baocun2:

                link_xiugai_info();

                break;

            case R.id.fanhui_ys:
                scrollView_ys.setVisibility(View.GONE);
                ll3.setVisibility(View.VISIBLE);
                break;
            case R.id.a5:
                startActivity(new Intent(MainActivity.this,LogingActivity.class));
                finish();

                break;
            case R.id.a6:
                tanchuang1.setVisibility(View.GONE);
                tanchuang2.setVisibility(View.GONE);
                break;
            case R.id.tuichu:
                tanchuang1.setVisibility(View.VISIBLE);
                tanchuang2.setVisibility(View.VISIBLE);
                break;
            case R.id.xiugaimima:
                if (!mima1.getText().toString().trim().equals("") && !mima2.getText().toString().trim().equals("") && !mima3.getText().toString().trim().equals("")) {
                    link_xiugaimima();
                }
                break;
            case R.id.xiugaimima2:


                break;
            case R.id.xiongdijiemei:
                View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.xiangmu_po_item, null);
                ListView listView = (ListView) contentView.findViewById(R.id.dddddd);
                adapterss = new PopupWindowAdapter(MainActivity.this, stringList);
                listView.setAdapter(adapterss);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        xiongdijiemei.setText(stringList.get(position));
                        if (!MainActivity.this .isFinishing() && popupWindow.isShowing())
                        {
                            popupWindow.dismiss();
                            popupWindow.setFocusable(false);
                        }
                    }
                });

                popupWindow = new PopupWindow(contentView, 180, setListViewHeightBasedOnChildren(listView));
                popupWindow.setFocusable(true);//获取焦点
                popupWindow.setOutsideTouchable(true);//获取外部触摸事件
                popupWindow.setTouchable(true);//能够响应触摸事件
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));//设置背景
                popupWindow.showAsDropDown(xiongdijiemei, 0, 0);
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
            case R.id.chushengriqi:
                View contentView2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.riqi, null);

                  datePicker= (DatePicker) contentView2.findViewById(R.id.date_picker);
                  timePicker= (TimePicker) contentView2.findViewById(R.id.time_picker);
                  Button quxiao= (Button) contentView2.findViewById(R.id.repair_date_sel_cancel);
                  quxiao.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          back(true,popupWindow_rq);

                      }
                  });
                Button queding= (Button) contentView2.findViewById(R.id.repair_date_sel_ok);
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        back(false,popupWindow_rq);

                    }
                });
                datePicker.setCalendarViewShown(false);
                timePicker.setIs24HourView(true);
                resizePikcer(datePicker);// 调整datepicker大小
                resizePikcer(timePicker);// 调整timepicker大小
                String str = getIntent().getStringExtra("date");
                if (TextUtils.isEmpty(str)) {

                    datestrold = "";
                    datestr = "";
                } else {
                    datestr = str;
                    datestrold = str;
                }

                popupWindow_rq = new PopupWindow(contentView2, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow_rq.setFocusable(true);//获取焦点
                popupWindow_rq.setOutsideTouchable(true);//获取外部触摸事件
                popupWindow_rq.setTouchable(true);//能够响应触摸事件
                popupWindow_rq.setBackgroundDrawable(new ColorDrawable(0x00000000));//设置背景
                popupWindow_rq.showAsDropDown(chushengriqi, 0, 0);
                break;


        }


    }

    /**
     * 调整FrameLayout大小
     *
     * @param tp
     */
    private void resizePikcer(FrameLayout tp) {
        List<NumberPicker> npList = findNumberPicker(tp);
        for (NumberPicker np : npList) {
            resizeNumberPicker(np);
        }
    }

    /*
     * 调整numberpicker大小
     */
    private void resizeNumberPicker(NumberPicker np) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(this, 55),
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(dip2px(this, 5), 0, dip2px(this, 5), 0);
        np.setLayoutParams(params);

    }
    public  int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 得到viewGroup里面的numberpicker组件
     *
     * @param viewGroup
     * @return
     */
    private List<NumberPicker> findNumberPicker(ViewGroup viewGroup) {
        List<NumberPicker> npList = new ArrayList<NumberPicker>();
        View child = null;
        if (null != viewGroup) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                child = viewGroup.getChildAt(i);
                if (child instanceof NumberPicker) {
                    npList.add((NumberPicker) child);
                } else if (child instanceof LinearLayout) {
                    List<NumberPicker> result = findNumberPicker((ViewGroup) child);
                    if (result.size() > 0) {
                        return result;
                    }
                }
            }
        }
        return npList;
    }



    /**
     * 关闭调用 old为true则不变，false则改变
     *
     * @param
     */
    private void back(boolean old,PopupWindow popupWindow) {
        // 获取时间选择
        Intent intent = new Intent();
        if (old) {
            popupWindow.dismiss();
        } else {
            datestr = getData();
            //	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
//				Date date = sdf.parse(datestr);
//				if (!compare(date))
//					return;
                chushengriqi.setText(datestr.substring(0,10));
               popupWindow.dismiss();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }





    private String getData() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            StringBuilder str = new StringBuilder().append(datePicker.getYear()).append("-")
                    .append((datePicker.getMonth() + 1) < 10 ? "0" + (datePicker.getMonth() + 1)
                            : (datePicker.getMonth() + 1))
                    .append("-")
                    .append((datePicker.getDayOfMonth() < 10) ? "0" + datePicker.getDayOfMonth()
                            : datePicker.getDayOfMonth())
                    .append(" ")
                    .append((timePicker.getHour() < 10) ? "0" + timePicker.getHour()
                            : timePicker.getHour())
                    .append(":").append((timePicker.getMinute() < 10) ? "0" + timePicker.getMinute()
                            : timePicker.getMinute());

            return str.toString();
        }else {

            StringBuilder str = new StringBuilder().append(datePicker.getYear()).append("-")
                    .append((datePicker.getMonth() + 1) < 10 ? "0" + (datePicker.getMonth() + 1)
                            : (datePicker.getMonth() + 1))
                    .append("-")
                    .append((datePicker.getDayOfMonth() < 10) ? "0" + datePicker.getDayOfMonth()
                            : datePicker.getDayOfMonth())
                    .append(" ")
                    .append((timePicker.getCurrentHour() < 10) ? "0" + timePicker.getCurrentHour()
                            : timePicker.getCurrentHour())
                    .append(":").append((timePicker.getCurrentMinute() < 10) ? "0" + timePicker.getCurrentMinute()
                            : timePicker.getCurrentMinute());

            return str.toString();

        }

    }

    //隐藏虚拟键盘
    public void HideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }

    private void setViewGoen() {
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ll3.setVisibility(View.GONE);
        ll4.setVisibility(View.GONE);
        ll5.setVisibility(View.GONE);
        scrollView_ys.setVisibility(View.GONE);
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
        im11.setBackgroundResource(R.drawable.gerenxinxi2);
        im22.setBackgroundResource(R.drawable.liangbiao2);
        im33.setBackgroundResource(R.drawable.yisheng2);
        im44.setBackgroundResource(R.drawable.defenbaogao2);
        im55.setBackgroundResource(R.drawable.xiugaimima2);

    }

    public int setListViewHeightBasedOnChildren(ListView listView) {
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


    private void link_info() {
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type","password")
//                .add("username","13488888888")
//                .add("password","123")
//                .build();

        Request.Builder requestBuilder = new Request.Builder()
                // .post(body)
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                .get()
                .url(dengLuBean.getZhuji() + "/api/memberships/info");

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss);

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    final GeRenXinXi zhaoPianBean = gson.fromJson(jsonObject, GeRenXinXi.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (zhaoPianBean.getData()!=null) {
                                xingming.setText(zhaoPianBean.getData().getReal_name()==null?"":zhaoPianBean.getData().getReal_name());
                                xingbie.setText(zhaoPianBean.getData().getGender()==null?"":zhaoPianBean.getData().getGender());
                                mingzu.setText(zhaoPianBean.getData().getNation()==null?"":zhaoPianBean.getData().getNation());
                                chushengriqi.setText(zhaoPianBean.getData().getBirthday()==null?"":zhaoPianBean.getData().getBirthday().substring(0, 10));
                                zhiye.setText(zhaoPianBean.getData().getVocation()==null?"":zhaoPianBean.getData().getVocation());
                                zhuceyouxiang.setText(zhaoPianBean.getData().getEmail()==null?"":zhaoPianBean.getData().getEmail());
                                wenhuachengdu.setText(zhaoPianBean.getData().getEducation()==null?"":zhaoPianBean.getData().getEducation());
                                xiongdijiemei.setText(zhaoPianBean.getData().getSiblings() + ""==null?"":zhaoPianBean.getData().getSiblings() + "");
                                paihang.setText(zhaoPianBean.getData().getRaking() + ""==null?"":zhaoPianBean.getData().getRaking() + "");
                                hunyingzhuangkuang.setText(zhaoPianBean.getData().getMarital_status()==null?"":zhaoPianBean.getData().getMarital_status());
                                beishixuexing.setText(zhaoPianBean.getData().getBlood_type()==null?"":zhaoPianBean.getData().getBlood_type());
                                beishiliexing.setText(zhaoPianBean.getData().getType()==null?"":zhaoPianBean.getData().getType());
                                beishilaiyuan.setText(zhaoPianBean.getData().getSource()==null?"":zhaoPianBean.getData().getSource());
                                fabingnianling.setText(zhaoPianBean.getData().getAge_of_onset() + ""==null?"":zhaoPianBean.getData().getAge_of_onset() + "");
                                zongjiaoxingyang.setText(zhaoPianBean.getData().getReligion()==null?"":zhaoPianBean.getData().getReligion());
                                fenchuangnianling.setText(zhaoPianBean.getData().getSeparate_beds_age() + ""==null?"":zhaoPianBean.getData().getSeparate_beds_age() + "");
                                fuqingxueli.setText(zhaoPianBean.getData().getFather_education()==null?"":zhaoPianBean.getData().getFather_education());
                                muqingxueli.setText(zhaoPianBean.getData().getMonther_education()==null?"":zhaoPianBean.getData().getMonther_education());
                                yangyuzhe.setText(zhaoPianBean.getData().getPrimary_rear_education()==null?"":zhaoPianBean.getData().getPrimary_rear_education());
                                id = zhaoPianBean.getData().getId();
                                case_number = zhaoPianBean.getData().getCase_number();

                            }
                        }
                    });


                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_xiugai_info() {
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();
        baocun.setText("保存中...");

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", id);
            jsonObject.put("case_number", case_number);
            jsonObject.put("real_name", xingming.getText().toString().trim());
            jsonObject.put("gender", xingbie.getText().toString().trim());
            jsonObject.put("nation", mingzu.getText().toString().trim());
            jsonObject.put("birthday", chushengriqi.getText().toString().trim());
            jsonObject.put("vocation", zhiye.getText().toString().trim());
            jsonObject.put("phone_number", dengLuBean.getUsername());
            jsonObject.put("education", wenhuachengdu.getText().toString().trim());
            jsonObject.put("password", dengLuBean.getPassword());
            jsonObject.put("siblings", xiongdijiemei.getText().toString().trim());
            jsonObject.put("raking", paihang.getText().toString().trim());
            jsonObject.put("marital_status", hunyingzhuangkuang.getText().toString().trim());
            jsonObject.put("age_of_onset", fabingnianling.getText().toString().trim());
            jsonObject.put("email", zhuceyouxiang.getText().toString().trim());
            jsonObject.put("doctor", dengLuBean.getZhuzhiyisheng());
            // jsonObject.put("diagnosed","");
            jsonObject.put("blood_type", beishixuexing.getText().toString().trim());
            jsonObject.put("type", beishiliexing.getText().toString().trim());
            jsonObject.put("source", beishilaiyuan.getText().toString().trim());
            // jsonObject.put("province",beishiliexing.getText().toString().trim());
            jsonObject.put("religion", zongjiaoxingyang.getText().toString().trim());
            jsonObject.put("separate_beds_age", fenchuangnianling.getText().toString().trim());
            jsonObject.put("father_education", fuqingxueli.getText().toString().trim());
            jsonObject.put("monther_education", muqingxueli.getText().toString().trim());
            jsonObject.put("primary_rear_education", yangyuzhe.getText().toString().trim());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                .post(body)
                // .get()
                .url(dengLuBean.getZhuji() + "/api/memberships");

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        baocun.setText("网络出错");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss);

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    if (jsonObject.get("error_code").getAsInt() == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                baocun.setText("修改成功");

                            }
                        });
                    }

                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            baocun.setText("修改失败");

                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_ys_list(int pageIndex, int pageSize, String userName) {
        // showDialog();
        //  final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type","password")
//                .add("username","13488888888")
//                .add("password","123")
//                .build();
        Request.Builder requestBuilder = null;
        if (userName != null) {
            requestBuilder = new Request.Builder()
                    // .post(body)
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/doctors?" + "PageIndex=" + pageIndex + "&" + "pageSize=" + pageSize + "&" + "UserName=" + userName);
        } else {
            requestBuilder = new Request.Builder()
                    // .post(body)
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/doctors?" + "PageIndex=" + pageIndex + "&" + "pageSize=" + pageSize);
        }
        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss);

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    final YiShengBeans zhaoPianBean = gson.fromJson(jsonObject, YiShengBeans.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (zhaoPianBean != null && zhaoPianBean.getData() != null && zhaoPianBean.getData().getRows() != null)
                                dataList_ys.addAll(zhaoPianBean.getData().getRows());
                            yiShengAdapter.notifyDataSetChanged();

                        }
                    });


                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_liangbiao_list(int pageIndex, int pageSize) {
        // showDialog();
        //  final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type","password")
//                .add("username","13488888888")
//                .add("password","123")
//                .build();
        Request.Builder requestBuilder = null;

            requestBuilder = new Request.Builder()
                    // .post(body)
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/guages/join?" + "PageIndex=" + pageIndex + "&" + "PageSize=" + pageSize+"&UserId="+id);

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (dataList.size()!=0){
                                dataList.clear();
                            }
                             lRecyclerView.refreshComplete(20);// REQUEST_COUNT为每页加载数量
                            taiZhangAdapter.notifyDataSetChanged();
                        }
                    });}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss);

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    final LiangBiaoBean zhaoPianBean = gson.fromJson(jsonObject, LiangBiaoBean.class);
                    if (qingQiuYe==1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (dataList.size()!=0){
                                    dataList.clear();
                                }
                                dataList.addAll(zhaoPianBean.getData().getGuages().getRows()!=null?zhaoPianBean.getData().getGuages().getRows():new ArrayList<LiangBiaoBean.DataBean.GuagesBean.RowsBean>());

                                lRecyclerView.refreshComplete(dataList.size());// REQUEST_COUNT为每页加载数量
                                taiZhangAdapter.notifyDataSetChanged();
                                //  Log.d("Fragment1", "dataList.size():" + dataList.size());
                            }
                        });


                }else {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int size=zhaoPianBean.getData().getGuages().getRows().size();
                                for (int i=0;i<size;i++){
                                    dataList.add(zhaoPianBean.getData().getGuages().getRows().get(i));
                                }

                                lRecyclerView.refreshComplete(20);// REQUEST_COUNT为每页加载数量
                                taiZhangAdapter.notifyDataSetChanged();
                                //  Log.d("Fragment1", "dataList.size():" + dataList.size());
                            }
                        });
                    }


                if (zhaoPianBean.getData().getGuages().getRows().size()==0 && dataList.size()>=20){

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lRecyclerView.setNoMore(true);
                            }
                        });

                }

                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_liangbiao_list2(int pageIndex, int pageSize) {
        // showDialog();
        //  final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type","password")
//                .add("username","13488888888")
//                .add("password","123")
//                .build();
        Request.Builder requestBuilder = null;

            requestBuilder = new Request.Builder()
                    // .post(body)
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/guages/personalreport?" +"userid="+id+"&PageIndex=" + pageIndex + "&" + "PageSize=" + pageSize);


        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (deFendataList.size()!=0){
                            deFendataList.clear();
                        }
                        lRecyclerView_df.refreshComplete(20);// REQUEST_COUNT为每页加载数量
                        deFenAdapter.notifyDataSetChanged();
                    }
                });}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss);

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    final DeFenBean zhaoPianBean = gson.fromJson(jsonObject, DeFenBean.class);
                    if (qingQiuYe2==1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (deFendataList.size()!=0){
                                    deFendataList.clear();
                                }
                                deFendataList.addAll(zhaoPianBean.getData()!=null?zhaoPianBean.getData().getRows():new ArrayList<DeFenBean.DataBean.RowsBean>());

                                lRecyclerView_df.refreshComplete(deFendataList.size());// REQUEST_COUNT为每页加载数量
                                deFenAdapter.notifyDataSetChanged();
                                //  Log.d("Fragment1", "dataList.size():" + dataList.size());
                            }
                        });


                    }else {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int size=zhaoPianBean.getData().getRows().size();
                                for (int i=0;i<size;i++){
                                    deFendataList.add(zhaoPianBean.getData().getRows().get(i));
                                }

                                lRecyclerView_df.refreshComplete(20);// REQUEST_COUNT为每页加载数量
                                deFenAdapter.notifyDataSetChanged();
                                //  Log.d("Fragment1", "dataList.size():" + dataList.size());
                            }
                        });
                    }


                    if (zhaoPianBean.getData().getRows().size()==0 && deFendataList.size()>=20){

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                lRecyclerView_df.setNoMore(true);
                            }
                        });

                    }

                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_liangbiao_url(String guageid) {
        // showDialog();
        //  final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type","password")
//                .add("username","13488888888")
//                .add("password","123")
//                .build();
        Request.Builder requestBuilder = null;

        requestBuilder = new Request.Builder()
                // .post(body)
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                .get()
                .url(dengLuBean.getZhuji() + "/api/guages/url/"+id+"/"+guageid);

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });}
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss+" ddd");

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                  final String sss= jsonObject.get("data").getAsString();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            lRecyclerView.setVisibility(View.GONE);
                            webView.setVisibility(View.VISIBLE);
                            webView.loadUrl(sss);
                        }
                    });


                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_ys_info(int id) {
        // showDialog();
        //   final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        RequestBody body = new FormBody.Builder()
//                .add("grant_type","password")
//                .add("username","13488888888")
//                .add("password","123")
//                .build();
        Request.Builder requestBuilder = null;
        requestBuilder = new Request.Builder()
                // .post(body)
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                .get()
                .url(dengLuBean.getZhuji() + "/api/doctors/" + id);

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", "医生信息" + ss);

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    final YiShengInFoBean zhaoPianBean = gson.fromJson(jsonObject, YiShengInFoBean.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            xingming_ys.setText(zhaoPianBean.getData().getReal_name());
                            xingbie_ys.setText(zhaoPianBean.getData().getGender());
                            mingzu_ys.setText(zhaoPianBean.getData().getNation());
                            chushengriqi_ys.setText(zhaoPianBean.getData().getBirthday().substring(0, 10));
                            zhiyeyiyuan.setText(zhaoPianBean.getData().getPractice_hospital());
                            keshi.setText(zhaoPianBean.getData().getDepartment());
                            zhicheng.setText(zhaoPianBean.getData().getTitle());
                            mengzhengdidian.setText(zhaoPianBean.getData().getOutpatient_site());
                            lingchuangshanchang.setText(zhaoPianBean.getData().getClinical_expertise());
                            Glide.with(MainActivity.this)
                                    .load(dengLuBean.getZhuji() + zhaoPianBean.getData().getHead_url())
//                .skipMemoryCache(true)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    //  .transform(new GlideCircleTransform(RenGongFuWuActivity.this,1, Color.parseColor("#ffffffff")))
                                    .into(datouxiang);
                        }
                    });


                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_xiugaimima() {
        // showDialog();
        //   final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("cmd","100");
//            jsonObject.put("account",zhanghao);
//            jsonObject.put("password",jiami);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        RequestBody body = new FormBody.Builder()
                .add("UserName", dengLuBean.getUsername())
                .add("OldPassword", mima1.getText().toString().trim())
                .add("NewPassword", mima2.getText().toString().trim())
                .add("ConfirmPassword", mima3.getText().toString().trim())
                .build();
        Request.Builder requestBuilder = null;
        requestBuilder = new Request.Builder()
                .post(body)
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                //.get()
                .url(dengLuBean.getZhuji() + "/api/memberships/resetpassword");

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", "修改密码" + ss);

                    final JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    if (jsonObject.get("error_code").getAsInt() == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                xiugaimima.setText("修改成功");
                                mima1.setText("");
                                mima2.setText("");
                                mima3.setText("");
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                xiugaimima.setText(jsonObject.get("error_msg").getAsString());

                            }
                        });
                    }


                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage()+"");
                }
            }
        });

    }







}
