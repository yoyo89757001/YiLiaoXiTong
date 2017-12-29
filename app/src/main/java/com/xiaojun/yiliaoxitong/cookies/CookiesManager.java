package com.xiaojun.yiliaoxitong.cookies;

/**
 * Created by chenjun on 2017/3/31.
 */



import com.xiaojun.yiliaoxitong.MyApplication;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 自动管理Cookies
 */
public class CookiesManager implements CookieJar {
    private  PersistentCookieStore cookieStore=null;
    public CookiesManager() {
         cookieStore = new PersistentCookieStore(MyApplication.getAppContext());
    }



    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
              //  Log.d("CookiesManager", item.value() +"  "+ item.domain());
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
//        Log.d("CookiesManager", "cookieStore.get(url):" + cookieStore.get(url).get(0).value());

        return cookieStore.get(url);
    }
}