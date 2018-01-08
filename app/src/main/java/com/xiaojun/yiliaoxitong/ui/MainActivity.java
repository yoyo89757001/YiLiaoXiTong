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
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaojun.yiliaoxitong.MyApplication;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.adapters.LiangBiaoAdapter;
import com.xiaojun.yiliaoxitong.adapters.PopupWindowAdapter;
import com.xiaojun.yiliaoxitong.adapters.YiShengAdapter;
import com.xiaojun.yiliaoxitong.beans.DengLuBean;
import com.xiaojun.yiliaoxitong.beans.DengLuBeanDao;
import com.xiaojun.yiliaoxitong.beans.GeRenXinXi;
import com.xiaojun.yiliaoxitong.beans.TokensBean;
import com.xiaojun.yiliaoxitong.utils.DateUtils;
import com.xiaojun.yiliaoxitong.utils.GsonUtil;
import com.xiaojun.yiliaoxitong.views.WrapContentLinearLayoutManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
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
    private WindowManager wm;
    private LayoutInflater mInflater = null;
    private View view = null;
    private TextView t1, t2, t3, t4, t5, t6;
    private ImageView im1, im2, im3, im4, im5, im6;
    private LinearLayout l1, l2, l3, l4, l5, l6,ll1,ll2,ll3;
    private EditText xingming,xingbie,mingzu,chushengriqi,zhiye,zhuceyouxiang,wenhuachengdu,paihang,hunyingzhuangkuang;
    private TextView haoma,xiongdijiemei,beishixuexing,beishiliexing,beishilaiyuan,fabingnianling,zongjiaoxingyang,fenchuangnianling,fuqingxueli,muqingxueli,yangyuzhe;
    private Button baocun;
    private PopupWindow popupWindow=null;
    private List<String> stringList=new ArrayList<>();
    private PopupWindowAdapter adapterss;
    private LRecyclerView lRecyclerView,lRecyclerView_ys;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter_ys;
    private List<String> dataList = new ArrayList<>();
    private List<String> dataList_ys = new ArrayList<>();
    private LiangBiaoAdapter taiZhangAdapter;
    private YiShengAdapter yiShengAdapter;
    private DengLuBeanDao dengLuBeanDao=null;
    private DengLuBean dengLuBean=null;
    private long id=-2;
    private String case_number=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dengLuBeanDao=MyApplication.getAppContext().getDaoSession().getDengLuBeanDao();
        dengLuBean=dengLuBeanDao.load(123456L);

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
        ll3= (LinearLayout) view.findViewById(R.id.ll3);
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
        baocun= (Button) view.findViewById(R.id.baocun2);
        baocun.setOnClickListener(this);
        haoma= (TextView) view.findViewById(R.id.haoma);
        haoma.setText(dengLuBean.getUsername());

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


        lRecyclerView = (LRecyclerView) view.findViewById(R.id.recyclerview);
        lRecyclerView_ys = (LRecyclerView) view.findViewById(R.id.recyclerview_ys);

        taiZhangAdapter = new LiangBiaoAdapter(dataList,MainActivity.this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(taiZhangAdapter);
        lRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));
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
        //医生的
        yiShengAdapter = new YiShengAdapter(dataList_ys,MainActivity.this);
        lRecyclerViewAdapter_ys = new LRecyclerViewAdapter(yiShengAdapter);
        lRecyclerView_ys.setLayoutManager(new WrapContentLinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));
        lRecyclerView_ys.setAdapter(lRecyclerViewAdapter_ys);
        //设置头部加载颜色
        lRecyclerView_ys.setHeaderViewColor(R.color.colorAccent, R.color.blake ,android.R.color.white);
        lRecyclerView_ys.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        lRecyclerView_ys.setFooterViewColor(R.color.textcolor, R.color.blake ,android.R.color.white);
        //设置底部加载文字提示
        lRecyclerView_ys.setFooterViewHint("拼命加载中","--------我是有底线的--------","网络不给力...");
        lRecyclerView_ys.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        lRecyclerView_ys.setPullRefreshEnabled(false);
        lRecyclerViewAdapter_ys.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }
        });



        wm.addView(view, wmParams);

        link_info();
        link_ys_list(1,10,null);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.l1:
                chongzhi();
                l1.setBackgroundResource(R.color.write);
                im1.setBackgroundResource(R.drawable.lanjiantou);
                t1.setTextColor(Color.parseColor("#008AFF"));
                baocun.setText("保 存");
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
                setViewGoen();
                ll3.setVisibility(View.VISIBLE);
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
            case R.id.baocun2:

                link_xiugai_info();

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
        ll3.setVisibility(View.GONE);
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


    private void link_info() {
        // showDialog();
        final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient= MyApplication.getOkHttpClient();

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
                .addHeader("Authorization","Bearer "+dengLuBean.getToken())
                .get()
                .url(dengLuBean.getZhuji() + "/api/memberships/info");

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败"+e.getMessage());
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
                            xingming.setText(zhaoPianBean.getData().getReal_name());
                            xingbie.setText(zhaoPianBean.getData().getGender());
                            mingzu.setText(zhaoPianBean.getData().getNation());
                            chushengriqi.setText(zhaoPianBean.getData().getBirthday().substring(0,10));
                            zhiye.setText(zhaoPianBean.getData().getVocation());
                            zhuceyouxiang.setText(zhaoPianBean.getData().getEmail());
                            wenhuachengdu.setText(zhaoPianBean.getData().getEducation());
                            xiongdijiemei.setText(zhaoPianBean.getData().getSiblings()+"");
                            paihang.setText(zhaoPianBean.getData().getRaking()+"");
                            hunyingzhuangkuang.setText(zhaoPianBean.getData().getMarital_status());
                            beishixuexing.setText(zhaoPianBean.getData().getBlood_type());
                            beishiliexing.setText(zhaoPianBean.getData().getType());
                            beishilaiyuan.setText(zhaoPianBean.getData().getSource());
                            fabingnianling.setText(zhaoPianBean.getData().getAge_of_onset()+"");
                            zongjiaoxingyang.setText(zhaoPianBean.getData().getReligion());
                            fenchuangnianling.setText(zhaoPianBean.getData().getSeparate_beds_age()+"");
                            fuqingxueli.setText(zhaoPianBean.getData().getFather_education());
                            muqingxueli.setText(zhaoPianBean.getData().getMonther_education());
                            yangyuzhe.setText(zhaoPianBean.getData().getPrimary_rear_education());
                            id=zhaoPianBean.getData().getId();
                            case_number=zhaoPianBean.getData().getCase_number();


                        }
                    });


                }catch (Exception e){
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
        final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient= MyApplication.getOkHttpClient();
        baocun.setText("保存中...");

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id",id);
            jsonObject.put("case_number",case_number);
            jsonObject.put("real_name",xingming.getText().toString().trim());
            jsonObject.put("gender",xingbie.getText().toString().trim());
            jsonObject.put("nation",mingzu.getText().toString().trim());
            jsonObject.put("birthday",chushengriqi.getText().toString().trim());
            jsonObject.put("vocation",zhiye.getText().toString().trim());
            jsonObject.put("phone_number",dengLuBean.getUsername());
            jsonObject.put("education",wenhuachengdu.getText().toString().trim());
            jsonObject.put("password",dengLuBean.getPassword());
            jsonObject.put("siblings",xiongdijiemei.getText().toString().trim());
            jsonObject.put("raking",paihang.getText().toString().trim());
            jsonObject.put("marital_status",hunyingzhuangkuang.getText().toString().trim());
            jsonObject.put("age_of_onset",fabingnianling.getText().toString().trim());
            jsonObject.put("email",zhuceyouxiang.getText().toString().trim());
            jsonObject.put("doctor",dengLuBean.getZhuzhiyisheng());
           // jsonObject.put("diagnosed","");
            jsonObject.put("blood_type",beishixuexing.getText().toString().trim());
            jsonObject.put("type",beishiliexing.getText().toString().trim());
            jsonObject.put("source",beishilaiyuan.getText().toString().trim());
           // jsonObject.put("province",beishiliexing.getText().toString().trim());
            jsonObject.put("religion",zongjiaoxingyang.getText().toString().trim());
            jsonObject.put("separate_beds_age",fenchuangnianling.getText().toString().trim());
            jsonObject.put("father_education",fuqingxueli.getText().toString().trim());
            jsonObject.put("monther_education",muqingxueli.getText().toString().trim());
            jsonObject.put("primary_rear_education",yangyuzhe.getText().toString().trim());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Authorization","Bearer "+dengLuBean.getToken())
                .post(body)
               // .get()
                .url(dengLuBean.getZhuji() + "/api/memberships");

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败"+e.getMessage());
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
               if (jsonObject.get("error_code").getAsInt()==0){
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           baocun.setText("修改成功");

                       }
                   });
               }

                }catch (Exception e){
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

    private void link_ys_list(int pageIndex,int pageSize,String userName) {
        // showDialog();
        final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient= MyApplication.getOkHttpClient();

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
        Request.Builder requestBuilder=null;
        if (userName!=null) {
             requestBuilder = new Request.Builder()
                    // .post(body)
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/doctors?" + "PageIndex=" + pageIndex + "&" + "pageSize=" + pageSize + "&" + "UserName=" + userName);
        }else {
             requestBuilder = new Request.Builder()
                    // .post(body)
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/doctors?" + "PageIndex=" + pageIndex + "&" + "pageSize=" + pageSize );
        }
        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败"+e.getMessage());
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


                        }
                    });


                }catch (Exception e){
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

}
