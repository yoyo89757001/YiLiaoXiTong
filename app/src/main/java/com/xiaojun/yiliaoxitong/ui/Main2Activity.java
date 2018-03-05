package com.xiaojun.yiliaoxitong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.xiaojun.yiliaoxitong.R;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mainActivityIntent = new Intent(Main2Activity.this, LogingActivity.class);  // 要启动的Activity
        mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(mainActivityIntent);

        finish();

    }
}
