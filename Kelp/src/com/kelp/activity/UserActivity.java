package com.kelp.activity;

import com.kelp.fragment.UserCenterFragment;

import android.app.Fragment;
import android.os.Bundle;

public class UserActivity extends BaseActivity {

	private Fragment userCenterFragment;
	private static final String USER_INFO_TAG = "userInfoTag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			getFragmentManager().beginTransaction()
					.add(userCenterFragment, USER_INFO_TAG).commit();
		} else {
			userCenterFragment = new UserCenterFragment();
			getFragmentManager().beginTransaction()
					.add(userCenterFragment, USER_INFO_TAG).commit();
		}
	}
}
