package com.kelp.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.kelp.R;

public class BuyFragment extends BaseFragment implements OnItemClickListener {
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.rcmd_program_viewpager_item,
				null);
		initViews(rootView);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getDefaultData();
	}

	private ListView listView;
	private TextView errTextView;
	private ProgressBar progressBar;

	private void initViews(View view) {
		listView = (ListView) view.findViewById(R.id.listView);
		listView.setOnItemClickListener(this);
	}

	private void getDefaultData() {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("求带好东西");
		strings.add("求带好东西");
		strings.add("求带好东西");
		strings.add("求带好东西");
		strings.add("求带好东西");
		strings.add("求带好东西");
		strings.add("求带好东西");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity,
				android.R.layout.simple_list_item_1, strings);
		listView.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(mActivity, position + "click", Toast.LENGTH_SHORT)
				.show();
	}

}
