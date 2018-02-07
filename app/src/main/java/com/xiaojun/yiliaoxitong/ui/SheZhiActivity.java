package com.xiaojun.yiliaoxitong.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaojun.yiliaoxitong.MyApplication;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.beans.DengLuBean;
import com.xiaojun.yiliaoxitong.beans.DengLuBeanDao;
import com.xiaojun.yiliaoxitong.beans.IpFanHuiBean;
import com.xiaojun.yiliaoxitong.beans.TokensBean;
import com.xiaojun.yiliaoxitong.utils.GsonUtil;
import com.xiaojun.yiliaoxitong.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SheZhiActivity extends Activity implements View.OnClickListener {
    private int dw,dh;
    private WindowManager wm;
    private LayoutInflater mInflater = null;
    private View view = null;
    private DengLuBeanDao dengLuBeanDao=null;
    private DengLuBean dengLuBean=null;
    private Button xiugaiip;
    private EditText mima11,mima22, mima33;
    private EditText zhanghao,mima,zhuzhiyisheng;
    private RelativeLayout fanhui;


    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dengLuBeanDao=MyApplication.getAppContext().getDaoSession().getDengLuBeanDao();
        dengLuBean=dengLuBeanDao.load(123456L);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        dw=dm.widthPixels;
        dh=dm.heightPixels;
        //设置横屏
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        wm=(WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        mInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert mInflater != null;
        view = mInflater.inflate(R.layout.activity_shezhi, null);
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.OPAQUE;
        wmParams.screenOrientation=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        wmParams.flags=WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;;
        wmParams.width=dw;
        wmParams.height=dh;
        zhanghao= (EditText) view.findViewById(R.id.zhanghao);
        mima= (EditText) view.findViewById(R.id.mima);
        zhuzhiyisheng= (EditText) view.findViewById(R.id.zhuzhiyisheng);
        fanhui= (RelativeLayout) view.findViewById(R.id.fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.removeView(view);
              SheZhiActivity.this.finish();
            }
        });
        xiugaiip = (Button) view.findViewById(R.id.xiugaimima2);
        xiugaiip.setEnabled(false);
        xiugaiip.setOnClickListener(this);
        mima11 = (EditText) view.findViewById(R.id.mima11);
        mima11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("123456789")){
                    mima22.setEnabled(true);
                    mima33.setEnabled(true);
                    xiugaiip.setEnabled(true);
                    mima22.setBackgroundResource(R.drawable.zhongkong);
                    mima33.setBackgroundResource(R.drawable.zhongkong);
                    mima22.setText(dengLuBean.getZhongduanmingcheng());
                    mima33.setText(dengLuBean.getZhuji());
                }else {
                    mima22.setEnabled(false);
                    mima33.setEnabled(false);
                    xiugaiip.setEnabled(false);
                    mima22.setBackgroundResource(R.drawable.zhongkong_hui);
                    mima33.setBackgroundResource(R.drawable.zhongkong_hui);
                    mima22.setText("");
                    mima33.setText("");
                }

            }
        });
        mima22 = (EditText) view.findViewById(R.id.mima22);
        mima22.setEnabled(false);
        mima33 = (EditText) view.findViewById(R.id.mima33);
        mima33.setEnabled(false);

        wm.addView(view, wmParams);

    }




    private void link_xinzengSB(int id) {
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();
        //  Log.d("MainActivity", Utils.getUniqueId(MainActivity.this));
//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";
        JSONObject jsonObject = new JSONObject();
        if (id != -1) {
            try {
                jsonObject.put("id", id);
                jsonObject.put("serial_number", Utils.getUniqueId(SheZhiActivity.this));
                jsonObject.put("terminal_name", mima22.getText().toString().trim());
                jsonObject.put("ip_address", "");
                jsonObject.put("server_ip_address", mima33.getText().toString().trim());
                jsonObject.put("status", 3);
                // jsonObject.put("create_date",DateUtils.tim33(System.currentTimeMillis()+""));
                //  Log.d("MainActivity", mima33.getText().toString().trim());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            // Log.d("MainActivity", getIMEI(MainActivity.this)+"");
            try {
                jsonObject.put("serial_number", Utils.getUniqueId(SheZhiActivity.this));
                jsonObject.put("terminal_name", mima22.getText().toString().trim());
                jsonObject.put("ip_address", "");
                jsonObject.put("server_ip_address", mima33.getText().toString().trim());
                jsonObject.put("status", 3);
                //  jsonObject.put("create_date",DateUtils.tim33(System.currentTimeMillis()+""));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                .post(body)
                // .get()
                .url(dengLuBean.getZhuji() + "/api/terminals");

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
                        xiugaiip.setText("网络出错");
                        dengLuBean.setZhongduanmingcheng(mima22.getText().toString().trim());
                        dengLuBean.setZhuji(mima33.getText().toString().trim());
                        dengLuBeanDao.update(dengLuBean);
                        dengLuBean=dengLuBeanDao.load(123456L);
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

                                xiugaiip.setText("保存成功");
                                dengLuBean.setZhongduanmingcheng(mima22.getText().toString().trim());
                                dengLuBean.setZhuji(mima33.getText().toString().trim());
                                dengLuBeanDao.update(dengLuBean);
                                dengLuBean=dengLuBeanDao.load(123456L);

                            }
                        });
                    }

                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            xiugaiip.setText("修改出错");
                            dengLuBean.setZhongduanmingcheng(mima22.getText().toString().trim());
                            dengLuBean.setZhuji(mima33.getText().toString().trim());
                            dengLuBeanDao.update(dengLuBean);
                            dengLuBean=dengLuBeanDao.load(123456L);
                        }
                    });
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        if (!mima22.getText().toString().trim().equals("") && !mima33.getText().toString().trim().equals("")) {

            link_chaxunSB(Utils.getUniqueId(SheZhiActivity.this));
            // link_xinzengSB();
        }else {
            xiugaiip.setText("信息不全");
        }
    }

    private void link_chaxunSB(String id) {
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();

//    /* form的分割线,自己定义 */
//        String boundary = "xx--------------------------------------------------------------xx";


        //    RequestBody body = RequestBody.create(JSON, jsonObject.toString());

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                //  .post(body)
                .get()
                .url(dengLuBean.getZhuji() + "/api/terminals/" + id);

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
                        xiugaiip.setText("网络出错");
                        dengLuBean.setZhongduanmingcheng(mima22.getText().toString().trim());
                        dengLuBean.setZhuji(mima33.getText().toString().trim());
                        dengLuBeanDao.update(dengLuBean);
                        dengLuBean=dengLuBeanDao.load(123456L);
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
                    final IpFanHuiBean zhaoPianBean = gson.fromJson(jsonObject, IpFanHuiBean.class);
                    if (zhaoPianBean.getError_code()==0){

                        link_xinzengSB(zhaoPianBean.getData().getId());

                    }else {
                        link_xinzengSB(-1);
                    }



                } catch (Exception e) {
                    link_xinzengSB(-1);

                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

}
