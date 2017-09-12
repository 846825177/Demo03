package com.chenzeyang.demo03;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * ----------------Dragon be here!------------------
 * 　   　　┏┓　　　┏┓
 * 　   　┏┛┻━━━┛┻┓
 * 　   　┃　　　　　　　┃
 * 　   　┃　　　━　　　┃
 * 　   　┃　┳┛　┗┳　┃
 * 　   　┃　　　　　　　┃
 * 　   　┃　　　┻　　　┃
 * 　   　┃　　　　　　　┃
 * 　   　┗━┓　　　┏━┛
 * 　   　　　┃　　　┃神兽保佑
 * 　   　　　┃　　　┃代码无BUG！
 * 　   　　　┃　　　┗━━━┓
 * 　   　　　┃　神兽出品　　┣┓
 * 　   　　　┃　必属精品　　┏┛
 * 　   　　　┗┓┓┏━┳┓┏┛
 * 　   　　　　┃┫┫　┃┫┫
 * 　   　　　　┗┻┛　┗┻┛
 * ━━━━━━━━神兽出没━━━━━━━━
 * <p>
 * Created by Mr Chen on 2017/9/12 0012 下午 4:12.
 */

public class VolleyUtils {
    private static VolleyUtils volleyUtils;
    private RequestQueue queue;

        private VolleyUtils(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static synchronized VolleyUtils getInstance(Context context) {
        if (volleyUtils == null)
            volleyUtils = new VolleyUtils(context);
        return volleyUtils;
    }

    public void sendGet(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest stringRequest = new StringRequest(url, listener, errorListener);
        queue.add(stringRequest);
    }

    public void sendGet(String url, final Map<String, String> map, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        queue.add(stringRequest);
    }
}
