package com.kelp.activity;

import java.util.ArrayList;

import com.kelp.R;
import com.kelp.fragment.BuyFragment;
import com.kelp.fragment.IndentBuyFragment;
import com.kelp.fragment.UserCenterFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class HomeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initViews();
		setAdapter();
	}

	private ViewPager viewPager;

	FragmentPagerAdapter adapter;
	ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

	private void initViews() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);

	}

	private void setAdapter() {
		BuyFragment buyFragment = new BuyFragment();
		fragmentList.add(buyFragment);
		IndentBuyFragment indentBuyFragment = new IndentBuyFragment();
		fragmentList.add(indentBuyFragment);
		UserCenterFragment userCenterFragment=new UserCenterFragment();
		fragmentList.add(userCenterFragment);
		adapter = new KelpFragmentPagerAdapter(getSupportFragmentManager(),
				fragmentList);
		viewPager.setAdapter(adapter);
	}

	public static class KelpFragmentPagerAdapter extends FragmentPagerAdapter {
		private ArrayList<Fragment> fragmentList;

		public KelpFragmentPagerAdapter(FragmentManager fm,
				ArrayList<Fragment> fragmentList) {
			super(fm);
			this.fragmentList=fragmentList;
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragmentList == null ? null : fragmentList.get(arg0);
		}

		@Override
		public int getCount() {
			return fragmentList == null ? 0 : fragmentList.size();
		}

	}
}
