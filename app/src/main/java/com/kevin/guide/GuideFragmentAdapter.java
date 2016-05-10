package com.kevin.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kevin.R;

/**
 * 引导页数据适配器
 * @author Kevin
 *
 */
public class GuideFragmentAdapter extends FragmentPagerAdapter{
	private static final int[] IMGS = new int[]
			{R.mipmap.guide_1, R.mipmap.guide_2, R.layout.fragment_guide_end};
	//是否最后一页
	private boolean isEnd = false;

	public GuideFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		if(position == IMGS.length -1){
			isEnd = true;
		}
		return GuideFragment.newInstance(IMGS[position % IMGS.length], isEnd);
	}

	@Override
	public int getCount() {
		return IMGS.length;
	}
}
