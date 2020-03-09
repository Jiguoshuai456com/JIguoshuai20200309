package com.bw.jiguoshuai20200309.utiuls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bw.jiguoshuai20200309.base.App;

import java.util.HashMap;
import java.util.Map;
/**
 * 季国帅
 * 20200309
 */
public class VolleyUtiuls {

//    ⑤　封装Volley的get和post。
    RequestQueue queue;


    private VolleyUtiuls() {
        this.queue = Volley.newRequestQueue(App.getApplicon());
        RequestQueue queue = this.queue;
    }
    private static class SingInstance{
        private static VolleyUtiuls INBER=new VolleyUtiuls();
    }
//    ⑥　封装网络状态判断方法，可以判断有网无网。
    public static VolleyUtiuls getInstance(){
        return SingInstance.INBER;
    }
    public Boolean isNet(Context context){
      ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;

    }
    public void doGet(String url, final ICallBack iCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.onError(error.toString());
            }
        });
        queue.add(stringRequest);

    }
    public void doPost(String url, final HashMap<String,String> map, final ICallBack iCallBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iCallBack.onSuccess(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iCallBack.onError(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return map;
            }
        };
        queue.add(stringRequest);
    }
    public interface ICallBack{
        void onSuccess(String url);
        void onError(String msg);
    }
}
