package com.project.androidrobot.modle;

public class Antena extends Organ{
	
	private final float mStartX;
	private final float mStartY;
	private final float mStopX;
	private final float mStopY;
	
	public Antena(final float startX,final float startY, final float stopX, final float stopY){
		mStartX  = startX;
		mStartY = startY;
		mStopX = stopX;
		mStopY = stopY;
	}

	@Override
	public void onDrawSelf() {
		mCanvas.drawLine(mStartX, mStartY,mStopX,mStopY, mPaint);
	}
}
