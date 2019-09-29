package com.example.mtablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mtablayout.tablayout.MTabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MTabLayout tbLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tbLayout = findViewById(R.id.tbLayout);
        tbLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return "titilePage上下=11" + position;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
            }


            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                TextView t = new TextView(container.getContext());
                t.setText("page === " + position);
                container.addView(t);
                return t;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

//                container.removeViewAt(position);
            }
        });
    }

}
