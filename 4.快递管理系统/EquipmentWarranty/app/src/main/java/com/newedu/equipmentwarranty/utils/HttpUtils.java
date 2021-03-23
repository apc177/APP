package com.newedu.equipmentwarranty.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class HttpUtils {
    private static OkHttpClient okHttpClient = null;
    public static OkHttpClient getClient(){
            if(okHttpClient == null) {
                okHttpClient = new OkHttpClient.Builder()
                        .cookieJar(new CookieJar() {
                            private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

                            @Override
                            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                                Log.i("url", url.host());
                                cookieStore.put(url.host(), cookies);
                                int i = 0;
                            }

                            @Override
                            public List<Cookie> loadForRequest(HttpUrl url) {
                                List<Cookie> cookies = cookieStore.get(url.host());
                                return cookies != null ? cookies : new ArrayList<Cookie>();
                            }
                        }).build();

            }

        return okHttpClient;
    }
}
