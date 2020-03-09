package com.bw.jiguoshuai20200309.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.jiguoshuai20200309.R;
import com.bw.jiguoshuai20200309.base.BaseActivity;
import com.bw.jiguoshuai20200309.base.BasePrenster;
import com.bw.jiguoshuai20200309.bean.Bean;
import com.bw.jiguoshuai20200309.prenster.IHomePrenster;
import com.bw.jiguoshuai20200309.utiuls.VolleyUtiuls;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * 季国帅
 * 20200309
 */
public class MainActivity extends BaseActivity {


    private EditText e1;
    private EditText e2;
    private Button b2;
    private HashMap<String, String> map;
    private IHomePrenster prenster1;
    private Button b1;
    private SharedPreferences name;
    private CheckBox c1;


    @Override
    protected BasePrenster initPrenster() {
        return new IHomePrenster(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b2 = findViewById(R.id.b2);
        b1 = findViewById(R.id.b1);
        c1 = findViewById(R.id.c1);
        name = this.getSharedPreferences("name", Context.MODE_PRIVATE);
        boolean b = name.getBoolean("b", false);
        if (b){
            String phone = name.getString("phone", "");
            String pwd = name.getString("pwd", "");
            e1.setText(phone);
            e2.setText(pwd);
            c1.setChecked(true);
        }

    }

    @Override
    protected void getData() {
        BasePrenster prenster = getPrenster();
        if (prenster !=null && prenster instanceof IHomePrenster){
            prenster1 = (IHomePrenster) prenster;
            map = new HashMap<>();
//③　完成登录功能。
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url="http://mobile.bwstudent.com/small/user/v1/login";
                    String phone = e1.getText().toString();
                    String pwd = e2.getText().toString();
                    map.put("phone",phone);
                    map.put("pwd",pwd);
                    prenster1.getBanner(url, map);
                    SharedPreferences.Editor edit = name.edit();
                    if (c1.isChecked()){
                        edit.putString("phone",phone);
                        edit.putString("pwd",pwd);
                        edit.putBoolean("b",true);
                        edit.commit();
                    }else {
                        edit.putBoolean("b",false);
                        edit.commit();
                    }
                }

            });
//②　完成注册功能。
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url="http://mobile.bwstudent.com/small/user/v1/register";
                    String phone = e1.getText().toString();
                    String pwd = e2.getText().toString();
                    map.put("phone",phone);
                    map.put("pwd",pwd);
                    prenster1.getBanner(url, map);
                }
            });
        }

    }

    @Override
    public void onSucccess(String url) {
        Boolean net = VolleyUtiuls.getInstance().isNet(this);
        if (net){
            Log.i("xxx",url);
            Gson gson = new Gson();
            Bean bean = gson.fromJson(url, Bean.class);
            Bean.ResultBean result = bean.getResult();
            String headPic = result.getHeadPic();
            String name = result.getNickName();
            String status = bean.getStatus();
            if (status.equals("0000")){
//                ④　登录成功后跳转到图2，把头像和用户昵称传递到图2。
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("pic",headPic);
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        }else {
            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onError(String url) {
        Log.i("xxx",url);
    }
}
