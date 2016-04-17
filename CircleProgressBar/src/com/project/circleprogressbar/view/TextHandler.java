package com.project.circleprogressbar.view;

import android.graphics.Paint;
import android.text.TextPaint;

public class TextHandler extends BaseHandler{
	
	private  TextPaint mTextPaint;
	private float mTextSize;
	private int mTextColor;
	public TextHandler(){
		mTextPaint = new TextPaint(mPaint);
		mTextSize = DEFAULT_TEXT_SIZE;
		mTextColor = DEFAULT_TEXT_COLOR;
	}
	
	public void setTextSize(final float textSize){
		mTextSize = textSize;
	}
	
	public float getTextSize(){
		return mTextSize;
	}
	
	public void setTextColor(final int textColor){
		mTextColor = textColor;
	}

	public int getTextColor(){
		return mTextColor;
	}
	
	@Override
	public Paint createPaint() {
		mTextPaint.setTextSize(mTextSize>0?mTextSize:DEFAULT_TEXT_SIZE);
		mTextPaint.setColor(mTextColor);
		return mTextPaint;
	}
	
	
}
