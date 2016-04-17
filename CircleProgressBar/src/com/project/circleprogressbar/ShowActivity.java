package com.project.circleprogressbar;

import android.app.Activity;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.project.circleprogressbar.view.CircleProgressBar;

public class ShowActivity extends Activity {
	private final String TAG = "ShowActivity";
	private CircleProgressBar progressBar;
	private CircleProgressBar progressBar2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(TAG,"onCreate");
		setContentView(R.layout.activity_show);
		progressBar = (CircleProgressBar)findViewById(R.id.circleProgressBar);
		progressBar.setOutCircleShader(new LinearGradient(0, 0, 400, 400, 0xffff0000, 0xff0000ff, Shader.TileMode.CLAMP));
		progressBar.setOutCircleWidth(40);
		progressBar.setInnerCircleShader((new LinearGradient(0, 0, 100, 100, 0xff00ff00, 0xffff0000, Shader.TileMode.MIRROR)));
		progressBar.setText("Hello Android");
		progressBar.setSweepValue(200);
		
		new Thread(){
			public void run(){
				for(int i=0;i<=360;i++){
					progressBar.setSweepValue(i,300);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		Log.e(TAG,"onWindowFocusChanged="+hasFocus);
		int width = progressBar.getWidth();
		int height = progressBar.getHeight();
	}
	
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.e(TAG,"onStart");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e(TAG, "onReStart");
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.e(TAG,"onPause");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.e(TAG,"onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e(TAG , "onDestroy");
	}
	
	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.e(TAG,"onAttachedToWindow");
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.e(TAG,"onResume");
	}
}
