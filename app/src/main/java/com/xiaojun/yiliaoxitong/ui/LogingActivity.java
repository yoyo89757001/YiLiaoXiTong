package com.xiaojun.yiliaoxitong.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaojun.yiliaoxitong.MyApplication;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.adapters.TiJIaoDialog;
import com.xiaojun.yiliaoxitong.beans.DengLuBean;
import com.xiaojun.yiliaoxitong.beans.DengLuBeanDao;
import com.xiaojun.yiliaoxitong.beans.TokensBean;
import com.xiaojun.yiliaoxitong.utils.GsonUtil;
import com.xiaojun.yiliaoxitong.utils.Utils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LogingActivity extends Activity {
    private int dw,dh;
    private WindowManager wm;
    private LayoutInflater mInflater = null;
    private View view = null;
    private DengLuBeanDao dengLuBeanDao=null;
    private DengLuBean dengLuBean=null;
    private TiJIaoDialog tiJIaoDialog=null;
    private RelativeLayout tanchuang;
    private Button denglu;
    private EditText zhanghao,mima,zhuzhiyisheng;


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
        view = mInflater.inflate(R.layout.activity_loging, null);
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

        tanchuang= (RelativeLayout) view.findViewById(R.id.tanchuang);
         denglu= (Button) view.findViewById(R.id.denglu);
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Log.d("LogingActivity", "dddd");
            //    startActivity(new Intent(LogingActivity.this,MainActivity.class));
            //    wm.removeView(view);
            //    finish();
                denglu.setEnabled(false);
                link_save();
            }
        });

        wm.addView(view, wmParams);

    }



    private void link_save() {
       // showDialog();
        final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient= MyApplication.getOkHttpClient();
        tanchuang.setVisibility(View.VISIBLE);
        denglu.setText("登录中...");
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
                .add("grant_type","password")
                .add("username",zhanghao.getText().toString().trim())
                .add("password",mima.getText().toString().trim())
                .build();

         Request.Builder requestBuilder = new Request.Builder()
                 .post(body)
                .url(dengLuBean.getZhuji() + "/pad/token");

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
                        tanchuang.setVisibility(View.GONE);
                        denglu.setText("网络错误");
                        denglu.setEnabled(true);
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
                    TokensBean zhaoPianBean = gson.fromJson(jsonObject, TokensBean.class);
                    dengLuBean.setToken(zhaoPianBean.getAccess_token());
                    dengLuBean.setUsername(zhanghao.getText().toString().trim());
                    dengLuBean.setPassword(mima.getText().toString().trim());
                    dengLuBean.setZhuzhiyisheng(zhuzhiyisheng.getText().toString().trim());
                    dengLuBeanDao.update(dengLuBean);
                    finish();
                    startActivity(new Intent(LogingActivity.this,MainActivity.class));
                }catch (Exception e){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tanchuang.setVisibility(View.GONE);
                            denglu.setText("数据错误");
                            denglu.setEnabled(true);
                        }
                    });
                  //  dismissDialog();
                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }



}
