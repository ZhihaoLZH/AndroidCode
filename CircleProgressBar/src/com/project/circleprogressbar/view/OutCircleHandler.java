package com.project.circleprogressbar.view;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader;

public class OutCircleHandler extends BaseHandler{
	
	private float mStrokeWidth;
	private int mColor;
	private Shader mShader;
	
	public OutCircleHandler(){
		mColor = DEFAULT_COLOR;
	}
	
	public float getStrokeWidth(){
		return mStrokeWidth;
	}
	
	public void setStrokeWidth(final float width){
		mStrokeWidth = width;
	}
	
	public int getColor(final int color){
		return mColor;
	}
	
	public void setColor(final int color){
		mColor = color;
	}
	
	public Shader getShader(){
		return mShader;
	}
	
	public void setShader(final Shader shader){
		mShader = shader;
	}
	
	public Paint createPaint(){
		mPaint.setStrokeWidth(mStrokeWidth);
		mPaint.setColor(mColor);
		mPaint.setShader(mShader);
		return mPaint;
	}
	
	public void setStyle(final Style style){
		mPaint.setStyle(Paint.Style.STROKE);
	}
}
