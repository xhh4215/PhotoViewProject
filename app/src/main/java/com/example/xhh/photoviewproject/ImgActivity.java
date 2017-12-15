package com.example.xhh.photoviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bm.library.PhotoView;

public class ImgActivity extends AppCompatActivity {
    String url = "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/" +
            "sign=30f49b810ff79052ef4a147e6acee3f8/5bafa40f4bfbfbedbb34deed7ef0f736afc31f36.jpg";
    String gif = "http://imgsrc.baidu.com/baike/pic/item/7af40ad162d9f2d339d2a789abec8a136227cc91.jpg";
    private PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        photoView = (PhotoView) findViewById(R.id.img1);
        photoView.enable();
        photoView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(ImgActivity.this, "长按了", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
