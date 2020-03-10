package com.example.cwmswipingviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cwmswipingviewpager.models.Hat;
import com.example.cwmswipingviewpager.resources.Hats;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // widgets
    private ViewPager mMyViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);mTabLayout = findViewById(R.id.tab_layout);
        mMyViewPager = findViewById(R.id.view_pager);

        init();
    }

    private void init(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        Hat[] hats = Hats.getHats();
        for(Hat hat: hats){
            ViewPagerItemFragment fragment = ViewPagerItemFragment.getInstance(hat);
            fragments.add(fragment);
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        mMyViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mMyViewPager, true);
    }
}
