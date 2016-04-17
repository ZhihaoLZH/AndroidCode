package com.project.circleprogressbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CircleProgressBar extends View {
	
	private final String TAG = "CircleProgressBar";
	private final int DEFAULT_SIZE = 200; //px
	
	
	private Context mContext;
	
	private int mWidth;
	private int mHeight;
	
	private RectF mOval;
	private float mSweepValue;
	private String mText = "";
	
	private InnerCircleHandler mInnerCircleHandler = new InnerCircleHandler();
	private OutCircleHandler mOutCircleHandler = new OutCircleHandler();
	private TextHandler mTextHandler = new TextHandler();
	
	public CircleProgressBar(Context context) {
		super(context);
		Log.e(TAG,"constructor1");
		mContext = context;
	}
	
	public CircleProgressBar(Context context, AttributeSet set){
		super(context, set);
		Log.e(TAG,"constructor2");
		mContext = context;		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.e(TAG, "onMeasure");
		mWidth = getSuitableSize(widthMeasureSpec);
		mHeight = getSuitableSize(heightMeasureSpec);
		setMeasuredDimension(mWidth, mHeight);
	}
	
	private int getSuitableSize(int measureSpec){
		int result = 0;
		int mode = MeasureSpec.getMode(measureSpec);
		int size = MeasureSpec.getSize(measureSpec);
		if(mode==MeasureSpec.EXACTLY){
			result = size;
//			Log.e(TAG,"EXACTLY");
		}else{
			result = DEFAULT_SIZE;
			if(mode==MeasureSpec.AT_MOST){
				result = Math.min(result, size);
//				Log.e(TAG,"AT_MOST");
			}
		}
		return result;
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		Log.e(TAG,"onLayout");
		
		float min = Math.min(mWidth, mHeight);
		
		//a default radius for innerCircle
		//since it will be calculated with mWidth, mHeight
		//so it is initialed in the method
		mInnerCircleHandler.setDefaultRadius(min/8);
		
		//a rectF for innerCircle to be drawn
		float strokeWidth = mOutCircleHandler.getStrokeWidth();
		mOval = new RectF(strokeWidth,strokeWidth,min-strokeWidth, min-strokeWidth);
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		Log.e(TAG, "onDraw");
		super.onDraw(canvas);
	
		float min = Math.min(mWidth, mHeight);
		float centerX = min/2;
		float centerY = min/2;
		
		//draw innerCircle
		Paint paint1 = mInnerCircleHandler.createPaint();
		canvas.drawCircle(centerX, centerY, mInnerCircleHandler.getRadius(), paint1);
		
		//draw text in  innerCircle
		Paint paint2 = mTextHandler.createPaint();
		float textWidth = ((TextPaint)paint2).measureText(mText);
		
		//center show text
		canvas.drawText(mText, 0, mText.length(), centerX-textWidth/2, centerY, paint2);
		
		//draw outCircleArc
		mOutCircleHandler.setStyle(Paint.Style.STROKE);
		Paint paint3 = mOutCircleHandler.createPaint();
		canvas.drawArc(mOval, 270, mSweepValue, false, paint3);
		mOutCircleHandler.setStyle(Paint.Style.FILL);
	}
	
	public void setSweepValue(final float sweepValue){
		mSweepValue = sweepValue;
		invalidate();
	}
	
	public void setSweepValue(final float sweepValue, long timemilis){
		mSweepValue = sweepValue;
		postInvalidateDelayed(timemilis);
	}
	public void setText(String text){
		mText = text;
		invalidate();
	}
	
	public float getInnerCircleRadius(){
		return mInnerCircleHandler.getRadius();
	}
	
	public float getOutCircleWidth(){
		return mOutCircleHandler.getStrokeWidth();
	}
	
	public void setOutCircleWidth(final float width){
		mOutCircleHandler.setStrokeWidth(width);
	}
	
	public void setInnerCircleRadius(final float radius){
		mInnerCircleHandler.setRadius(radius);
	}
	
	public void setTextSize(final int textSize){
		mTextHandler.setTextSize(textSize);
	}
	
	public void setTextColor(final int color){
		mTextHandler.setTextColor(color);
	}
	
	public void setOutCircleColor(final int color){
		mOutCircleHandler.setColor(color);
	}
	
	public void setInnerCircleColor(final int color){
		mInnerCircleHandler.setColor(color);
	}
	
	public void setInnerCircleShader(final Shader shader){
		mInnerCircleHandler.setShader(shader);
	}
	
	public void setOutCircleShader(final Shader shader){
		mOutCircleHandler.setShader(shader);
	}
}
