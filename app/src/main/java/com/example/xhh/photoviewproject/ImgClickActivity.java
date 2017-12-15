package com.example.xhh.photoviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bm.library.Info;
import com.bm.library.PhotoView;

public class ImgClickActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    Info mRectF;
    PhotoView mImg1;
    PhotoView mImg2;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_img_click);
        radioGroup = (RadioGroup) findViewById(R.id.group);
        radioGroup.setOnCheckedChangeListener(this);
        mImg1 = findViewById(R.id.img1);
        mImg2 = findViewById(R.id.img2);
//        禁止图片的缩放功能
        mImg1.disenable();
        mImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImg1.setVisibility(View.GONE);
                mImg2.setVisibility(View.VISIBLE);
//                获取photoview的图片信息
                mRectF = mImg1.getInfo();
//                mRectF = mImg1.getImageViewInfo(); 从imageView中获取图片的信息
// 从一张图片信息变化到现在的图片，用于图片点击后放大浏览，具体使用可以参照demo的使用
                mImg2.animaFrom(mRectF);
            }
        });
        // 需要启动缩放需要手动开启
        mImg2.enable();
        mImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 让img2从自身位置变换到原来img1图片的位置大小
                mImg2.animaTo(mRectF, new Runnable() {
                    @Override
                    public void run() {
                        mImg2.setVisibility(View.GONE);
                        mImg1.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mImg2.getVisibility() == View.VISIBLE) {
            mImg2.animaTo(mRectF, new Runnable() {
                @Override
                public void run() {
                    mImg2.setVisibility(View.GONE);
                    mImg1.setVisibility(View.VISIBLE);
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.center:
                mImg1.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case R.id.center_crop:
                mImg1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.center_inside:
                mImg1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case R.id.fit_center:
                mImg1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;

            // 建议用了fit_Xy,fit_end,fit_start就不要使用缩放或者animaFrom或animaTo
            case R.id.fit_end:
                mImg1.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case R.id.fit_start:
                mImg1.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case R.id.fit_xy:
                mImg1.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
        }
    }

}
