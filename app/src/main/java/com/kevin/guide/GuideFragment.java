package com.kevin.guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.kevin.R;
import com.kevin.base.BaseActivity;
import com.kevin.home.HomeActivity;
import com.kevin.utils.SharePrefUtil;

/**
 * 引导页fragment
 * @author Kevin
 *
 */
public class GuideFragment extends Fragment{
	private int resid = 0;
	private boolean isEnd = false;
	static GuideFragment fragment;
	
    public static GuideFragment newInstance(int resid, boolean isEnd) {
    	fragment = new GuideFragment();
    	fragment.resid = resid;
    	fragment.isEnd = isEnd;
        return fragment;
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(isEnd){
			View view = inflater.inflate(resid, container, false);
			ImageView iv = (ImageView) view.findViewById(R.id.img_guide_liji);
			iv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					((BaseActivity)getContext()).openActivity(HomeActivity.class);
					//将SHP中是否首次登陆改为false
					SharePrefUtil.saveBoolean(getActivity(), getString(R.string.is_first_in), false);
					getActivity().finish();
				}
			});
			return view;
		}else{
			ImageView iv = new ImageView(getActivity());
			iv.setBackgroundResource(resid);
			iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

	        LinearLayout layout = new LinearLayout(getActivity());
	        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	        layout.setGravity(Gravity.CENTER);
	        layout.addView(iv);
	        return layout;
		}
	}
}
