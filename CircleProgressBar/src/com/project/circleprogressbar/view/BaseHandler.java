package com.project.circleprogressbar.view;

import android.graphics.Color;
import android.graphics.Paint;

public abstract class BaseHandler {
	protected Paint mPaint;
	protected final int DEFAULT_TEXT_SIZE = 20;	//px
	protected final int DEFAULT_COLOR = Color.GRAY;
	protected final int DEFAULT_TEXT_COLOR = Color.WHITE;
	
	public BaseHandler(){
		mPaint = new Paint();
	}
	
	public abstract Paint createPaint();
}
