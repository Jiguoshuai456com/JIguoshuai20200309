package com.bw.jiguoshuai20200309.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.jiguoshuai20200309.R;
import com.bw.jiguoshuai20200309.view.CustomLayout;
/**
 * 季国帅
 * 20200309
 */
public class Main2Activity extends AppCompatActivity {

    private ImageView iv;
    private TextView t1;
    private CustomLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        ⑤　在图2显示用户昵称，使用Glide把头像做成圆形并配置Glide的占位图，错误图
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String name = intent.getStringExtra("name");
        cl = findViewById(R.id.cl);
        iv = findViewById(R.id.iv);
        t1 = findViewById(R.id.t1);
        t1.setText(name);
        Glide.with(this).load(pic).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(iv);
        int[] data={90,50,98,48,92,66};
        cl.getData(data);

    }
}
