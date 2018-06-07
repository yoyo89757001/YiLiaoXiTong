package com.xiaojun.yiliaoxitong.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xiaojun.yiliaoxitong.MyApplication;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.adapters.TiJIaoDialog;
import com.xiaojun.yiliaoxitong.beans.DengLuBean;
import com.xiaojun.yiliaoxitong.beans.DengLuBeanDao;
import com.xiaojun.yiliaoxitong.beans.MiMaBean;
import com.xiaojun.yiliaoxitong.beans.SheBeiBean;
import com.xiaojun.yiliaoxitong.beans.TokensBean;
import com.xiaojun.yiliaoxitong.utils.GsonUtil;
import com.xiaojun.yiliaoxitong.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;


import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
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
    private ImageView shezhi,tuichu;
    private PopupWindow popupWindow = null;
    private View view2;
    private final Timer timer = new Timer();
    private TimerTask task;



    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 要做的事情
            link_gengxinSB(Utils.getUniqueId(LogingActivity.this));
            link_zhuangtai();


          //  Log.d("LogingActivity", decode("abc123!@", "STB9dTF3+v58PC36NRrrBmaLc054WiqZ".getBytes())+"ggg");
            super.handleMessage(msg);
        }
    };


    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dengLuBeanDao=MyApplication.getAppContext().getDaoSession().getDengLuBeanDao();
        dengLuBean=dengLuBeanDao.load(123456L);

        //link_xinzengSB();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        dw=dm.widthPixels;
        dh=dm.heightPixels;
        //设置横屏
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        }
        wm=(WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        mInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert mInflater != null;
        view = mInflater.inflate(R.layout.activity_loging, null);
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.OPAQUE;
        wmParams.screenOrientation=ActivityInfo.SCREEN_ORIENTATION_USER;
        wmParams.flags=WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;;
        wmParams.width=dw;
        wmParams.height=dh;
        zhanghao= (EditText) view.findViewById(R.id.zhanghao);
        mima= (EditText) view.findViewById(R.id.mima);
        shezhi= (ImageView) view.findViewById(R.id.shezhi);
        zhuzhiyisheng= (EditText) view.findViewById(R.id.zhuzhiyisheng);
        view2=view.findViewById(R.id.vvv);
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
                link_save(null,null);
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogingActivity.this,SheZhiActivity.class));
            }
        });
        tuichu= (ImageView) view.findViewById(R.id.tuichu2);
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View contentView = LayoutInflater.from(LogingActivity.this).inflate(R.layout.tuichu_item, null);
                final EditText editText= (EditText) contentView.findViewById(R.id.ggg);
                final TextView textView= (TextView) contentView.findViewById(R.id.mm);
                Button b1= (Button)contentView. findViewById(R.id.quxiao);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                Button b2= (Button) contentView.findViewById(R.id.queding);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editText.getText().toString().trim().equals("123456789")){
                            popupWindow.dismiss();

                            wm.removeViewImmediate(view);
                            finish();

                        }else {
                            textView.setVisibility(View.VISIBLE );
                        }

                    }
                });


                popupWindow = new PopupWindow(contentView, 250, 260);
                popupWindow.setFocusable(true);//获取焦点
                popupWindow.setOutsideTouchable(true);//获取外部触摸事件
                popupWindow.setTouchable(true);//能够响应触摸事件
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));//设置背景
                popupWindow.showAsDropDown(view2, -125, -130);

            }
        });

        wm.addView(view, wmParams);



        task = new TimerTask() {
            @Override
            public void run() {

                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };

        timer.schedule(task, 1000, 5000);

    }




    private void link_save(final String username, final String password) {
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
        RequestBody body=null;
        if (username!=null && password!=null){
             body = new FormBody.Builder()
                    .add("grant_type","password")
                    .add("username",username)
                    .add("password",password)
                    .add("client_id",Utils.getUniqueId(LogingActivity.this))
                    .build();
        }else {
             body = new FormBody.Builder()
                    .add("grant_type","password")
                    .add("username",zhanghao.getText().toString().trim())
                    .add("password",mima.getText().toString().trim())
                    .add("client_id",Utils.getUniqueId(LogingActivity.this))
                    .build();
        }
        Request.Builder requestBuilder=null;
        try {
             requestBuilder = new Request.Builder()
                    .post(body)
                    .url(dengLuBean.getZhuji() + "/pad/token");
        }catch (Exception e){
            Log.d("LogingActivity", e.getMessage()+"");
            return;
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
                    Log.d("DengJiActivity", ss+"登录");

                    final JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    TokensBean zhaoPianBean = gson.fromJson(jsonObject, TokensBean.class);
                    dengLuBean.setToken(zhaoPianBean.getAccess_token());
                    dengLuBean.setUsername(username!=null?username:zhanghao.getText().toString().trim());
                    dengLuBean.setPassword(password!=null?password:mima.getText().toString().trim());
                    dengLuBean.setZhuzhiyisheng(zhuzhiyisheng.getText().toString().trim());
                    dengLuBeanDao.update(dengLuBean);
                    if ( zhaoPianBean.getAccess_token()!=null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                wm.removeViewImmediate(view);
                                finish();
                                startActivity(new Intent(LogingActivity.this,MainActivity.class));
                            }
                        });

                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tanchuang.setVisibility(View.GONE);
                                denglu.setText(jsonObject.get("error_description").getAsString());
                                denglu.setEnabled(true);
                            }
                        });
                    }

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
                    Log.d("DengJiActivity", e.getMessage());
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        task.cancel();
        timer.cancel();
        super.onDestroy();
    }

    private void link_gengxinSB(String serialnumber) {
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();
        //  Log.d("MainActivity", Utils.getUniqueId(MainActivity.this));
//    /* form的分割线,自己定义 */
      //  Log.d("LogingActivity", serialnumber);
        Request.Builder requestBuilder=null;
        try {
                 requestBuilder = new Request.Builder()
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    // .post(body)
                    .get()
                    .url(dengLuBean.getZhuji() + "/api/notify/"+serialnumber);
        }catch (Exception e){
            Log.d("LogingActivity", e.getMessage()+"k");
            return;

        }

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss+"状态");
                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Log.d("DengJiActivity", "状态222");
                    Gson gson = new Gson();
                    SheBeiBean zhaoPianBean = gson.fromJson(jsonObject, SheBeiBean.class);
                    Log.d("DengJiActivity", "33333");
                    Log.d("LogingActivity", zhaoPianBean.toString());
                    if (zhaoPianBean.getError_code()==0){
                        if (zhaoPianBean.getData().getAction().equals("绑定"))
                        link_getmima(zhaoPianBean.getData().getUser_id());
                      }

                } catch (Exception e) {

                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }

    private void link_getmima(int id) {
        Log.d("LogingActivity", "面膜点点滴滴的的 ");
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();
        //  Log.d("MainActivity", Utils.getUniqueId(MainActivity.this));
//    /* form的分割线,自己定义 */

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                // .post(body)
                .get()
                .url(dengLuBean.getZhuji() + "/api/memberships/info/"+id);

        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("LogingActivity", ss+"密码");

                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
                    Gson gson = new Gson();
                    final MiMaBean zhaoPianBean = gson.fromJson(jsonObject, MiMaBean.class);
                    if (zhaoPianBean.getError_code()==0){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                link_save(zhaoPianBean.getData().getUsername(),zhaoPianBean.getData().getPassword());
                            }
                        });

                    }

                } catch (Exception e) {

                    Log.d("DengJiActivity", e.getMessage()+"密码");
                }
            }
        });

    }


    private void link_zhuangtai() {
        // showDialog();
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        final OkHttpClient okHttpClient = MyApplication.getOkHttpClient();
        //  Log.d("MainActivity", Utils.getUniqueId(MainActivity.this));
//    /* form的分割线,自己定义 */
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Status", 3);
            jsonObject.put("SerialNumber", Utils.getUniqueId(LogingActivity.this));
            // jsonObject.put("create_date",DateUtils.tim33(System.currentTimeMillis()+""));
            //  Log.d("MainActivity", mima33.getText().toString().trim());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        Request.Builder requestBuilder=null;
        try {
             requestBuilder = new Request.Builder()
                    .addHeader("Authorization", "Bearer " + dengLuBean.getToken())
                    .post(body)
                    // .get()
                    .url(dengLuBean.getZhuji() + "/api/terminals/updatestatus");
        }catch (Exception e){
            Log.d("LogingActivity", e.getMessage()+" ");
            return;
        }


        // step 3：创建 Call 对象
        Call call = okHttpClient.newCall(requestBuilder.build());
        //step 4: 开始异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("AllConnects", "请求识别失败" + e.getMessage());
                //dismissDialog();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //  dismissDialog();
                //   Log.d("AllConnects", "请求识别成功"+call.request().toString());
                //获得返回体
                try {
                    ResponseBody body = response.body();
                    String ss = body.string().trim();
                    Log.d("DengJiActivity", ss+"[][][]");

//                    JsonObject jsonObject = GsonUtil.parse(ss).getAsJsonObject();
//                    Gson gson = new Gson();
//                    MiMaBean zhaoPianBean = gson.fromJson(jsonObject, MiMaBean.class);
//                    if (zhaoPianBean.getError_code()==0){
//                        link_save(zhaoPianBean.getData().getUsername(),zhaoPianBean.getData().getPassword());
//
//                        timer.cancel();
//                    }

                } catch (Exception e) {

                    Log.d("WebsocketPushMsg", e.getMessage());
                }
            }
        });

    }



    private final static String HEX = "0123456789ABCDEF";
    private final static String TRANSFORMATION = "DES/CBC/PKCS5Padding";//DES是加密方式 CBC是工作模式 PKCS5Padding是填充模式
    private final static String IVPARAMETERSPEC = "01020304";////初始化向量参数，AES 为16bytes. DES 为8bytes.
    private final static String ALGORITHM = "DES";//DES是加密方式
    private static final String SHA1PRNG = "SHA1PRNG";//// SHA1PRNG 强随机种子算法, 要区别4.2以上版本的调用方法
    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     */
    public static String decode(String key, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            IvParameterSpec iv = new IvParameterSpec(IVPARAMETERSPEC.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, getRawKey(key), iv);
            byte[] original = cipher.doFinal(data);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            Log.d("LogingActivity", e.getMessage()+"v");
            return null;
        }
    }

    // 对密钥进行处理
    private static Key getRawKey(String key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }
}
