package com.easylife.mobile;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.easylife.R;
import com.easylife.base.BaseActivity;
import com.easylife.custom.TopBar;

public class MobileActivity extends BaseActivity {
    private TopBar topBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);
        topBar = (TopBar) findViewById(R.id.topbar);
        topBar.setCenterText("手机充值");

        textView = (TextView) findViewById(R.id.mobile_txt);
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}
