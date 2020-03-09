package com.bw.jiguoshuai20200309.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.jiguoshuai20200309.R;
import com.bw.jiguoshuai20200309.counstract.IHomeContract;
/**
 * 季国帅
 * 20200309
 */
public abstract class BaseActivity<P extends BasePrenster> extends AppCompatActivity implements IHomeContract.IView {

//    ④　抽取Activity基类，在Activity基类中封装初始化P层的方法
    P mPrenster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPrenster=initPrenster();
        initView();
        getData();
    }
    public P getPrenster(){
        return mPrenster;
    }
    protected abstract P initPrenster();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void getData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPrenster!=null){
            mPrenster.detachView();
            mPrenster=null;
        }
    }
}
