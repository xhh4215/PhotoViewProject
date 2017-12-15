package com.example.xhh.photoviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bm.library.Info;
import com.bm.library.PhotoView;

public class PhotoBrowActivity extends AppCompatActivity {
    int[] imgs = new int[]{R.mipmap.aaa, R.mipmap.bbb, R.mipmap.ccc, R.mipmap.ddd, R.mipmap.ic_launcher, R.mipmap.image003};
    public GridView gv;
    View mParent;
    View mBg;
    PhotoView photoView;
    Info info;
    AlphaAnimation in = new AlphaAnimation(0, 1);
    AlphaAnimation out = new AlphaAnimation(1, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_photo_brow);
        in.setDuration(300);
        out.setDuration(300);
        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mBg.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mParent = findViewById(R.id.parent);
        mBg = findViewById(R.id.bg);
        photoView = (PhotoView) findViewById(R.id.img);
        photoView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return imgs.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                PhotoView p = new PhotoView(PhotoBrowActivity.this);
                p.setLayoutParams
                        (new AbsListView.LayoutParams(
                                (int) (getResources().getDisplayMetrics().density * 100),
                                (int) (getResources().getDisplayMetrics().density * 100)));
                p.setScaleType(ImageView.ScaleType.CENTER_CROP);
                p.setImageResource(imgs[position]);
                p.disenable();
                return p;
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PhotoView p = (PhotoView) view;
                info = p.getInfo();
                photoView.setImageResource(imgs[position]);
                mBg.startAnimation(in);
                mBg.setVisibility(View.VISIBLE);
                photoView.animaFrom(info);
            }
        });
        photoView.enable();
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBg.startAnimation(out);
                photoView.animaTo(info, new Runnable() {
                    @Override
                    public void run() {
                        mParent.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mParent.getVisibility() == View.VISIBLE) {
            mBg.startAnimation(out);
            photoView.animaTo(info, new Runnable() {
                @Override
                public void run() {
                    mParent.setVisibility(View.GONE);
                }
            });
        } else {
            super.onBackPressed();
        }

    }
}
