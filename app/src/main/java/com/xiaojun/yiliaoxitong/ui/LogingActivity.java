package com.xiaojun.yiliaoxitong.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.xiaojun.yiliaoxitong.R;

public class LogingActivity extends Activity {
    private int dw,dh;
    private WindowManager wm;
    private LayoutInflater mInflater = null;
    private View view = null;



    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        wmParams.flags=WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;;
        wmParams.width=dw;
        wmParams.height=dh;

      //  TextView ee= (TextView) view.findViewById(R.id.ddddd);



        wm.addView(view, wmParams);

    }
}
