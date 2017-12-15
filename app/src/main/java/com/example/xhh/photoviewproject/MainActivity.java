package com.example.xhh.photoviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * author 栾桂明
 * time 2017 12 15
 * 一个关于photoview的控件的学习
 */

public class MainActivity extends AppCompatActivity implements OnClickListener {
    //    command + d 复制当前行
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button01);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button02);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button03);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button04);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button05);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button01:
                Intent intent1 = new Intent(MainActivity.this, ImgActivity.class);
                startActivity(intent1);
                break;
            case R.id.button02:
                Intent intent2 = new Intent(MainActivity.this, ImgClickActivity.class);
                startActivity(intent2);
                break;
            case R.id.button03:
                Intent intent3 = new Intent(MainActivity.this, PhotoBrowActivity.class);
                startActivity(intent3);
                break;
            case R.id.button04:
                Intent intent4 = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent4);
                break;
            case R.id.button05:
                Intent intent5 = new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent5);
                break;


        }
    }
}
