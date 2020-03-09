package com.bw.jiguoshuai20200309.prenster;

import com.bw.jiguoshuai20200309.base.BasePrenster;
import com.bw.jiguoshuai20200309.base.IBseView;
import com.bw.jiguoshuai20200309.counstract.IHomeContract;
import com.bw.jiguoshuai20200309.moudle.IHomeMoudle;

import java.util.HashMap;
/**
 * 季国帅
 * 20200309
 */
public class IHomePrenster extends BasePrenster implements IHomeContract.IPrenster {
    private IHomeMoudle moudle;
    public IHomePrenster(IBseView iBseView) {
        super(iBseView);
    }

    @Override
    public void initMoudle() {
        moudle = new IHomeMoudle();

    }

    @Override
    public void getBanner(String url, HashMap<String, String> map) {
        moudle.getBanner(url, map, new IHomeContract.IMoudle.IBack() {
            @Override
            public void onSucccess(String url) {
                IBseView view = getView();
                if (view instanceof IHomeContract.IView){
                    IHomeContract.IView view1= (IHomeContract.IView) view;
                    view1.onSucccess(url);
                }
            }

            @Override
            public void onError(String url) {
                IBseView view = getView();
                if (view instanceof IHomeContract.IView){
                    IHomeContract.IView view1= (IHomeContract.IView) view;
                    view1.onError(url);
                }
            }
        });

    }
}
