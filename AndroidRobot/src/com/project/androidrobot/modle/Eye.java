package com.project.androidrobot.modle;

import android.graphics.Paint;

public class Eye extends Organ{
	
	private float mCenterX;
	private float mCenterY;
	private float mRadius;
	private Paint mPaint;
	
	public Eye(final float x, final float y, final float radius,Paint paint){
		mCenterX = x;
		mCenterY = y;
		mRadius = radius;
		mPaint = paint;
	}
	
	
	public float getCenterX(){
		return mCenterX;
	}
	
	public float getCenterY(){
		return mCenterY;
	}
	
	public float getRadius(){
		return mRadius;
	}


	@Override
	public void onDrawSelf() {
		mCanvas.drawCircle(mCenterX, mCenterY, mRadius, mPaint);
	}
}
