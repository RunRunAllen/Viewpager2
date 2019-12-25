package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private CompositePageTransformer mTransformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        MyAdapter mAdpter = new MyAdapter();
        mViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        mViewPager.setUserInputEnabled(true);

        mViewPager.beginFakeDrag();
        if (mViewPager.fakeDragBy(-10f)) {
            mViewPager.endFakeDrag();
        }
        mTransformer = new CompositePageTransformer();
        mTransformer.addTransformer(new MarginPageTransformer(50));
        mViewPager.setPageTransformer(mTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        mViewPager.setAdapter(mAdpter);
    }
}
