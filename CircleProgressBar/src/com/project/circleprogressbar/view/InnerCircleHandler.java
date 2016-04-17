package com.project.circleprogressbar.view;

import android.graphics.Paint;
import android.graphics.Shader;

public class InnerCircleHandler extends BaseHandler{
	
	private int mColor;
	private float mRadius;
	private float mDefaultRadius;
	private Shader mShader;
	
	public InnerCircleHandler(){
		mColor = DEFAULT_COLOR;
	}
	
	public void setColor(final int color){
		mColor = color;
	}
	
	public int getColor(){
		return mColor;
	}
	
	public void setRadius(final float radius){
		mRadius = radius;
	}
	
	public float getRadius(){
		if(mRadius<=0)return mDefaultRadius;
		return mRadius;
	}
	
	public void setShader(final Shader shader){
		mShader = shader;
	}
	
	public Shader getShader(){
		return mShader;
	}
	
	public void setDefaultRadius(final float radius){
		mDefaultRadius = radius;
	}
	
	public float getDefaultRadius(){
		return mDefaultRadius;
	}
	
	@Override
	public Paint createPaint() {
		mPaint.setColor(mColor);
		mPaint.setShader(mShader);
		return mPaint;
	}
}
