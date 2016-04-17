package com.project.androidrobot.activity;

import com.project.androidrobot.app.App;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		App.getActivityCollector().add(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		App.getActivityCollector().remove(this);
	}
}
