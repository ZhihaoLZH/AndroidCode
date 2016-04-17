package com.project.androidrobot.util;

import java.util.ArrayList;

import android.app.Activity;

public class ActivityCollector {
	
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private static ActivityCollector  mInstance = null;
	
	private ActivityCollector(){
		
	}
	
	public static ActivityCollector getInstance(){
		if(null==mInstance){
			mInstance = new ActivityCollector();
		}
		return mInstance;
	}
	
	public void add(final Activity activity){
		if(activities!=null){
			activities.add(activity);
		}
	}
	
	public void remove(final Activity activity){
		if(activities!=null){
			activities.remove(activity);
		}
	}
	
	public void finishAll(){
		for(Activity activity:activities){
			activity.finish();
		}
	}
}
