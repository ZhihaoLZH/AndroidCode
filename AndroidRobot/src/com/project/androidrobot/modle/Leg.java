package com.project.androidrobot.modle;

import android.graphics.RectF;

public class Leg extends Organ{
	
	private float mLeft;
	private float mTop;
	private float mRight;
	private float mBottom;
	
	public Leg(final float left, final float top,final float right, final float bottom){
		mLeft = left;
		mTop = top;
		mRight = right;
		mBottom = bottom;
		
	}

	@Override
	public void onDrawSelf() {
		RectF rf = new RectF(mLeft, mTop, mRight, mBottom);
		mCanvas.drawRoundRect(rf, DEFAULT_ROUND_RADIUS, DEFAULT_ROUND_RADIUS, mPaint);
	}
}
