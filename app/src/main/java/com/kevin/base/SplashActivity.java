package com.kevin.base;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.kevin.R;
import com.kevin.guide.GuideActivity;
import com.kevin.home.HomeActivity;
import com.kevin.utils.SharePrefUtil;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    private TextView textView;
    // 用于判断是否首次登陆, 默认首次登陆
    private static final int DURATION = 1500;
    private boolean isFirstIn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isFirstIn = SharePrefUtil.getBoolean(SplashActivity.this, getString(R.string.is_first_in), true);
        init();
    }

    /**
     * 可以做一些初始化操作
     */
    private void init() {
        if (isFirstIn) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    openActivity(GuideActivity.class);
                }
            }, DURATION);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    openActivity(HomeActivity.class);
                }
            }, DURATION);
        }
        finish();
    }
}
