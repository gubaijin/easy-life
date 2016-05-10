package com.kevin.guide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.kevin.R;
import com.kevin.base.BaseActivity;

/**
 * 引导页
 */
public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = (ViewPager) findViewById(R.id.vpg_guide);
        viewPager.setAdapter(new GuideFragmentAdapter(getSupportFragmentManager()));
    }
}
