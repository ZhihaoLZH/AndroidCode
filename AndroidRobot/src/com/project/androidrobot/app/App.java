package com.project.androidrobot.app;

import android.app.Application;

import com.project.androidrobot.util.ActivityCollector;

public class App extends Application {
	private static Application mApplication = null;
	private static ActivityCollector mCollector = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		mApplication = this;
		mCollector = ActivityCollector.getInstance();
	}
	
	public static ActivityCollector getActivityCollector(){
		return mCollector;
	}
	
	public static Application getApplication(){
		return mApplication;
	}
}
