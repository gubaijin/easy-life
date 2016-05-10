package com.easylife.guide;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.easylife.base.BaseActivity;
import com.easylife.R;

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
