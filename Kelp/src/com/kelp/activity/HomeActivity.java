package com.kelp.activity;

import java.util.ArrayList;

import com.kelp.R;
import com.kelp.fragment.BuyFragment;
import com.kelp.fragment.IndentBuyFragment;
import com.kelp.fragment.UserCenterFragment;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Bundle;

public class HomeActivity extends BaseActivity implements TabListener,
		OnPageChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initViews();
		setAdapter();
		addInitTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.messagecenter, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			close();
			break;
		case R.id.action_search:
			Toast.makeText(HomeActivity.this, "search", Toast.LENGTH_SHORT)
					.show();
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void addInitTabs() {
		ActionBar actionBar = getSupportActionBar();

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		ActionBar.Tab yuyueTab = getSupportActionBar().newTab();
		yuyueTab.setText("求带");
		yuyueTab.setTabListener(this);
		ActionBar.Tab siXinTab = getSupportActionBar().newTab();
		siXinTab.setText("绑带");
		siXinTab.setTabListener(this);
		ActionBar.Tab beiAtTab = getSupportActionBar().newTab();
		beiAtTab.setText("我的");
		beiAtTab.setTabListener(this);

		getSupportActionBar().addTab(yuyueTab);
		getSupportActionBar().addTab(siXinTab);
		getSupportActionBar().addTab(beiAtTab);
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
		UserCenterFragment userCenterFragment = new UserCenterFragment();
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
			this.fragmentList = fragmentList;
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

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		getSupportActionBar().selectTab(getSupportActionBar().getTabAt(arg0));
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	private void close() {
		finish();
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		int position = arg0.getPosition();
		viewPager.setCurrentItem(position);
	}
}
