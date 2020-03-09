package com.bw.jiguoshuai20200309.base;

import java.lang.ref.WeakReference;
/**
 * 季国帅
 * 20200309
 */
public abstract class BasePrenster<V extends IBseView> {

    WeakReference<V> vWeakReference;

    public BasePrenster(V v) {
        vWeakReference = new WeakReference<>(v);
        initMoudle();
    }
    public abstract void initMoudle();
    public V getView(){
        if (vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }
//    ③　解决MVP内存泄漏。
    public void detachView(){
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
}
