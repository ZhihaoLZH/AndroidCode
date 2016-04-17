package com.project.androidrobot.modle;

import android.graphics.RectF;


public class Head extends Organ{
	private float mLeft;
	private float mTop;
	private float mRight;
	private float mBottom;
	private float mStartAngle;
	private float mSweepAngle;
	
	public Head(final float left, final float top, final float right, final float bottom){
		mLeft = left;
		mTop = top;
		mRight =  right;
		mBottom = bottom;
		mStartAngle = 180;
		mSweepAngle = 180;
	}

	@Override
	public void onDrawSelf() {
		RectF rf = new RectF(mLeft, mTop, mRight, mBottom);
		mCanvas.drawArc(rf, mStartAngle, mSweepAngle, true, mPaint);
	}
}
