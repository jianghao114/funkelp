package com.kelp.fragment;

import com.kelp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserCenterFragment extends BaseFragment implements OnClickListener {
	private Activity mActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mActivity = null;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.userinfo_view, null);
			initBaseInfo(rootView);
			initEventInfo(rootView);
			setListeners(rootView);
		} else {
			((ViewGroup) rootView.getParent()).removeView(rootView);

		}
		return rootView;
	}

	private ImageView icon, gender;
	private TextView userNameTextView, userLevelTextView, signatureTextView;

	private void initBaseInfo(View view) {
		icon = (ImageView) view.findViewById(R.id.head_pic);
		userNameTextView = (TextView) view.findViewById(R.id.name);
		userLevelTextView = (TextView) view.findViewById(R.id.level);
		signatureTextView = (TextView) view.findViewById(R.id.signnature);
	}

	private TextView fellowTextView, fansTextView, commentTextView;
	private ImageView fansTipImageView, msgTipImageView;
	private TextView bindView;
	private RelativeLayout logOffLayout;

	private void initEventInfo(View view) {
		bindView = (TextView) view.findViewById(R.id.myBind);
		logOffLayout = (RelativeLayout) view.findViewById(R.id.logoff_layout);
		msgTipImageView = (ImageView) view.findViewById(R.id.msg_pic);
	}

	private void setListeners(View view) {
		icon.setOnClickListener(this);
		view.findViewById(R.id.myMsg).setOnClickListener(this);
		view.findViewById(R.id.myChannel).setOnClickListener(this);
		view.findViewById(R.id.myMedal).setOnClickListener(this);
		view.findViewById(R.id.myZhuiju).setOnClickListener(this);
		view.findViewById(R.id.myCache).setOnClickListener(this);
		view.findViewById(R.id.mySetting).setOnClickListener(this);
		view.findViewById(R.id.statement).setOnClickListener(this);
		view.findViewById(R.id.zuxiao).setOnClickListener(this);
		bindView.setOnClickListener(this);
		signatureTextView.setOnClickListener(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		updateUserInfo();
	}

	private void setUnLogInValue() {
		userNameTextView.setText(R.string.user_info_my_account);
		userLevelTextView.setText("");
		signatureTextView.setText(R.string.user_info_my_login);
		fellowTextView.setText("");
		fansTextView.setText("");
		commentTextView.setText("");
		bindView.setVisibility(View.GONE);
		icon.setImageResource(R.drawable.my_headpic);
		logOffLayout.setVisibility(View.GONE);
		gender.setVisibility(View.GONE);
	}

	private void updateUserInfo() {
		String name = "name";
		if (name != null) {
			userNameTextView.setText(name);
		}
		String lvl = "11";
		if (lvl != null) {
			userLevelTextView.setText("Lv " + lvl);
		}
		String signature = "signature";
		if (signature != null) {
			signatureTextView.setText(signature);
		}

		bindView.setVisibility(View.VISIBLE);
		logOffLayout.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

	};

	public void inheriteActivityResult(int requestCode, int resultCode,
			Intent data) {

	}

}
