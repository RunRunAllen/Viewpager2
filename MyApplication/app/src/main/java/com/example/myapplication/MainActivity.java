package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private CompositePageTransformer mTransformer;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tab_layout);
        MyAdapter mAdpter = new MyAdapter();
        // mViewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        mViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
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


        mTabLayout.addTab(mTabLayout.newTab().setText("Tab0"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab3"));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText("===tab" + tab.getPosition());
                mViewPager.setBackgroundColor(getResources().getColor(R.color.color_001b));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                mTabLayout.setScrollPosition(position, 0, false);
            }
        });


//        //绑定
//        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText("hahaha"+position);
//                tab.setIcon(R.mipmap.ic_launcher);
//            }
//        });
//        tabLayoutMediator.attach();

    }

}
