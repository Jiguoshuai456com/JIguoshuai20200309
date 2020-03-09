package com.bw.jiguoshuai20200309.moudle;

import com.bw.jiguoshuai20200309.counstract.IHomeContract;
import com.bw.jiguoshuai20200309.utiuls.VolleyUtiuls;

import java.util.HashMap;
/**
 * 季国帅
 * 20200309
 */
public class IHomeMoudle implements IHomeContract.IMoudle {
    @Override
    public void getBanner(final String url, HashMap<String, String> map, final IBack iBack) {
        VolleyUtiuls.getInstance().doPost(url, map, new VolleyUtiuls.ICallBack() {
            @Override
            public void onSuccess(String url) {
                iBack.onSucccess(url);
            }

            @Override
            public void onError(String msg) {
                iBack.onError(url);
            }
        });
    }
}
