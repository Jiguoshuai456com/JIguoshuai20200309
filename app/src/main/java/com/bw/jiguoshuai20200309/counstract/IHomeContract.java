package com.bw.jiguoshuai20200309.counstract;

import com.bw.jiguoshuai20200309.base.IBseView;

import java.util.HashMap;
/**
 * 季国帅
 * 20200309
 */
public interface IHomeContract {
//    ②　使用契约统一管理MVP接口/
    interface IView extends IBseView{
        void onSucccess(String url);
        void onError(String url);
    }
    interface IPrenster{
        void getBanner(String url, HashMap<String,String> map);
    }
    interface IMoudle{
        void getBanner(String url, HashMap<String,String> map,IBack iBack);
        interface IBack{
            void onSucccess(String url);
            void onError(String url);
        }
    }

}
